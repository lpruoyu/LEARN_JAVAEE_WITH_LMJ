package programmer.lp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        final ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 10; i++) {
            pool.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }
        pool.shutdown();
    }

    public static void main10(String[] args) {
        // synchronized是可重入的
        synchronized ("1") {
            synchronized ("1") {
                System.out.println("1");
            }
        }
    }

    public static void main9(String[] args) {
        /*
            1.调用wait、notify、notifyAll方法的obj对象必须是同一个
            2.调用wait、notify、notifyAll方法的线程必须拥有该obj对象的内部锁
         */
        Drop drop = new Drop();
        Consumer consumer = new Consumer(drop);
        Producer producer = new Producer(drop);
        new Thread(consumer).start();
        new Thread(producer).start();
    }

    public static void main8(String[] args) {
        Runnable station = new Station();
        for (int i = 1; i < 5; i++) {
            new Thread(station, "线程" + i).start();
        }
    }

    public static void main7(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println("t1-begin");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t1-end");
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                System.out.println("t2-begin");
                System.out.println("t1.state: " + t1.getState());
                System.out.println("t1.isAlive: " + t1.isAlive());
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t1.state: " + t1.getState());
                System.out.println("t1.isAlive: " + t1.isAlive());
                System.out.println("t2-end");
            }
        };
        t1.start();
        t2.start();
    }

    public static void main6(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println(1);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(2);
            }
        };
        thread.start();
        try {
            // 让该线程插队。
            // 也就是说，让调用join方法的线程执行完后再继续执行main线程（main线程是当前上下文线程）
            thread.join();
            // thread.join(1000); // 当前线程（main线程）会等你1秒，如果1秒之后你还没有执行完，那么当前线程就不等了。
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(3);
        System.out.println(thread.getState()); // TERMINATED
        System.out.println(thread.isAlive()); // false
    }

    public static void main5(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println(1);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    // 如果线程在sleep的时候被干扰（阻断、中断），就会出现该异常
                    // 如果线程被“吵醒”的话，那么该线程就不会继续sleep了，其它（下面）的代码就会立即得到执行
                    System.out.println(Thread.currentThread().getName() + "线程正在sleep时，被打扰（阻断）了");
                }
                System.out.println(2);
            }
        };
        thread.start();

        // 让main方法睡1秒钟，以确保上面的thread得到运行
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt(); // 阻断线程sleep（叫该线程“起床”）
    }

    public static void main4(String[] args) {
        System.out.println(1);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // 如果线程在sleep的时候被干扰（阻断），就会出现该异常
            e.printStackTrace();
        }
        System.out.println(2);
    }

    public static void main3(String[] args) {
        Thread otherThread = new Thread("other thread") {
            @Override
            public void run() {
                System.out.println("我是其它线程");
            }
        };
        System.out.println(otherThread.getState()); // NEW
        otherThread.start();
        System.out.println(otherThread.getState()); // RUNNABLE
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(otherThread.getState()); // TERMINATED
    }

    public static void main2(String[] args) {
//        new MusicThread("music").start();
//        new Thread(new ResourcesThread()).start();
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("new thread");
            }
        };
        thread.start();
    }

    public static void main1(String[] args) {
        Thread threadMax = new Thread(() -> {
            System.out.println(Thread.currentThread());
        }, "threadMax");
        Thread threadMin = new Thread(() -> {
            System.out.println(Thread.currentThread());
        }, "threadMin");
        Thread threadNorm = new Thread(() -> {
            System.out.println(Thread.currentThread());
        }, "threadNorm");
        threadMax.setPriority(Thread.MAX_PRIORITY);
        threadMin.setPriority(Thread.MIN_PRIORITY);
        threadNorm.setPriority(Thread.NORM_PRIORITY);
        threadMax.start();
        threadMin.start();
        threadNorm.start();
    }

}

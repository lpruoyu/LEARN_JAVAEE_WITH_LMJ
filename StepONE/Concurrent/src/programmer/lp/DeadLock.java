package programmer.lp;

public class DeadLock {
    private static final Object A = new Object();
    private static final Object B = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (A) {
                System.out.println("thread a - A");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B) {
                    System.out.println("thread a - B");
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (B) {
                System.out.println("thread b - B");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (A) {
                    System.out.println("thread b - A");
                }
            }
        }).start();
    }
}

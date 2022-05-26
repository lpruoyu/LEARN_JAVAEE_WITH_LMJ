package programmer.lp;

public class Main {

    public static void main(String[] args) {
        // ThreadLocal<T>
    }

    public static void main1(String[] args) {
        // Runnable只是一个接口（FunctionalInterface）
        // Thread类才会创建线程，才有start方法
        System.out.println(Thread.currentThread());
        new Runnable(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread());
            }
        }.run();
    }

}

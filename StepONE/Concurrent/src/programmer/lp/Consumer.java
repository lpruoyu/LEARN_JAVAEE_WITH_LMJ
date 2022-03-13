package programmer.lp;

public class Consumer implements Runnable {
    private Drop drop;
    public Consumer(Drop drop) {
        this.drop = drop;
    }
    @Override
    public void run() {
        String food;
        while ((food = drop.get()) != null) {
//            try {
//                Thread.sleep(1500);
//            } catch (InterruptedException e) {}
            System.out.println("消费了：" + food);
        }
    }
}

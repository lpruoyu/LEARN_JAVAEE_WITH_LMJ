package programmer.lp;

public class Producer implements Runnable{
    private Drop drop;
    public Producer(Drop drop) {
        this.drop = drop;
    }
    @Override
    public void run() {
        String[] foods = {"beef", "bread", "apple", "cookie", "banana"};
        for (String food : foods) {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {}
            drop.add(food);
        }
        drop.add(null);
    }
}

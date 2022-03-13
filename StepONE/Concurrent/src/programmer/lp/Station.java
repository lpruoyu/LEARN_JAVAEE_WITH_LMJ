package programmer.lp;

import java.util.concurrent.locks.ReentrantLock;

public class Station implements Runnable {
    private final ReentrantLock lock = new ReentrantLock();
    private int tickets = 100;

    public boolean saleTicket() {
        try{
            lock.lock();

            if (tickets < 1) return false;
            tickets--;
            System.out.println(Thread.currentThread().getName() + "卖了一张票，还剩" + tickets + "张票。");
            return tickets > 0;
        }finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        while (saleTicket()) ;
    }
}

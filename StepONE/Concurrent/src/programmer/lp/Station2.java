package programmer.lp;

public class Station2 implements Runnable {
    private int tickets = 100;

    public synchronized boolean saleTicket() {
        if (tickets < 1) return false;
        tickets--;
        System.out.println(Thread.currentThread().getName() + "卖了一张票，还剩" + tickets + "张票。");
        return tickets > 0;
    }

//    public boolean saleTicket() {
////        只要是锁住同一个对象即可
////        synchronized ("123") {
////        synchronized (Station.class) {
//        synchronized (this) {
//            if (tickets < 1) return false;
//            tickets--;
//            System.out.println(Thread.currentThread().getName() + "卖了一张票，还剩" + tickets + "张票。");
//            return tickets > 0;
//        }
//    }

    /**
     * 卖一张票
     *
     * @return 是否还有票可以卖
     */
//    public boolean saleTicket() {
//        if (tickets < 1) return false;
//        /*
//            tickets--;
//            相当于：
//            tickets = tickets - 1;
//            相当于：
//            int oldTickets = tickets; // 读
//            tickets = oldTickets - 1; // 写
//
//            既有读操作，又有写操作。
//         */
//        tickets--;
//        System.out.println(Thread.currentThread().getName() + "卖了一张票，还剩" + tickets + "张票。");
//        return tickets > 0;
//    }
    @Override
    public void run() {
        while (saleTicket()) ;
    }
}

package programmer.lp;

public class Drop {
    private String food;
    // isEmpty：true：消费者需要等待生产者
    // isEmpty：false：生产者需要等待消费者
    private boolean isEmpty = true;

    // 使用while循环代替if循环的目的是：
    // 当wait时出现异常，还会继续wait，而不是执行之后的代码

    public synchronized void add(String food) {
        if(isEmpty) { // 如果没有food
            this.food = food; // 直接生产food
            isEmpty = false; // 生产了food之后，就不为空了
            notifyAll(); // 生产好food后，就可以通知消费者线程消费food了
        }else { // 如果food还有，还没有被消费者消费完毕
            while(!isEmpty) {
                try { // 等待消费者消费完毕food
                    wait();
                } catch (InterruptedException e) {}
            }
            this.food = food; // 消费者消费完food后，就可以生产food了
            isEmpty = false; // 生产了food之后，就不为空了
            notifyAll(); // 就可以通知消费者线程消费food了
        }
    }
    public synchronized String get() {
        while(isEmpty) { // 如果此时没有food，也就是生产者线程还没有生产完毕food
            try { // 等待生产者生产food
                wait();
            } catch (InterruptedException e) {}
        } // 当生产者生产好了food之后，就可以消费food了
        // 此时有food可以消费
        isEmpty = true; // 消费了food，那么就应该为空了
        notifyAll(); // 通知生产者线程，我已经消费了food，你可以继续生产food了
        return food;
    }

//    public synchronized void add(String food) {
//        if(isEmpty) { // 如果没有food
//            this.food = food; // 直接生产food
//            isEmpty = false; // 生产了food之后，就不为空了
//            notifyAll(); // 生产好food后，就可以通知消费者线程消费food了
//        }else { // 如果food还有，还没有被消费者消费完毕
//            try { // 等待消费者消费完毕food
//                wait();
//            } catch (InterruptedException e) {}
//            this.food = food; // 消费者消费完food后，就可以生产food了
//            isEmpty = false; // 生产了food之后，就不为空了
//            notifyAll(); // 就可以通知消费者线程消费food了
//        }
//    }
//    public synchronized String get() {
//        if(isEmpty) { // 如果此时没有food，也就是生产者线程还没有生产完毕food
//            try { // 等待生产者生产food
//                wait();
//            } catch (InterruptedException e) {}
//        } // 当生产者生产好了food之后，就可以消费food了
//        // 此时有food可以消费
//        isEmpty = true; // 消费了food，那么就应该为空了
//        notifyAll(); // 通知生产者线程，我已经消费了food，你可以继续生产food了
//        return food;
//    }
}

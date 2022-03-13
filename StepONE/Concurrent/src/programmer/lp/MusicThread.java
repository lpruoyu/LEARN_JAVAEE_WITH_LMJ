package programmer.lp;

public class MusicThread extends Thread {
    public MusicThread() {
    }
    public MusicThread(String name) {
        super(name);
    }
    @Override
    public void run() {
        System.out.println("播放音乐----" + getName());
    }
}

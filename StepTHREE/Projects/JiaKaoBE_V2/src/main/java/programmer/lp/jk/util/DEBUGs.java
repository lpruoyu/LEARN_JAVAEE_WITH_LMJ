package programmer.lp.jk.util;

public final class DEBUGs {
    private static final boolean DEBUG = true;

    public static void run(Runnable runnable) {
        if (!DEBUG) return;
        if (runnable == null) return;
        runnable.run();
    }
}

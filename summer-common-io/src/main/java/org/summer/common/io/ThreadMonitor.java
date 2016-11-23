package org.summer.common.io;

/**
 * Created by Administrator on 2016/11/23 0023.
 */
public class ThreadMonitor implements Runnable {

    private final long timeout;
    private final Thread thread;

    public ThreadMonitor(long timeout, Thread thread) {
        this.thread = thread;
        this.timeout = timeout;
    }

    public static Thread start(final long timeout) {
        return start(Thread.currentThread(), timeout);
    }

    public static Thread start(final Thread thread, final long timeout) {
        Thread monitor = null;
        if (timeout > 0) {
            final ThreadMonitor threadMonitor = new ThreadMonitor(timeout, thread);
            monitor = new Thread(threadMonitor, ThreadMonitor.class.getSimpleName());
            monitor.setDaemon(true);
            monitor.start();
        }
        return monitor;
    }

    public static void stop(final Thread thread) {
        if (thread != null) {
            thread.interrupt();
        }
    }

    public void run() {
        try {
            sleep(timeout);
            Thread.interrupted();
        } catch (InterruptedException e) {

        }
    }

    private static void sleep(final long ms) throws InterruptedException {
        long finishAt = System.currentTimeMillis() + ms;
        long remaining = finishAt;
        do {
            Thread.sleep(remaining);
            remaining = finishAt - System.currentTimeMillis();
        } while (remaining > 0);
    }
}

package me.lokka30.microlib;

/**
 * This is a small class useful for timing simple things such as the time required to start-up a plugin or run a command.
 *
 * @author lokka30
 */
@SuppressWarnings("unused")
public class QuickTimer {

    private long start;

    public QuickTimer() {
        start();
    }

    public QuickTimer(long start) {
        this.start = start;
    }

    /**
     * (re)start the timer.
     */
    public void start() {
        start = System.currentTimeMillis();
    }

    /**
     * @return time (millis) since start time
     */
    public long getTimer() {
        return System.currentTimeMillis() - start;
    }
}

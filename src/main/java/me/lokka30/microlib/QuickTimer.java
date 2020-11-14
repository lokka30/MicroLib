package me.lokka30.microlib;

@SuppressWarnings("unused")
public class QuickTimer {

    private long millis = 0;
    private long timer = 0;

    public void start() {
        timer = 0;
        millis = System.currentTimeMillis();
    }

    public long getTimer() {
        //reset millis and dump into timer
        if (timer != 0) {
            timer = timer + (System.currentTimeMillis() - millis);
        }
        millis = System.currentTimeMillis();

        //return the current timer
        return timer;
    }
}

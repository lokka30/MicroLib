/*
 * Copyright (c) 2020-2021 lokka30. Use of this source code is governed by the MIT license that can be found in the LICENSE.md file.
 * This class is bundled inside the MicroLib resource, a library purposed for Bukkit/SpigotMC plugin developers. Read more about the resource here: https://www.spigotmc.org/resources/microlib.84017/
 */

package me.lokka30.microlib.maths;

import org.jetbrains.annotations.NotNull;

/**
 * This is a small class useful for timing simple things such as the time required to start up a plugin or run a command.
 * <p>
 * Mark the starting point of the timer with `QuickTimer timer = new QuickTimer()`, then get the time (in milliseconds)
 * since it started using `QuickTimer#getTimer()`.
 *
 * @author lokka30
 * @version 3.1.3
 * @since 2.1.0
 */
@SuppressWarnings("unused")
public class QuickTimer {

    private long startTime;

    /**
     * Instantiates a new quick timer.
     *
     * @param timerUnits The timer units which you want to use.
     * @param startTime  The starting time.
     * @since 3.1.3
     */
    public QuickTimer(final @NotNull TimerUnits timerUnits, long startTime) {
        this.startTime = startTime;
        switch (timerUnits) {
            case MILLISECONDS:
                startMilliTimer();
                break;
            case NANOSECONDS:
                startNanoTimer();
                break;
        }
    }

    /**
     * Instantiates a new quick timer.
     *
     * @param startTime the starting time.
     * @since 2.4.0
     */
    public QuickTimer(long startTime) {
        this.startTime = startTime;
    }

    /**
     * Re/starts the timer (milliseconds).
     *
     * @since 2.4.0
     */
    public void startMilliTimer() {
        startTime = System.currentTimeMillis();
    }

    /**
     * Re/starts the timer (nanoseconds).
     *
     * @since 3.1.3
     */
    public void startNanoTimer() {
        startTime = System.nanoTime();
    }

    /**
     * Gets millis timer.
     *
     * @return Time (millis) since start time.
     * @since 2.2.0
     */
    public long getTimer() {
        return System.currentTimeMillis() - startTime;
    }

    /**
     * Gets nano timer.
     *
     * @return Time (nano) since start time.
     * @since 3.1.3
     */
    public long getNanoTimer() {
        return System.nanoTime() - startTime;
    }

    /**
     * Defines quick timer type.
     *
     * @since 3.1.3
     */
    public enum TimerUnits {
        /**
         * Represents time in milliseconds.
         * @since 3.1.3
         */
        MILLISECONDS,
        /**
         * Represents time in nanoseconds.
         * @since 3.1.3
         */
        NANOSECONDS
    }
}

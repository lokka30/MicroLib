/*
 * Copyright (c) 2020-2022 lokka30. Use of this source code is governed by the MIT license that can be found in the LICENSE.md file.
 * This class is bundled inside the MicroLib resource, a library purposed for Bukkit/SpigotMC plugin developers. Read more about the resource here: https://www.spigotmc.org/resources/microlib.84017/
 */

package me.lokka30.microlib.maths;

import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/**
 * This is a small class useful for timing simple things such as
 * the time required to start up a plugin or complete the execution
 * of a command.
 *
 * @author lokka30
 * @since 2.1.0
 */
@SuppressWarnings("unused")
public class QuickTimer {

    private long startingTime;
    private final TimeUnit timeUnit;

    /**
     * Instantiates a new QuickTimer.
     *
     * @param timeUnit The time unit which you want to use.
     * @since 3.2.0
     */
    public QuickTimer(final @NotNull TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
        reset();
    }

    /**
     * Instantiates a new QuickTimer.
     *
     * @param timeUnit The time unit which you want to use.
     * @param startingTime the specific time (as a {@code System.nanoTime()}) to start with instead.
     * @since 3.2.0
     */
    public QuickTimer(final @NotNull TimeUnit timeUnit, final long startingTime) {
        this.timeUnit = timeUnit;
        this.startingTime = startingTime;
    }

    /**
     * Restarts the timer by setting the {@code startingTime} to when this method is ran.
     *
     * @since 3.2.0
     */
    public void reset() {
        startingTime = System.nanoTime();
    }

    /**
     * Gets how much time has surpassed since the {@code startingTime}.
     *
     * @return the duration.
     * @since 3.2.0
     */
    public long getDuration() {
        return TimeUnit.NANOSECONDS.convert(System.nanoTime() - startingTime, timeUnit);
    }

    /**
     * Get which time unit is being used.
     *
     * @return which time unit is being used.
     * @since 3.2.0
     */
    public TimeUnit getTimeUnit() { return timeUnit; }
}

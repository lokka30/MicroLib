/*
 * Copyright (c) 2020-2021 lokka30. Use of this source code is governed by the MIT license that can be found in the LICENSE.md file.
 * This class is bundled inside the MicroLib resource, a library purposed for Bukkit/SpigotMC plugin developers. Read more about the resource here: https://www.spigotmc.org/resources/microlib.84017/
 */

package me.lokka30.microlib.maths;

import java.util.concurrent.ThreadLocalRandom;

/**
 * This class contains a bunch of methods
 * that make it simpler to use random numbers,
 * booleans, and chances.
 *
 * @author lokka30
 * @since 2.4.0
 */
@SuppressWarnings("unused")
public class Randoms {

    /**
     * @param min 'from' (minimum value)
     * @param max 'to' (maximum value)
     * @return random number from min to max
     * @author lokka30
     * @see ThreadLocalRandom#nextInt(int, int)
     * @since 2.4.0
     */
    public static int generateRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    /**
     * @param min 'from' (minimum value)
     * @param max 'to' (maximum value)
     * @return random number from min to max
     * @author lokka30
     * @see ThreadLocalRandom#nextDouble(double, double)
     * @since 2.4.0
     */
    public static double generateRandomDouble(double min, double max) {
        return ThreadLocalRandom.current().nextDouble(min, max + 1);
    }

    /**
     * @param min 'from' (minimum value)
     * @param max 'to' (maximum value)
     * @return random number from min to max
     * @author lokka30
     * @see ThreadLocalRandom#nextLong(long, long)
     * @since 2.4.0
     */
    public static long generateRandomLong(long min, long max) {
        return ThreadLocalRandom.current().nextLong(min, max + 1);
    }

    /**
     * @return a randomn boolean
     * @author lokka30
     * @see ThreadLocalRandom#nextBoolean()
     * @since 2.4.0
     */
    public static boolean generateRandomBoolean() {
        return ThreadLocalRandom.current().nextBoolean();
    }

    /**
     * @param chance From 0 to 100, probability of returning 'true'.
     * @return whether the chance was successful.
     * @author lokka30
     * @see Randoms#generateRandomDouble(double, double)
     * @since 2.4.0
     */
    public static boolean chance(double chance) {
        return Randoms.generateRandomDouble(0, 100) <= chance;
    }
}

/*
 * Copyright (c) 2020-2022 lokka30. Use of this source code is governed by the MIT license that can be found in the LICENSE.md file.
 * This class is bundled inside the MicroLib resource, a library purposed for Bukkit/SpigotMC plugin developers. Read more about the resource here: https://www.spigotmc.org/resources/microlib.84017/
 */

package me.lokka30.microlib.maths;

import java.util.concurrent.ThreadLocalRandom;

/**
 * This class contains a bunch of methods
 * that make it simpler to use random numbers,
 * booleans, and chances.
 *
 * @author lokka30, _ProfliX_
 * @since 2.4.0
 */
@SuppressWarnings("unused")
public class Randoms {

    /**
     * Generates random int.
     *
     * @param min 'from' (minimum value)
     * @param max 'to' (maximum value)
     * @return random number from min to max.
     * @since 2.4.0
     */
    public static int generateRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    /**
     * Generates random double.
     *
     * @param min 'from' (minimum value)
     * @param max 'to' (maximum value)
     * @return random number from min to max.
     * @since 2.4.0
     */
    public static double generateRandomDouble(double min, double max) {
        return ThreadLocalRandom.current().nextDouble(min, max + 1);
    }

    /**
     * Generates random long.
     *
     * @param min 'from' (minimum value)
     * @param max 'to' (maximum value)
     * @return random number from min to max.
     * @since 2.4.0
     */
    public static long generateRandomLong(long min, long max) {
        return ThreadLocalRandom.current().nextLong(min, max + 1);
    }

    /**
     * Generates random float.
     *
     * @param min 'from' (minimum value)
     * @param max 'to' (maximum value)
     * @return random number from min to max.
     * @since 3.1.3
     */
    public static float generateRandomFloat(float min, float max) {
        return (float) generateRandomDouble(min, max);
    }

    /**
     * Generates random boolean.
     *
     * @return a random boolean.
     * @since 2.4.0
     */
    public static boolean generateRandomBoolean() {
        return ThreadLocalRandom.current().nextBoolean();
    }

    /**
     * Checks whether the chance was successful.
     *
     * @param chance From 0 to 100, probability of returning 'true'.
     * @return True if yes, otherwise false.
     * @since 2.4.0
     */
    public static boolean chance(double chance) {
        return Randoms.generateRandomDouble(0, 100) <= chance;
    }
}

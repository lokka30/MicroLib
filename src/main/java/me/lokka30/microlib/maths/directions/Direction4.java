/*
 * Copyright (c) 2020-2021 lokka30. Use of this source code is governed by the MIT license that can be found in the LICENSE.md file.
 * This class is bundled inside the MicroLib resource, a library purposed for Bukkit/SpigotMC plugin developers. Read more about the resource here: https://www.spigotmc.org/resources/microlib.84017/
 */

package me.lokka30.microlib.maths.directions;

import org.bukkit.Location;

/**
 * This enum contains 4 (four) Direction constants
 * that are obtained using the 'getDirection' method.
 * <p>
 * The number in the name of this enum is equal to
 * the amount of constants it contains - the more
 * constants, the greater the precision, although
 * the more constants your code must consider.
 * <p>
 * Plugin developers may find this enum useful if
 * their plugin contains directions.
 *
 * @author lokka30
 * @see Location#getPitch()
 * @since 2.4.0
 */
@SuppressWarnings("unused")
public enum Direction4 {

    /*
     * List of Directions, alongside the
     * minimum Pitch value required to
     * translate into its respective Direction.
     *
     * The Pitch value of a location in Minecraft
     * ranges from -180 to 180, which is why each
     * Direction has such minPitch values set.
     */
    NORTH(-135),
    EAST(-45),
    SOUTH(45),
    WEST(135);

    /* Storing the minPitch of each Direction */
    Direction4(double minPitch) {
        this.minPitch = minPitch;
    }

    public final double minPitch;

    /* Translate a Pitch into a Direction */
    public static Direction4 getDirection(float pitch) {
        if (pitch > WEST.minPitch) {
            return WEST;
        } else if (pitch > SOUTH.minPitch) {
            return SOUTH;
        } else if (pitch > EAST.minPitch) {
            return EAST;
        } else {
            return NORTH;
        }
    }
}

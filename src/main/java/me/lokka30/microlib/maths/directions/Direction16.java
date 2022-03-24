/*
 * Copyright (c) 2020-2021 lokka30. Use of this source code is governed by the MIT license that can be found in the LICENSE.md file.
 * This class is bundled inside the MicroLib resource, a library purposed for Bukkit/SpigotMC plugin developers. Read more about the resource here: https://www.spigotmc.org/resources/microlib.84017/
 */

package me.lokka30.microlib.maths.directions;

import org.bukkit.Location;

/**
 * This enum contains 16 (sixteen) Direction constants
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
 * @since 2.4.0
 */
@SuppressWarnings("unused")
public enum Direction16 {

    /*
     * List of Directions, alongside the
     * minimum Pitch value required to
     * translate into its respective Direction.
     *
     * The Pitch value of a location in Minecraft
     * ranges from -180 to 180, which is why each
     * Direction has such minPitch values set.
     */
    NORTH(-180),
    NORTH_NORTH_EAST(-157.5),
    NORTH_EAST(-135),
    NORTH_EAST_EAST(-112.5),
    EAST(-90),
    SOUTH_EAST_EAST(-67.5),
    SOUTH_EAST(-45),
    SOUTH_SOUTH_EAST(-22.5),
    SOUTH(0),
    SOUTH_SOUTH_WEST(22.5),
    SOUTH_WEST(45),
    SOUTH_WEST_WEST(67.5),
    WEST(90),
    NORTH_WEST_WEST(112.5),
    NORTH_WEST(135),
    NORTH_NORTH_WEST(157.5);

    /**
     * Storing the minPitch of each Direction.
     *
     * @param minPitch the min pitch.
     * @since 2.4.0
     */
    Direction16(double minPitch) {
        this.minPitch = minPitch;
    }

    public final double minPitch;

    /**
     * Gets direction.
     * Translates a Pitch into a Direction.
     *
     * @param pitch the pitch to translate into a direction.
     * @return the direction translated from pitch.
     * @since 2.4.0
     */
    public static Direction16 getDirection(float pitch) {
        if (pitch > NORTH_NORTH_WEST.minPitch) {
            return NORTH_NORTH_WEST;
        } else if (pitch > NORTH_WEST.minPitch) {
            return NORTH_WEST;
        } else if (pitch > NORTH_WEST_WEST.minPitch) {
            return NORTH_WEST_WEST;
        } else if (pitch > WEST.minPitch) {
            return WEST;
        } else if (pitch > SOUTH_WEST_WEST.minPitch) {
            return SOUTH_WEST_WEST;
        } else if (pitch > SOUTH_WEST.minPitch) {
            return SOUTH_WEST;
        } else if (pitch > SOUTH_SOUTH_WEST.minPitch) {
            return SOUTH_SOUTH_WEST;
        } else if (pitch > SOUTH.minPitch) {
            return SOUTH;
        } else if (pitch > SOUTH_SOUTH_EAST.minPitch) {
            return SOUTH_SOUTH_EAST;
        } else if (pitch > SOUTH_EAST.minPitch) {
            return SOUTH_EAST;
        } else if (pitch > SOUTH_EAST_EAST.minPitch) {
            return SOUTH_EAST_EAST;
        } else if (pitch > EAST.minPitch) {
            return EAST;
        } else if (pitch > NORTH_EAST_EAST.minPitch) {
            return NORTH_EAST_EAST;
        } else if (pitch > NORTH_EAST.minPitch) {
            return NORTH_EAST;
        } else if (pitch > NORTH_NORTH_EAST.minPitch) {
            return NORTH_NORTH_EAST;
        } else {
            return NORTH;
        }
    }
}

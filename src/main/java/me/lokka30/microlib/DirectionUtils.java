package me.lokka30.microlib;

import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author lokka30
 * <p>
 * This class is from the MicroLib resource:
 * - A code library with a bunch of useful things for SpigotMC plugins to utilise.
 * - Available at: https://www.spigotmc.org/resources/microlib.84017/
 * <p>
 * MIT License
 * @version 3
 */
@SuppressWarnings("unused")
public class DirectionUtils {

    public enum Direction {
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

        public final double minPitch;

        Direction(final double minPitch) {
            this.minPitch = minPitch;
        }

        /**
         * @return The lower pitch barrier of the direction
         */
        public double getMinPitch() {
            return minPitch;
        }
    }

    /**
     * Returns a Direction from a given pitch (i.e., Location#getYaw).
     * <p>
     * Yaw must be from -180 to 180, as Minecraft uses these values.
     * <p>
     * The method is inclusive of the larger pitch (e.g. NORTH is
     * greater than -180 but less than and equal to -90).
     *
     * @param pitch pitch to get Direction of
     * @return Direction from given pitch
     */
    @NotNull
    public static Direction getDirection(double pitch) {
        // Limit pitch from -180 to 180.
        pitch = Math.max(-180, pitch);
        pitch = Math.min(180, pitch);

        Direction[] directions = Direction.values();
        Arrays.sort(directions, Comparator.comparing(Direction::getMinPitch));

        for (Direction direction : directions) {
            if (pitch >= direction.getMinPitch()) return direction;
        }

        throw new IllegalStateException("Somehow a valid direction was not found.");
    }

    /**
     * Get the direction from the yaw of given location.
     *
     * @param location Location to get direction of.
     * @return Direction of location.
     */
    @NotNull
    public static Direction getDirection(@NotNull Location location) {
        return getDirection(location.getYaw());
    }
}

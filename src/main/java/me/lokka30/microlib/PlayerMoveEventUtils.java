package me.lokka30.microlib;

import org.bukkit.Location;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * This class contains 2 static methods which can help you increase the performance of your plugin by disregarding when players rotate their head and body.
 *
 * @author lokka30
 */
@SuppressWarnings("unused")
public class PlayerMoveEventUtils {

    /**
     * Has the player moved to a different X, Y or Z coordinate? (e.g. going from x=2 to x=2.1, x=2 to x=3, etc.)
     *
     * @param event the PlayerMoveEvent
     * @return if the player has moved x, y or z in the playermoveevent
     */
    public static boolean hasMovedXYZ(final PlayerMoveEvent event) {
        final Location from = event.getFrom();
        final Location to = event.getTo();

        assert to != null;
        return from.getX() != to.getX() || from.getY() != to.getY() || from.getZ() != to.getZ();
    }

    /**
     * Has the player moved a X, Y or Z coordinate by a full block? (e.g. going from x=2 to x=3, but not x=2 to x=2.1 since it is still on the same block coordinate)
     *
     * @param event the PlayerMoveEvent
     * @return if the player has moved a full x, y or z coordinate
     */
    public static boolean hasMovedFullXYZ(final PlayerMoveEvent event) {
        final Location from = event.getFrom();
        final Location to = event.getTo();

        assert to != null;
        return from.getBlockX() != to.getBlockX() || from.getBlockY() != to.getBlockY() || from.getBlockZ() != to.getBlockZ();
    }
}

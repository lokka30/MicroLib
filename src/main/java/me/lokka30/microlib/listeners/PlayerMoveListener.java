package me.lokka30.microlib.listeners;

import me.lokka30.microlib.events.PlayerMoveFullXYZEvent;
import me.lokka30.microlib.events.PlayerMoveXYZEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * Listens to PlayerMoveEvent to fire PlayerMoveXYZEvent and PlayerMoveFullXYZEvent if the conditions are right
 * Creation Date: 15 September 2020
 *
 * @author lokka30
 * @version 1
 * @since v1.0.0-ALPHA
 */
public class PlayerMoveListener implements Listener {

    @EventHandler
    public void onMove(final PlayerMoveEvent event) {
        Location from = event.getFrom();
        Location to = event.getTo();

        assert to != null;
        if (from.getX() != to.getX() || from.getY() != to.getY() || from.getZ() != to.getZ()) {
            PlayerMoveXYZEvent playerMoveXYZEvent = new PlayerMoveXYZEvent(event.getPlayer(), from, to);
            Bukkit.getPluginManager().callEvent(playerMoveXYZEvent);
            if (playerMoveXYZEvent.isCancelled()) {
                event.setCancelled(true);
            } else {
                event.setFrom(playerMoveXYZEvent.getFrom());
                event.setTo(playerMoveXYZEvent.getTo());
            }
        }
    }

    @EventHandler
    public void onMoveXYZ(final PlayerMoveXYZEvent event) {
        Location from = event.getFrom();
        Location to = event.getTo();

        if (from.getBlockX() != to.getBlockX() || from.getBlockY() != to.getBlockY() || from.getBlockZ() != to.getBlockZ()) {
            PlayerMoveFullXYZEvent playerMoveFullXYZEvent = new PlayerMoveFullXYZEvent(event.getPlayer(), from, to);
            Bukkit.getPluginManager().callEvent(playerMoveFullXYZEvent);

            if (playerMoveFullXYZEvent.isCancelled()) {
                event.setCancelled(true);
            } else {
                event.setFrom(playerMoveFullXYZEvent.getFrom());
                event.setTo(playerMoveFullXYZEvent.getTo());
            }
        }
    }
}

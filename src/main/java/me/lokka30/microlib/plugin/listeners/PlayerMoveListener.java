/*
 * Copyright (c) 2020-2021 lokka30. Use of this source code is governed by the MIT license that can be found in the LICENSE.md file.
 * This class is bundled inside the MicroLib resource, a library purposed for Bukkit/SpigotMC plugin developers. Read more about the resource here: https://www.spigotmc.org/resources/microlib.84017/
 */

package me.lokka30.microlib.plugin.listeners;

import me.lokka30.microlib.events.PlayerMoveFullXYZEvent;
import me.lokka30.microlib.events.PlayerMoveXYZEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * @author lokka30
 * @see PlayerMoveEvent
 * @since v3.0.0
 * <p>
 * This listener functions when MicroLib is installed as a plugin,
 * in the plugins folder of the server of course.
 * <p>
 * This listener does not care if the event is cancelled or not, it
 * simply forwards this status to the two events it calls in the process.
 */
public class PlayerMoveListener implements Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    public void onMove(final PlayerMoveEvent event) {
        if (event.getTo() == null) return;

        /* PlayerMoveFullXYZEvent */
        PlayerMoveFullXYZEvent playerMoveFullXYZEvent = null;

        if (
                event.getFrom().getBlockX() != event.getTo().getBlockX() ||
                        event.getFrom().getBlockY() != event.getTo().getBlockY() ||
                        event.getFrom().getBlockZ() != event.getTo().getBlockZ()) {
            playerMoveFullXYZEvent = new PlayerMoveFullXYZEvent(event.getPlayer(), event.getFrom(), event.getTo());

            Bukkit.getPluginManager().callEvent(playerMoveFullXYZEvent);

            playerMoveFullXYZEvent.setCancelled(event.isCancelled());

            if (playerMoveFullXYZEvent.getTo() != event.getTo()) {
                event.setTo(playerMoveFullXYZEvent.getTo());
            }
        }

        /* PlayerMoveXYZEvent */
        PlayerMoveXYZEvent playerMoveXYZEvent = null;

        if (
                event.getFrom().getX() != event.getTo().getX() ||
                        event.getFrom().getY() != event.getTo().getY() ||
                        event.getFrom().getZ() != event.getTo().getZ()) {
            playerMoveXYZEvent = new PlayerMoveXYZEvent(event.getPlayer(), event.getFrom(), event.getTo());

            Bukkit.getPluginManager().callEvent(playerMoveXYZEvent);

            playerMoveXYZEvent.setCancelled(event.isCancelled());

            if (playerMoveXYZEvent.getTo() != event.getTo()) {
                event.setTo(playerMoveXYZEvent.getTo());
            }
        }

        /* Cancellation */
        boolean isCancelled = event.isCancelled();

        if (playerMoveFullXYZEvent != null && playerMoveFullXYZEvent.isCancelled()) {
            isCancelled = true;
            if (playerMoveXYZEvent != null) playerMoveXYZEvent.setCancelled(true);
        }

        if (playerMoveXYZEvent != null && playerMoveXYZEvent.isCancelled()) {
            isCancelled = true;
            if (playerMoveFullXYZEvent != null) playerMoveFullXYZEvent.setCancelled(true);
        }

        event.setCancelled(isCancelled);
    }
}

/*
 * Copyright (c) 2020-2021 lokka30. Use of this source code is governed by the MIT license that can be found in the LICENSE.md file.
 * This class is bundled inside the MicroLib resource, a library purposed for Bukkit/SpigotMC plugin developers. Read more about the resource here: https://www.spigotmc.org/resources/microlib.84017/
 */

package me.lokka30.microlib.events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * @author lokka30
 * @see org.bukkit.event.player.PlayerMoveEvent
 * @see PlayerMoveFullXYZEvent
 * @since v3.0.0
 * <p>
 * WARNING: This event only fires if MicroLib is installed
 * as a plugin on the server. The event does not fire if
 * MicroLib is shaded into the resource!
 * <p>
 * This event fires when a player has moved to a different
 * X, Y and/or Z coordinate.
 * For example, moving from x=1 to x=2 will fire the event,
 * and, moving from x=1.1 to x=1.7 will also fire the event.
 * However, if the player rotates their head only, the event
 * will not fire. To reiterate, this event only fires if
 * a player has actually move on the X/Y/Z axis.
 * <p>
 * Using this class in your plugin can increase its performance
 * by not running code every time a player moves their head ever
 * so slightly, since minor movements like these fire PlayerMoveEvent,
 * so running lots of code on PlayerMoveEvent may have a poor impact
 * on performance.
 */
@SuppressWarnings("unused")
public class PlayerMoveXYZEvent extends Event implements Cancellable {

    /* HandlerList */
    private static final HandlerList HANDLERS = new HandlerList();

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    /* Event */
    private final Player player;
    private final Location from;
    private Location to;
    private boolean isCancelled = false;

    public PlayerMoveXYZEvent(Player player, Location from, Location to) {
        this.player = player;
        this.from = from;
        this.to = to;
    }

    public Player getPlayer() {
        return player;
    }

    public Location getFrom() {
        return from;
    }

    public Location getTo() {
        return to;
    }

    public void setTo(Location to) {
        this.to = to;
    }

    /* Cancellation */
    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }
}

/*
 * Copyright (c) 2020-2022 lokka30. Use of this source code is governed by the MIT license that can be found in the LICENSE.md file.
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
 * This event fires when a player has moved to a different X, Y and/or Z coordinate.
 * <p>
 * For example, moving from x=1 to x=2 will fire the event, and, moving from x=1.1 to x=1.7 will also fire the event. However, if the player rotates their head only, the event will not fire. To reiterate, this event only fires if a player has actually move on the X/Y/Z axis. <p> Using this class in your plugin can increase its performance by not running code every time a player moves their head ever so slightly, since minor movements like these fire PlayerMoveEvent,
 * so running lots of code on PlayerMoveEvent may have a poor impact on performance.
 *
 * @author lokka30
 * @apiNote This event only fires if MicroLib is installed as a plugin on the server. The event does not fire if MicroLib is shaded into the resource!
 * @see org.bukkit.event.player.PlayerMoveEvent
 * @see PlayerMoveFullXYZEvent
 * @see org.bukkit.event.Cancellable
 * @see org.bukkit.event.Event
 * @since 3.0.0
 */
@SuppressWarnings("unused")
public class PlayerMoveXYZEvent extends Event implements Cancellable {

    /* HandlerList */
    private static final HandlerList HANDLERS = new HandlerList();

    /**
     * Gets the handlers.
     *
     * @return the handler list for this event.
     * @since 3.0.0
     */
    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    /**
     * Gets the handler list for this event.
     *
     * @return the handler list for this event.
     * @since 3.0.0
     */
    @NotNull
    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    /* Event */
    private final Player player;
    private final Location from;
    private Location to;
    private boolean isCancelled = false;

    /**
     * Instantiates a new Player move xyz event.
     *
     * @param player The player which moved.
     * @param from   The location player moved from.
     * @param to     The location player moved to.
     * @since 3.0.0
     */
    public PlayerMoveXYZEvent(Player player, Location from, Location to) {
        this.player = player;
        this.from = from;
        this.to = to;
    }

    /**
     * Get the player who triggered the event.
     *
     * @return The moving player.
     * @since 3.0.0
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets the location player moved from.
     *
     * @return The location player moved from.
     * @since 3.0.0
     */
    public Location getFrom() {
        return from;
    }

    /**
     * Gets the location player moved to.
     *
     * @return The location player moved to.
     * @since 3.0.0
     */
    public Location getTo() {
        return to;
    }

    /**
     * Sets the location to which player will be moved.
     *
     * @param to The location which player will be moved to.
     * @since 3.0.0
     */
    public void setTo(Location to) {
        this.to = to;
    }

    /**
     * Checks whether is event cancelled.
     *
     * @return True if yes, otherwise false.
     * @since 3.0.0
     */
    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    /**
     * Sets the cancelled state of this event.
     *
     * @param isCancelled True if yes, otherwise false.
     * @since 3.0.0
     */
    @Override
    public void setCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }
}

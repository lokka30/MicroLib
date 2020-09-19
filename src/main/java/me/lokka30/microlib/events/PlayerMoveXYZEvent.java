package me.lokka30.microlib.events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * This event is fired when a player moves a X, Y or Z coordinate
 * Creation Date: 15 September 2020
 * @author lokka30
 * @since v1.0.0-ALPHA
 * @version 1
 */
@SuppressWarnings("unused")
public class PlayerMoveXYZEvent extends Event {

    private boolean isCancelled = false;

    private Player player;
    private Location from, to;
    public PlayerMoveXYZEvent(Player player, Location from, Location to) {
        this.player = player;
        this.from = from;
        this.to = to;
    }

    public boolean isCancelled() {
        return this.isCancelled;
    }

    public void setCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }

    private static final HandlerList HANDLERS = new HandlerList();

    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    public Player getPlayer() { return player; }
    public Location getFrom() { return from; }
    public Location getTo() { return to; }
}
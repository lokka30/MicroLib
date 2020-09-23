package me.lokka30.microlib.listeners;

import me.lokka30.microlib.MicroLib;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.metadata.FixedMetadataValue;

/**
 * This listener adds metadata to placaed blocks
 * Creation Date: 15 September 2020
 *
 * @author lokka30
 * @version 1
 * @since v1.0.0-ALPHA
 */
public class PlayerBlockPlaceListener implements Listener {

    private final MicroLib instance;

    public PlayerBlockPlaceListener(MicroLib instance) {
        this.instance = instance;
    }

    @EventHandler
    public void onPlace(final BlockPlaceEvent event) {
        event.getBlock().setMetadata("placed", new FixedMetadataValue(instance, event.getPlayer().getUniqueId().toString()));
    }
}

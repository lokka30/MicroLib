/*
 * Copyright (c) 2020-2021 lokka30. Use of this source code is governed by the MIT license that can be found in the LICENSE.md file.
 * This class is bundled inside the MicroLib resource, a library purposed for Bukkit/SpigotMC plugin developers. Read more about the resource here: https://www.spigotmc.org/resources/microlib.84017/
 */

package me.lokka30.microlib.plugin;

import me.lokka30.microlib.messaging.MicroLogger;
import me.lokka30.microlib.plugin.listeners.PlayerMoveListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * This class only functions if MicroLib is installed as
 * a PLUGIN, in the plugins folder of the server, and
 * it must be enabled.
 *
 * @author lokka30
 * @since unknown
 */
@SuppressWarnings("unused")
public class MicroLib extends JavaPlugin {

    private final MicroLogger logger = new MicroLogger("&b&lMicroLib: &7");

    /**
     * @return if MicroLib is installed in the plugins folder, AND is loaded by Bukkit.
     * @author lokka30
     * @since unknown
     */
    public static boolean isInstalledAsPlugin() {
        return Bukkit.getPluginManager().isPluginEnabled("MicroLib");
    }

    /**
     * @author lokka30
     * @see JavaPlugin#onEnable()
     *
     * Called by Bukkit when the plugin is being enabled.
     *
     * @since unknown
     */
    @Override
    public void onEnable() {
        registerListeners();

        logger.info("&fEnabled successfully.");
    }

    /**
     * @author lokka30
     * @see JavaPlugin#onDisable()
     *
     * Called by Bukkit when the plugin is being disabled.
     *
     * @since unknown
     */
    @Override
    public void onDisable() {
        logger.info("&fDisabled successfully.");
    }

    /**
     * @author lokka30
     * @since v3.0.0
     * <p>
     * Registers any listeners that MicroLib has.
     */
    private void registerListeners() {
        logger.info("Registering listeners...");

        Bukkit.getPluginManager().registerEvents(new PlayerMoveListener(), this);
    }
}

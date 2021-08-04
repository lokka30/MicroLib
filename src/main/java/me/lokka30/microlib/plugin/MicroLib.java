/*
 * Copyright (c) 2020-2021 lokka30. Use of this source code is governed by the MIT license that can be found in the LICENSE.md file.
 * This class is bundled inside the MicroLib resource, a library purposed for Bukkit/SpigotMC plugin developers. Read more about the resource here: https://www.spigotmc.org/resources/microlib.84017/
 */

package me.lokka30.microlib.plugin;

import me.lokka30.microlib.MicroLogger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main class loaded by the Bukkit plugin manager
 * (if it is installed in the plugins folder)
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
     * @since unknown
     */
    @Override
    public void onEnable() {
        logger.info("&fEnabled successfully.");
    }

    /**
     * @author lokka30
     * @see JavaPlugin#onDisable()
     * @since unknown
     */
    @Override
    public void onDisable() {
        logger.info("&fDisabled successfully.");
    }
}

/*
 * Copyright (c) 2020-2022 lokka30. Use of this source code is governed by the MIT license that can be found in the LICENSE.md file.
 * This class is bundled inside the MicroLib resource, a library purposed for Bukkit/SpigotMC plugin developers. Read more about the resource here: https://www.spigotmc.org/resources/microlib.84017/
 */

package me.lokka30.microlib.plugin;

import me.lokka30.microlib.plugin.listeners.PlayerMoveListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * This class only functions if MicroLib is installed as
 * a PLUGIN, in the plugins folder of the server, and
 * it must be enabled.
 *
 * @author lokka30
 * @since 2.4.0
 */
@SuppressWarnings("unused")
public class MicroLib extends JavaPlugin {

    /**
     * Whether is MicroLib installed in the plugins folder and loaded by Bukkit.
     * <p>
     * Useful for plugins to check if they are utilising MicroLib's events.    
     *
     * @return True if yes, otherwise false.
     * @since 2.4.0
     */
    public static boolean isInstalledAsPlugin() {
        return Bukkit.getPluginManager().isPluginEnabled("MicroLib");
    }

    /**
     * Called when MicroLib is enabled.
     *
     * @since 2.4.0
     */
    @Override
    public void onEnable() {
        registerListeners();
    }

    /**
     *  Registers any listeners that MicroLib has.
     *
     * @since 3.0.0
     */
    private void registerListeners() {
        getLogger().info("Registering listeners...");
        getServer().getPluginManager().registerEvents(new PlayerMoveListener(), this);
    }
}

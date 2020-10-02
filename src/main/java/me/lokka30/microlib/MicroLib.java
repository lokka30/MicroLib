package me.lokka30.microlib;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main class loaded by the Bukkit plugin manager (if it is installed in the plugins folder)
 *
 * @author lokka30
 */
@SuppressWarnings("unused")
public class MicroLib extends JavaPlugin {

    @Override
    public void onEnable() {
        new MicroLogger("&b&lMicroLib: &7").info("Plugin enabled.");
    }

    @Override
    public void onDisable() {
        new MicroLogger("&b&lMicroLib: &7").info("Plugin disabled.");
    }
}

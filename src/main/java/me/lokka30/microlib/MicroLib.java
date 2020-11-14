package me.lokka30.microlib;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main class loaded by the Bukkit plugin manager (if it is installed in the plugins folder)
 *
 * @author lokka30
 */
@SuppressWarnings("unused")
public class MicroLib extends JavaPlugin {

    private final MicroLogger logger = new MicroLogger("&b&lMicroLib: &7");

    @Override
    public void onEnable() {
        logger.info("&fEnabled successfully.");
    }

    @Override
    public void onDisable() {
        logger.info("&fDisabled successfully.");
    }
}

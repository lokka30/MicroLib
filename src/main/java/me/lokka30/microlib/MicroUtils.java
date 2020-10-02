package me.lokka30.microlib;

import org.bukkit.ChatColor;

/**
 * Minor useful utilities.
 *
 * @author lokka30
 */
public class MicroUtils {

    // Shorter way to use the translateAlternateColorCodes method.
    public static String colorize(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}

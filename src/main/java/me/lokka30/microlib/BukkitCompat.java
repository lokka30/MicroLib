package me.lokka30.microlib;

import net.md_5.bungee.api.ChatColor;

public class BukkitCompat {
    public static String colorizeStandardCodes(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}

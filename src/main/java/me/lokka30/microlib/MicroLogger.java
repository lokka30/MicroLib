package me.lokka30.microlib;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.logging.Logger;

/**
 * Logging utility class
 *
 * @author lokka30
 */
@SuppressWarnings("unused")
public class MicroLogger {

    final boolean serverIsSpigot;
    private final Logger logger;
    private String prefix;

    /**
     * Create a new instance of MicroLogger with a custom prefix
     *
     * @param prefix the prefix to use
     */
    public MicroLogger(String prefix) {
        this.prefix = prefix;
        this.logger = Bukkit.getLogger();
        this.serverIsSpigot = Bukkit.getName().equalsIgnoreCase("CraftBukkit");
    }

    /**
     * @return the current prefix
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * @param prefix the prefix that should be set
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void info(String message) {
        if (serverIsSpigot)
            Bukkit.getServer().getConsoleSender().sendMessage(MessageUtils.colorizeAll(prefix + message));
        else
            logger.info(MessageUtils.colorizeAll(prefix + message));
    }

    public void warning(String message) {
        if (serverIsSpigot)
            Bukkit.getServer().getConsoleSender().sendMessage(MessageUtils.colorizeAll(ChatColor.YELLOW + "[WARN] " + prefix + message));
        else
            logger.warning(MessageUtils.colorizeAll(prefix + message));
    }

    public void error(String message) {
        if (serverIsSpigot)
            Bukkit.getServer().getConsoleSender().sendMessage(MessageUtils.colorizeAll(ChatColor.RED + "[ERROR] " + prefix + message));
        else
            logger.severe(MessageUtils.colorizeAll(prefix + message));
    }
}

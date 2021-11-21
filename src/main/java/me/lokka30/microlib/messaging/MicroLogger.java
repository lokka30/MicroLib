/*
 * Copyright (c) 2020-2021 lokka30. Use of this source code is governed by the MIT license that can be found in the LICENSE.md file.
 * This class is bundled inside the MicroLib resource, a library purposed for Bukkit/SpigotMC plugin developers. Read more about the resource here: https://www.spigotmc.org/resources/microlib.84017/
 */

package me.lokka30.microlib.messaging;

import me.lokka30.microlib.other.VersionUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.logging.Logger;

/**
 * Logging utility class.
 *
 * @author lokka30, stumper66
 * @see Logger
 * @since 1.0.3 -ALPHA
 */
@SuppressWarnings("unused")
public class MicroLogger {

    final boolean serverIsSpigot;
    private final Logger logger;
    private String prefix;

    /**
     * Creates a new instance of MicroLogger with a custom prefix.
     *
     * @param prefix the prefix to use
     * @author lokka30
     * @since 1.0.3 -ALPHA
     */
    public MicroLogger(final String prefix) {
        this.prefix = prefix;
        this.logger = Bukkit.getLogger();
        this.serverIsSpigot = VersionUtils.isRunningSpigot();
    }

    /**
     * Gets the logger prefix.
     *
     * @return the current prefix.
     * @author lokka30
     * @since 1.0.3 -ALPHA
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * Sets the logger prefix.
     *
     * @param prefix the prefix that should be set.
     * @author lokka30
     * @since 1.0.3 -ALPHA
     */
    public void setPrefix(final String prefix) {
        this.prefix = prefix;
    }

    /**
     * Logs an INFO message.
     *
     * @param message Message to send with INFO log-level.
     * @author lokka30, stumper66
     * @since 2.0.0
     */
    public void info(final String message) {
        if (serverIsSpigot)
            Bukkit.getServer().getConsoleSender().sendMessage(MessageUtils.colorizeAll(prefix + message));
        else
            logger.info(MessageUtils.colorizeAll(prefix + message));
    }

    /**
     * Logs an WARNING message.
     *
     * @param message Message to send with WARNING log-level.
     * @author lokka30, stumper66
     * @since 2.0.0
     */
    public void warning(final String message) {
        if (serverIsSpigot)
            Bukkit.getServer().getConsoleSender().sendMessage(MessageUtils.colorizeAll(ChatColor.YELLOW + "[WARN] " + ChatColor.RESET + prefix + message));
        else
            logger.warning(MessageUtils.colorizeAll(prefix + message));
    }

    /**
     * Logs an ERROR message.
     *
     * @param message message to send with ERROR log-level
     * @author lokka30, stumper66
     * @since 2.0.0
     */
    public void error(final String message) {
        if (serverIsSpigot)
            Bukkit.getServer().getConsoleSender().sendMessage(MessageUtils.colorizeAll(ChatColor.RED + "[ERROR] " + ChatColor.RESET + prefix + message));
        else
            logger.severe(MessageUtils.colorizeAll(prefix + message));
    }
}

/*
 * Copyright (c) 2020-2022 lokka30. Use of this source code is governed by the MIT license that can be found in the LICENSE.md file.
 * This class is bundled inside the MicroLib resource, a library purposed for Bukkit/SpigotMC plugin developers. Read more about the resource here: https://www.spigotmc.org/resources/microlib.84017/
 */

package me.lokka30.microlib.messaging;

import java.util.logging.Logger;
import me.lokka30.microlib.other.VersionUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;

/**
 * Logging utility class.
 *
 * @author lokka30, stumper66
 * @see Logger
 * @since 1.0.3
 * @deprecated Use {@link Plugin#getLogger()} Bukkit's logger} instead. Messages logged using this class may appear incorrectly on Paper 1.18.2+ servers.
 */
@Deprecated
public class MicroLogger {

    final boolean serverIsSpigot;
    private final Logger logger;
    private String prefix;

    /**
     * Creates a new instance of MicroLogger with a custom prefix.
     *
     * @param prefix the prefix to use
     * @since 1.0.3
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
     * @since 1.0.3
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * Sets the logger prefix.
     *
     * @param prefix the prefix that should be set.
     * @since 1.0.3
     */
    public void setPrefix(final String prefix) {
        this.prefix = prefix;
    }

    /**
     * Logs an INFO message.
     *
     * @param message Message to send with INFO log-level.
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
     * @since 2.0.0
     */
    public void error(final String message) {
        if (serverIsSpigot)
            Bukkit.getServer().getConsoleSender().sendMessage(MessageUtils.colorizeAll(ChatColor.RED + "[ERROR] " + ChatColor.RESET + prefix + message));
        else
            logger.severe(MessageUtils.colorizeAll(prefix + message));
    }
}

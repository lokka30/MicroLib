package me.lokka30.microlib;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.logging.Logger;

/**
 * Logging utility class
 * Creation Date: 14 September 2020
 * @author lokka30
 * @since v1.0.0-ALPHA
 * @version 1
 */
@SuppressWarnings("unused")
public class MicroLogger {

    public String prefix;
    public MicroLogger(String prefix) { this.prefix = prefix; }

    public enum LogLevel { INFO, WARNING, ERROR }

    public void log(LogLevel logLevel, String message) {
        message = ChatColor.translateAlternateColorCodes('&', prefix + message);
        Logger logger = Bukkit.getLogger();
        switch(logLevel) {
            case INFO:
                logger.info(message);
                break;
            case WARNING:
                logger.warning(message);
                break;
            case ERROR:
                logger.severe(message);
                break;
            default:
                throw new IllegalStateException("Undefined LogLevel state: " + logLevel.toString());
        }
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}

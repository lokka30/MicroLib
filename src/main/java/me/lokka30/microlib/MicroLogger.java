package me.lokka30.microlib;

import org.bukkit.Bukkit;

import java.util.logging.Logger;

/**
 * Logging utility class
 *
 * @author lokka30
 */
@SuppressWarnings("unused")
public class MicroLogger {

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
        logger.info(MessageUtils.colorizeAll(prefix + message));
    }

    public void warning(String message) {
        logger.warning(MessageUtils.colorizeAll(prefix + message));
    }
    public void error(String message) {
        logger.severe(MessageUtils.colorizeAll(prefix + message));
    }
}

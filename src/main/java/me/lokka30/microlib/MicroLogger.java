package me.lokka30.microlib;

import org.bukkit.Bukkit;

import java.util.logging.Logger;

/**
 * Logging utility class
 *
 * @author lokka30
 */
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
    @SuppressWarnings("unused")
    public String getPrefix() {
        return prefix;
    }

    /**
     * @param prefix the prefix that should be set
     */
    @SuppressWarnings("unused")
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @SuppressWarnings("unused")
    public void info(String message) {
        logger.info(MicroUtils.colorize(prefix + message));
    }

    @SuppressWarnings("unused")
    public void warning(String message) {
        logger.warning(MicroUtils.colorize(prefix + message));
    }

    public void error(String message) {
        logger.severe(MicroUtils.colorize(prefix + message));
    }
}

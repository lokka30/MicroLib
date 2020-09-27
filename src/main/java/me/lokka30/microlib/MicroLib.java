package me.lokka30.microlib;

import me.lokka30.microlib.commands.MicroLibCommand;
import me.lokka30.microlib.listeners.PlayerBlockPlaceListener;
import me.lokka30.microlib.listeners.PlayerMoveListener;
import org.bstats.bukkit.Metrics;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Objects;

/**
 * Main class of the plugin
 * Creation Date: 14 September 2020
 *
 * @author lokka30
 * @version 4
 * @since v1.0.0-ALPHA
 */
public class MicroLib extends JavaPlugin {

    public final File settingsFile = new File(getDataFolder(), "settings.yml");
    public final File messagesFile = new File(getDataFolder(), "messages.yml");
    private final MicroLogger microLogger = new MicroLogger("&b&lMicroLib: &7");
    public YamlConfiguration settingsCfg;
    public YamlConfiguration messagesCfg;

    @Override
    public void onEnable() {
        final long startTime = System.currentTimeMillis();

        /* Loading Banner */
        microLogger.log(MicroLogger.LogLevel.INFO, "&8&m+-------------------------------------+");
        microLogger.log(MicroLogger.LogLevel.INFO, "&b&lMicroLib &fv" + getDescription().getVersion() + "&7 by lokka30");
        microLogger.log(MicroLogger.LogLevel.INFO, "&f(Loading Plugin)");
        microLogger.log(MicroLogger.LogLevel.INFO, "&8&m+-------------------------------------+");

        /* Files */
        loadFiles();

        /* Registering Events */
        registerEvents();

        /* Registering Commands */
        registerCommands();

        /* Metrics */
        startMetrics();

        /* Update Checker */
        checkForUpdates();

        /* Loading Completed */
        final long duration = System.currentTimeMillis() - startTime;
        microLogger.log(MicroLogger.LogLevel.INFO, "Loading complete! &8(&7took &b" + duration + "ms&8)");
    }

    public void loadFiles() {
        microLogger.log(MicroLogger.LogLevel.INFO, "Creating and loading files");

        saveResourceIfNotExists("settings.yml");
        settingsCfg = YamlConfiguration.loadConfiguration(settingsFile);
        if (settingsCfg.getInt("other.file-version") != 1) {
            microLogger.log(MicroLogger.LogLevel.WARNING, "File '&bsettings.yml&7' doesn't seem to be the correct version for this version of MicroLib. Please merge/replace with a newly generated file, else errors could occur!");
        }

        saveResourceIfNotExists("messages.yml");
        messagesCfg = YamlConfiguration.loadConfiguration(messagesFile);
        if (messagesCfg.getInt("other.file-version") != 3) {
            microLogger.log(MicroLogger.LogLevel.WARNING, "File '&bmessages.yml&7' doesn't seem to be the correct version for this version of MicroLib. Please merge/replace with a newly generated file, else errors could occur!");
        }
    }

    private void saveResourceIfNotExists(String fileName) {
        File file = new File(getDataFolder(), fileName);
        if (!file.exists()) {
            saveResource(fileName, false);
        }
    }

    private void registerEvents() {
        microLogger.log(MicroLogger.LogLevel.INFO, "Registering events");

        PluginManager pluginManager = getServer().getPluginManager();

        pluginManager.registerEvents(new PlayerMoveListener(), this);
        pluginManager.registerEvents(new PlayerBlockPlaceListener(this), this);
    }

    private void registerCommands() {
        microLogger.log(MicroLogger.LogLevel.INFO, "Registering commands");

        Objects.requireNonNull(getCommand("microlib")).setExecutor(new MicroLibCommand(this));
    }

    private void startMetrics() {
        microLogger.log(MicroLogger.LogLevel.INFO, "Starting bStats Metrics");
        new Metrics(this, 8899);
    }

    private void checkForUpdates() {
        if (settingsCfg.getBoolean("check-for-updates")) {
            UpdateChecker updateChecker = new UpdateChecker(this, 84017);
            String latestVersion = updateChecker.getLatestVersion();
            String currentVersion = getDescription().getVersion();
            if (!latestVersion.equals(currentVersion)) {
                microLogger.log(MicroLogger.LogLevel.WARNING, "&bThere seems to be an update available on the SpigotMC resource page!&7 Please install the update as soon as possible. &8(&7Latest version: &b" + latestVersion + "&7, current version: &b" + currentVersion + "&8)");
            }
        }
    }

    public String colorize(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}

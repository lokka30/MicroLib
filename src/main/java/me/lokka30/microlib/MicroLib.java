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
 * @author lokka30
 * @since v1.0.0-ALPHA
 * @version 4
 */
public class MicroLib extends JavaPlugin {

    private MicroLogger microLogger = new MicroLogger("&b&lMicroLib: &7");
    public File settingsFile = new File(getDataFolder(), "settings.yml");
    public YamlConfiguration settingsCfg;
    public File messagesFile = new File(getDataFolder(), "messages.yml");
    public YamlConfiguration messagesCfg;

    @Override
    public void onEnable() {
        final long startTime = System.currentTimeMillis();

        /* Loading Banner */
        microLogger.log(MicroLogger.LogLevel.INFO, "&8&m+---------------------------+");
        microLogger.log(MicroLogger.LogLevel.INFO, "&b&lMicroLib &fv" + getDescription().getVersion() + " &8// &7developed by &blokka30");
        microLogger.log(MicroLogger.LogLevel.INFO, "&f(Loading Plugin)");
        microLogger.log(MicroLogger.LogLevel.INFO, "&8&m+---------------------------+");

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

    private void loadFiles() {
        microLogger.log(MicroLogger.LogLevel.INFO, " &8&m->&7 Creating and loading files");

        saveResourceIfNotExists("LICENSE.md");

        saveResourceIfNotExists("settings.yml");
        settingsCfg = YamlConfiguration.loadConfiguration(settingsFile);
        if(settingsCfg.getInt("other.file-version") != 1) {
            microLogger.log(MicroLogger.LogLevel.WARNING, "File '&bsettings.yml&7' doesn't seem to be the correct version for this version of MicroLib. Please merge/replace with a newly generated file, else errors could occur!");
        }

        saveResourceIfNotExists("messages.yml");
        messagesCfg = YamlConfiguration.loadConfiguration(messagesFile);
        if(messagesCfg.getInt("other.file-version") != 2) {
            microLogger.log(MicroLogger.LogLevel.WARNING, "File '&bmessages.yml&7' doesn't seem to be the correct version for this version of MicroLib. Please merge/replace with a newly generated file, else errors could occur!");
        }
    }

    private void saveResourceIfNotExists(String fileName) {
        File file = new File(getDataFolder(), fileName);
        if(!file.exists()) {
            saveResource(fileName, false);
        }
    }

    private void registerEvents() {
        microLogger.log(MicroLogger.LogLevel.INFO, " &8&m->&7 Registering events");

        PluginManager pluginManager = getServer().getPluginManager();

        pluginManager.registerEvents(new PlayerMoveListener(), this);
        pluginManager.registerEvents(new PlayerBlockPlaceListener(this), this);
    }

    private void registerCommands() {
        microLogger.log(MicroLogger.LogLevel.INFO, " &8&m->&7 Registering commands");

        Objects.requireNonNull(getCommand("microlib")).setExecutor(new MicroLibCommand(this));
    }

    private void startMetrics() {
        microLogger.log(MicroLogger.LogLevel.INFO, " &8&m->&7 Starting bStats Metrics");
        new Metrics(this, 8899);
    }

    private void checkForUpdates() {
        microLogger.log(MicroLogger.LogLevel.INFO, " &8&m->&7 Checking for updates (if enabled)");
        /*if(settingsCfg.getBoolean("check-for-updates")) {
            UpdateChecker updateChecker = new UpdateChecker(this, 12345); //TODO CHANGE RESOURCE ID
            String latestVersion = updateChecker.getLatestVersion();
            String currentVersion = getDescription().getVersion();
            if(!latestVersion.equals(currentVersion)) {
                microLogger.log(MicroLogger.LogLevel.WARNING, "&bThere seems to be an update available on the SpigotMC resource page.&7 Please install the update as soon as possible. &8(&7Latest version: &b" + latestVersion + "&7, current version: &b" + currentVersion + "&8)");
            }
        }*/
    }

    @Override
    public void onDisable() {
        final long startTime = System.currentTimeMillis();

        //Disabling Banner.
        microLogger.log(MicroLogger.LogLevel.INFO, "&8&m+---------------------------+");
        microLogger.log(MicroLogger.LogLevel.INFO, "&b&lMicroLib &fv" + getDescription().getVersion() + " &8// &7developed by &blokka30");
        microLogger.log(MicroLogger.LogLevel.INFO, "&f(Disabling Plugin)");
        microLogger.log(MicroLogger.LogLevel.INFO, "&8&m+---------------------------+");

        //Do disabling things here.

        //Disabling Completed.
        final long duration = System.currentTimeMillis() - startTime;
        microLogger.log(MicroLogger.LogLevel.INFO, "Plugin disabled! &8(&7took &b" + duration + "ms&8)");
    }

    public String colorize(String msg) { return ChatColor.translateAlternateColorCodes('&', msg); }

    public String prefixMessage(String messagesFilePath) {
        //Get the strings required
        String prefix = messagesCfg.getString("messages.prefix");
        String message = messagesCfg.getString(messagesFilePath);

        //Assert that these values are not null. Makes it easier to debug problems with configs.
        if(prefix == null) {
            prefix = "[NullPrefix]";
        }
        if(message == null) {
            message = "[NullMessage]";
        }

        //Return the final prefixed message from the config
        return colorize(message.replace("%prefix%", prefix));
    }
}

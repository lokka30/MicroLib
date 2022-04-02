/*
 * Copyright (c) 2020-2022 lokka30. Use of this source code is governed by the MIT license that can be found in the LICENSE.md file.
 * This class is bundled inside the MicroLib resource, a library purposed for Bukkit/SpigotMC plugin developers. Read more about the resource here: https://www.spigotmc.org/resources/microlib.84017/
 */

package me.lokka30.microlib.files;

import java.io.File;
import java.io.IOException;
import org.apache.commons.lang.Validate;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

/**
 * This class allows you to easily work with YAML configuration files.
 *
 * @author lokka30
 * @see YamlConfiguration
 * @since 2.1.0
 */
@SuppressWarnings("unused")
public class YamlConfigFile {

    private final Plugin plugin;
    private final File configFile;
    private YamlConfiguration config;
    private boolean copyDefaults = false;

    /**
     * Instantiates a new Yaml configuration file.
     *
     * @param plugin     The plugin which will be used to create new file.
     * @param configFile The config file to be created and used.
     * @since 2.1.0
     */
    public YamlConfigFile(final Plugin plugin, final File configFile) {
        this.plugin = plugin;
        this.configFile = configFile;
    }

    /**
     * Instantiates a new Yaml configuration file.
     *
     * Config will be created in your plugin folder. If you want to set custom path use/instantiate {@link #YamlConfigFile(Plugin, File)}.
     *
     * @param plugin     The plugin which will be used to create new file.
     * @param configName The configuration name. Example: 'config.yml'
     * @since 3.1.3
     */
    public YamlConfigFile(final Plugin plugin, final String configName) {
        this(plugin, new File(plugin.getDataFolder(), configName));
    }

    /**
     * Create the file if it doesn't exist.
     * It saves it from the plugin's .jar file - if that isn't accessible then it saves an empty file.
     *
     * @throws IOException Thrown if file is null or inaccessible.
     * @since 2.1.0
     */
    private void createIfNotExists() throws IOException {
        if (!getConfigFile().exists() || getConfigFile().isDirectory()) {
            try {
                plugin.saveResource(getName(), false);
            } catch (IllegalArgumentException exception) {
                Validate.isTrue(getConfigFile().createNewFile(), "Unable to create new YAML file!");
            }
        }
    }

    /**
     * Load/reload values from the file into the config.
     *
     * @throws IOException Thrown if file is null or inaccessible.
     * @since 2.1.0
     */
    public void load() throws IOException {
        createIfNotExists();
        config = YamlConfiguration.loadConfiguration(getConfigFile());
        getConfig().options().copyDefaults(copyDefaults);
    }

    /**
     * Saves modified config values to the file.
     *
     * @throws IOException Thrown if the file is inaccessible.
     * @since 2.1.0
     */
    public void save() throws IOException {
        createIfNotExists();
        getConfig().save(getConfigFile());
    }

    /**
     * If config values are missing in the current config, should the defaults be copied over?
     *
     * By default, it does not copy defaults.
     *
     * @param copyDefaults Whether the config should copy defaults.
     * @since 2.1.0
     */
    public void setCopyDefaults(boolean copyDefaults) {
        this.copyDefaults = copyDefaults;
    }

    /**
     * Gets configuration file.
     *
     * @return The configuration file.
     * @since 2.1.0
     */
    public File getConfigFile() {
        return configFile;
    }

    /**
     * Gets Yaml configuration.
     *
     * @return The YAML configuration.
     * @since 2.1.0
     */
    public YamlConfiguration getConfig() {
        return config;
    }

    /**
     * Gets configuration file name.
     *
     * @return the file name (e.g. 'settings.yml')
     * @since 2.1.0
     */
    public String getName() {
        return configFile.getName();
    }
}

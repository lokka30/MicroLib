/*
 * Copyright (c) 2020-2021 lokka30. Use of this source code is governed by the MIT license that can be found in the LICENSE.md file.
 * This class is bundled inside the MicroLib resource, a library purposed for Bukkit/SpigotMC plugin developers. Read more about the resource here: https://www.spigotmc.org/resources/microlib.84017/
 */

package me.lokka30.microlib.files;

import org.apache.commons.lang.Validate;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

/**
 * This class allows you to easily work with YAML configuration files.
 *
 * @author lokka30
 * @see YamlConfiguration
 * @since unknown
 */
@SuppressWarnings("unused")
public class YamlConfigFile {

    private final Plugin plugin;
    private final File configFile;
    private YamlConfiguration config;
    private boolean copyDefaults = false;

    public YamlConfigFile(final Plugin plugin, final File configFile) {
        this.plugin = plugin;
        this.configFile = configFile;
    }

    /**
     * Create the file if it doesn't exist. It saves it from the plugin's .jar file - if that isn't accessible then it saves an empty file.
     *
     * @author lokka30
     * @since unknown
     */
    private void createIfNotExists() throws IOException {
        if (!configFile.exists() || configFile.isDirectory()) {
            try {
                plugin.saveResource(getName(), false);
            } catch (IllegalArgumentException exception) {
                Validate.isTrue(configFile.createNewFile(), "Unable to create new file");
            }
        }
    }

    /**
     * Load/reload values from the file into the config
     *
     * @author lokka30
     * @since unknown
     */
    public void load() throws IOException {
        createIfNotExists();
        config = YamlConfiguration.loadConfiguration(configFile);
        config.options().copyDefaults(copyDefaults);
    }

    /**
     * Saves modified config values to the file.
     *
     * @throws IOException if the file is inaccessible
     * @author lokka30
     * @since unknown
     */
    public void save() throws IOException {
        createIfNotExists();
        config.save(configFile);
    }

    /**
     * If config values are missing in the current config, should the defaults be copied over?
     *
     * @param copyDefaults if the config should copy defaults
     * @author lokka30
     * @since unknown
     */
    public void setCopyDefaults(boolean copyDefaults) {
        this.copyDefaults = copyDefaults;
    }

    /**
     * @return self-explanatory
     * @author lokka30
     * @since unknown
     */
    public File getConfigFile() {
        return configFile;
    }

    /**
     * @return self-explanatory
     * @author lokka30
     * @since unknown
     */
    public YamlConfiguration getConfig() {
        return config;
    }

    /**
     * @return the file name (e.g. 'settings.yml')
     * @author lokka30
     * @since unknown
     */
    public String getName() {
        return configFile.getName();
    }
}

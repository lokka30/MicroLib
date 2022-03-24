/*
 * Copyright (c) 2020-2021 lokka30. Use of this source code is governed by the MIT license that can be found in the LICENSE.md file.
 * This class is bundled inside the MicroLib resource, a library purposed for Bukkit/SpigotMC plugin developers. Read more about the resource here: https://www.spigotmc.org/resources/microlib.84017/
 */

package me.lokka30.microlib.files;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang.Validate;
import org.bukkit.plugin.Plugin;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * This class allows you to easily work with JSON configuration (mostly data) files.
 *
 * @author _ProfliX_
 * @since 3.2.0
 */
@SuppressWarnings("unused")
public class JsonConfigFile {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private final Plugin plugin;
    private final File file;
    private final Map<String, Object> values = new HashMap<>();
    private final BufferedReader reader;

    /**
     * Instantiates a new JSON config file.
     *
     * @param plugin The plugin which will be used to create new JSON file.
     * @param file   The config file to be created and used.
     * @throws IOException If an I/O error occurs opening the file.
     * @since 3.2.0
     */
    public JsonConfigFile(final Plugin plugin, final File file) throws IOException {
        this.plugin = plugin;
        this.file = file;
        this.reader = Files.newBufferedReader(getPath());
    }

    /**
     * Instantiates a new JSON config file.
     *
     * @param plugin The plugin which will be used to create new JSON file.
     * @param name   The configuration name. Example: 'data.json'
     * @throws IOException If an I/O error occurs opening the file.
     * @apiNote JSON file will be created in your plugin folder. If you want to set custom path use/instantiate {@link #JsonConfigFile(Plugin, File)}
     * @since 3.2.0
     */
    public JsonConfigFile(final Plugin plugin, final String name) throws IOException {
        this(plugin, new File(plugin.getDataFolder(), name));
    }

    /**
     * Gets buffered reader.
     *
     * @return The buffered reader.
     * @since 3.2.0
     */
    public BufferedReader getReader() {
        return reader;
    }

    /**
     * Gets JSON values.
     *
     * @return The json values.
     * @since 3.2.0
     */
    public Map<String, Object> getValues() {
        return values;
    }

    /**
     * Gets the value to which the specified key is mapped, or null if this map contains no mapping for the key.
     *
     * @param key The key whose associated value is to be returned.
     * @return The value to which the specified key is mapped, or null if this map contains no mapping for the key.
     * @throws ClassCastException   If the key is of an inappropriate type for this map (optional)
     * @throws NullPointerException If the specified key is null and this map does not permit null keys (optional)
     * @since 3.2.0
     */
    public Object get(final String key) throws ClassCastException, NullPointerException {
        return getValues().get(key);
    }

    /**
     * Sets the specified value with the specified value.
     *
     * @param key   Key with which the specified value is to be associated.
     * @param value Value to be associated with the specified key.
     * @return The previous value associated with key, or null if there was no mapping for key.
     * @throws UnsupportedOperationException If the operation is not supported by this map.
     * @throws ClassCastException            If the class of the specified key or value prevents it from being stored in this map.
     * @throws NullPointerException          If the specified key or value is null and this map does not permit null keys or values.
     * @throws IllegalArgumentException      If some property of the specified key or value prevents it from being stored in this map.
     * @since 3.2.0
     */
    public Object set(final String key, final Object value) throws UnsupportedOperationException, ClassCastException, NullPointerException, IllegalArgumentException {
        return getValues().put(key, value);
    }

    /**
     * Gets JSON file.
     *
     * @return The file.
     * @since 3.2.0
     */
    public File getFile() {
        return file;
    }

    /**
     * Gets JSON file name.
     *
     * @return The file name.
     * @since 3.2.0
     */
    public String getName() {
        return getFile().getName();
    }

    /**
     * Gets JSON file path.
     *
     * @return The file path.
     * @since 3.2.0
     */
    public Path getPath() {
        return getFile().toPath();
    }

    /**
     * Create the file if it doesn't exist.
     * It saves it from the plugin's .jar file - if that isn't accessible then it saves an empty file.
     *
     * @throws IOException Thrown if file is null or inaccessible.
     * @since 3.2.0
     */
    private void createIfNotExists() throws IOException {
        if (!getFile().exists() || getFile().isDirectory()) {
            try {
                plugin.saveResource(getName(), false);
            } catch (IllegalArgumentException exception) {
                Validate.isTrue(getFile().createNewFile(), "Unable to create new JSON file!");
            }
        }
    }

    /**
     * Load/reload values from the file into the config.
     *
     * @throws IOException Thrown if file is null or inaccessible.
     * @since 3.2.0
     */
    @SuppressWarnings("unchecked")
    public void load() throws IOException {
        createIfNotExists();
        getValues().putAll(GSON.fromJson(getReader(), getValues().getClass()));
    }

    /**
     * Saves modified config values to the file.
     *
     * @throws IOException Thrown if file is null or inaccessible.
     * @since 3.2.0
     */
    public void save() throws IOException {
        String json = GSON.toJson(getValues());
            Files.write(
                    getPath(),
                    Collections.singletonList(json),
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE
            );
    }
}

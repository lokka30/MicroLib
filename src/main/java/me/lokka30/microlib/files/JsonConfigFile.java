package me.lokka30.microlib.files;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang.Validate;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * This class allows you to easily work with JSON configuration files.
 *
 * @author _ProfliX_
 * @version 3.2.0
 * @since 3.2.0
 */
@SuppressWarnings("unused")
public class JsonConfigFile {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private final Plugin plugin;
    private final File file;
    private final Map<String, Object> values = new HashMap<>();

    /**
     * Instantiates a new JSON config file.
     *
     * @param plugin The plugin which will be used to create new JSON file.
     * @param file   The config file to be created and used.
     * @since 3.2.0
     */
    public JsonConfigFile(final Plugin plugin, final File file) {
        this.plugin = plugin;
        this.file = file;
    }

    /**
     * Instantiates a new JSON config file.
     *
     * @param plugin The plugin which will be used to create new JSON file.
     * @param name   The configuration name. Example: 'data.json'
     * @apiNote JSON file will be created in your plugin folder. If you want to set custom path use/instantiate {@link #JsonConfigFile(Plugin, File)}
     * @since 3.2.0
     */
    public JsonConfigFile(final Plugin plugin, final String name) {
        this(plugin, new File(plugin.getDataFolder(), name));
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
     * the value to which the specified key is mapped, or null if this map contains no mapping for the key.
     *
     * @param key The key whose associated value is to be returned.
     * @return The value to which the specified key is mapped, or null if this map contains no mapping for the key.
     * @since 3.2.0
     */
    public Object get(final String key) {
        return getValues().get(key);
    }

    /**
     * Sets the specified value with the specified value.
     *
     * @param key   Key with which the specified value is to be associated.
     * @param value Value to be associated with the specified key.
     * @return The previous value associated with key, or null if there was no mapping for key.
     * @since 3.2.0
     */
    public Object set(final String key, final Object value) {
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
        return file.getName();
    }

    /**
     * Gets JSON file path.
     *
     * @return The file path.
     * @since 3.2.0
     */
    public Path getPath() {
        return file.toPath();
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
    public void load() throws IOException {
        createIfNotExists();
        getValues().putAll(GSON.fromJson(Files.newBufferedReader(getPath()), getValues().getClass()));
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

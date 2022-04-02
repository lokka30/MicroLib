/*
 * Copyright (c) 2020-2022 lokka30. Use of this source code is governed by the MIT license that can be found in the LICENSE.md file.
 * This class is bundled inside the MicroLib resource, a library purposed for Bukkit/SpigotMC plugin developers. Read more about the resource here: https://www.spigotmc.org/resources/microlib.84017/
 */

package me.lokka30.microlib.other;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.function.Consumer;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * An adapted version of the Update Checker from the SpigotMC.org Wiki.
 *
 * @author lokka30
 * @since 1.0.3-ALPHA
 */
@SuppressWarnings("unused")
public class UpdateChecker {

    private final JavaPlugin plugin;
    private final int resourceId;

    /**
     * Instantiates a new update checker.
     *
     * @param plugin     the plugin which will check for an update.
     * @param resourceId the resource id of plugin.
     */
    public UpdateChecker(final JavaPlugin plugin, int resourceId) {
        this.plugin = plugin;
        this.resourceId = resourceId;
    }

    /**
     * Credit to the editors of <a href="https://www.spigotmc.org/wiki/creating-an-update-checker-that-checks-for-updates">this</a> wiki page.
     * (sourced at 15th September 2020)
     *
     * @param consumer what to do once an update checker result is found
     * @since 1.0.3-ALPHA
     */
    public void getLatestVersion(final Consumer<String> consumer) {
        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {

            InputStream inputStream;
            try {
                inputStream = new URL("https://api.spigotmc.org/legacy/update.php?resource=" + this.resourceId).openStream();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

            Scanner scanner = new Scanner(inputStream);
            if (scanner.hasNext()) {
                consumer.accept(scanner.next());
            }
        });
    }

    /**
     * Gets plugin current version.
     *
     * @return the version string from the plugin's plugin.yml file, i.e., what the user is currently running.
     * @since 1.0.6-ALPHA
     */
    public String getCurrentVersion() {
        return plugin.getDescription().getVersion();
    }
}
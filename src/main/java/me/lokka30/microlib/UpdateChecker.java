/*
 * Copyright (c) 2020-2021 lokka30. Use of this source code is governed by the MIT license that can be found in the LICENSE.md file.
 * This class is bundled inside the MicroLib resource, a library purposed for Bukkit/SpigotMC plugin developers. Read more about the resource here: https://www.spigotmc.org/resources/microlib.84017/
 */

package me.lokka30.microlib;

import me.lokka30.microlib.exceptions.OutdatedServerVersionException;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Consumer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

/**
 * An adapted version of the Update Checker from the SpigotMC.org Wiki.
 *
 * @author lokka30 + Spigot Wiki editors (linked in UpdateChecker#getLatestVersion description)
 * @see UpdateChecker#getLatestVersion(Consumer)
 * @since unknown
 */
@SuppressWarnings("unused")
public class UpdateChecker {

    private final JavaPlugin plugin;
    private final int resourceId;

    public UpdateChecker(JavaPlugin plugin, int resourceId) {
        this.plugin = plugin;
        this.resourceId = resourceId;
    }

    /**
     * @param consumer what to do once an update checker result is found
     * @throws OutdatedServerVersionException if the server is older than 1.11
     * @author lokka30 + editors of this wiki page: https://www.spigotmc.org/wiki/creating-an-update-checker-that-checks-for-updates/ (sourced at 15th September 2020)
     * @since unknown
     */
    public void getLatestVersion(final Consumer<String> consumer) throws OutdatedServerVersionException {
        if (!VersionUtils.isOneEleven()) {
            throw new OutdatedServerVersionException("The update checker requires the server to be Minecraft 1.11 or any newer version. Versions older than Minecraft 1.11 lack the code required to operate the update checker.");
        }

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
     * @return the version string from the plugin's plugin.yml file,
     * i.e., what the user is currently running.
     */
    public String getCurrentVersion() {
        return plugin.getDescription().getVersion();
    }
}
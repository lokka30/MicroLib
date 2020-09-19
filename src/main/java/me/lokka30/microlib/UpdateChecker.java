package me.lokka30.microlib;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Consumer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

/**
 * An adapted version of the update checker code on the SpigotMC.org Wiki
 * Creation Date: 15 September 2020
 * Sourced from https://www.spigotmc.org/wiki/creating-an-update-checker-that-checks-for-updates/
 *
 * @version 1
 * @since v1.0.0-ALPHA
 */
@SuppressWarnings("unused")
public class UpdateChecker {

    private JavaPlugin plugin;
    private int resourceId;

    public UpdateChecker(JavaPlugin plugin, int resourceId) {
        this.plugin = plugin;
        this.resourceId = resourceId;
    }

    private void retrieveLatestVersion(final Consumer<String> consumer) {
        Bukkit.getScheduler().runTaskAsynchronously(this.plugin, () -> {
            try (InputStream inputStream = new URL("https://api.spigotmc.org/legacy/update.php?resource=" + this.resourceId).openStream(); Scanner scanner = new Scanner(inputStream)) {
                if (scanner.hasNext()) {
                    consumer.accept(scanner.next());
                }
            } catch (IOException exception) {
                this.plugin.getLogger().warning("Unable to look for updates: " + exception.getMessage());
            }
        });
    }

    public String getCurrentVersion() {
        return plugin.getDescription().getVersion();
    }

    public String getLatestVersion() {
        String[] latestVersion = {getCurrentVersion()};
        try {
            retrieveLatestVersion(spigotVersion -> latestVersion[0] = spigotVersion);
        } catch (Exception exception) {
            MicroLogger logger = new MicroLogger("&b&lMicroLogger: &7");
            logger.log(MicroLogger.LogLevel.WARNING, "MicroLib was unable to retrieve the latest version from the SpigotMC resource page. If your server is running a version lower than Minecraft 1.11.0, then you must find a way to disable this resource's update checker by configuration.");
        }
        return latestVersion[0];
    }
}
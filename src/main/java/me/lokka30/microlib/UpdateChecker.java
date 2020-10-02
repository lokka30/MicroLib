package me.lokka30.microlib;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Consumer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

/**
 * An adapted version of the Update Checker from the SpigotMC.org Wiki
 * Sourced from https://www.spigotmc.org/wiki/creating-an-update-checker-that-checks-for-updates/ on 15 September 2020
 */
@SuppressWarnings("unused")
public class UpdateChecker {

    private final JavaPlugin plugin;
    private final int resourceId;

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
            new MicroLogger("&b&lMicroLib: &7").warning("The developer of the plugin '" + plugin.getName() + "' is utilising MicroLib's asynchronous update checker. An error occured whilst attempting to check for updates. If your server is running a version lower than Minecraft 1.11.0, kindly ask the developer of '" + plugin.getName() + "', 'How do I disable the update checker?' (and include this warning in your message).");
        }
        return latestVersion[0];
    }
}
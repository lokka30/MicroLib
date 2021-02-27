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
 *
 * @author lokka30
 */
@SuppressWarnings("unused")
public class UpdateChecker {

    private final JavaPlugin plugin;
    private final int resourceId;

    public UpdateChecker(JavaPlugin plugin, int resourceId) {
        this.plugin = plugin;
        this.resourceId = resourceId;
    }

    /*
    Credit for this method is given to the editors of the Wiki page linked above.
     */
    public void getLatestVersion(final Consumer<String> consumer) {
        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
            try (InputStream inputStream = new URL("https://api.spigotmc.org/legacy/update.php?resource=" + this.resourceId).openStream(); Scanner scanner = new Scanner(inputStream)) {
                if (scanner.hasNext()) {
                    consumer.accept(scanner.next());
                }
            } catch (IOException exception) {
                plugin.getLogger().severe("An internal error occured whilst attempting to check the latest version available for the resource. Stack trace: ");
                exception.printStackTrace();
            }
        });
    }

    public String getCurrentVersion() {
        return plugin.getDescription().getVersion();
    }
}
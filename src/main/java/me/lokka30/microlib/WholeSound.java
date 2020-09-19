package me.lokka30.microlib;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Objects;

/**
 * An Object that makes it easier to store and play sounds
 * Creation Date: 15 September 2020
 *
 * @author lokka30
 * @version 1
 * @since v1.0.0-ALPHA
 */
@SuppressWarnings("unused")
public class WholeSound {

    public Sound sound;
    public float volume, pitch;

    public WholeSound(Sound sound, float volume, float pitch) {
        this.sound = sound;
        this.volume = volume;
        this.pitch = pitch;
    }

    public void playToIndividual(Player player) {
        player.playSound(player.getLocation(), sound, volume, pitch);
    }

    public void playToIndividuals(Player[] players) {
        for (Player player : players) {
            playToIndividual(player);
        }
    }

    public void playToIndividuals(List<Player> players) {
        for (Player player : players) {
            playToIndividual(player);
        }
    }

    public void playToIndividualAtLocation(Player player, Location location) {
        player.playSound(location, sound, volume, pitch);
    }

    public void playToIndividualsAtLocation(Player[] players, Location location) {
        for (Player player : players) {
            playToIndividualAtLocation(player, location);
        }
    }

    public void playToIndividualsAtLocation(List<Player> players, Location location) {
        for (Player player : players) {
            playToIndividualAtLocation(player, location);
        }
    }

    public void playToIndividualsAtLocations(Player[] players, Location[] locations) {
        for (Player player : players) {
            for (Location location : locations) {
                playToIndividualAtLocation(player, location);
            }
        }
    }

    public void playToIndividualsAtLocations(List<Player> players, List<Location> locations) {
        for (Player player : players) {
            for (Location location : locations) {
                playToIndividualAtLocation(player, location);
            }
        }
    }

    public void playToAll() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            playToIndividual(player);
        }
    }

    public void playToAllAtLocation(Location location) {
        Objects.requireNonNull(location.getWorld()).playSound(location, sound, volume, pitch);
    }

    public void playToAllAtLocations(Location[] locations) {
        for (Location location : locations) {
            playToAllAtLocation(location);
        }
    }

    public void playToAllAtLocations(List<Location> locations) {
        for (Location location : locations) {
            playToAllAtLocation(location);
        }
    }
}

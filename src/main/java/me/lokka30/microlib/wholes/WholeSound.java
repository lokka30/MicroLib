/*
 * Copyright (c) 2020-2021 lokka30. Use of this source code is governed by the MIT license that can be found in the LICENSE.md file.
 * This class is bundled inside the MicroLib resource, a library purposed for Bukkit/SpigotMC plugin developers. Read more about the resource here: https://www.spigotmc.org/resources/microlib.84017/
 */

package me.lokka30.microlib.wholes;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * An object that makes it easier to store and play sounds
 *
 * @author lokka30
 * @since 1.0.3 -ALPHA
 */
@SuppressWarnings("unused")
public class WholeSound {

    public final Sound sound;
    public final float volume;
    public final float pitch;

    /**
     * Instantiates a new whole sound.
     *
     * @param sound  The sound which you want to be played.
     * @param volume The volume of sound.
     * @param pitch  The pitch of sound
     * @since 1.0.3 -ALPHA
     */
    public WholeSound(Sound sound, float volume, float pitch) {
        this.sound = sound;
        this.volume = volume;
        this.pitch = pitch;
    }

    /**
     * Play a sound to individual player.
     *
     * @param player The player to which you will play a sound.
     * @since 1.0.3 -ALPHA
     */
    public void playToIndividual(@NotNull Player player) {
        player.playSound(player.getLocation(), sound, volume, pitch);
    }

    /**
     * Play a sound to individual players.
     *
     * @param players The players to which you will play a sound.
     * @since 1.0.3 -ALPHA
     */
    public void playToIndividuals(Player @NotNull [] players) {
        for (Player player : players) {
            playToIndividual(player);
        }
    }

    /**
     * Play a sound to individual players.
     *
     * @param players The players to which you will play a sound.
     * @since 1.0.3 -ALPHA
     */
    public void playToIndividuals(@NotNull List<Player> players) {
        for (Player player : players) {
            playToIndividual(player);
        }
    }

    /**
     * Play a sound to individual player at location.
     *
     * @param player   The player to which you will play a sound.
     * @param location The location of player to which you will play a sound.
     * @since 1.0.3 -ALPHA
     */
    public void playToIndividualAtLocation(@NotNull Player player, Location location) {
        player.playSound(location, sound, volume, pitch);
    }

    /**
     * Play a sound to individual players at location.
     *
     * @param players  The players to which you will play a sound.
     * @param location The location of players to which you will play a sound.
     * @since 1.0.3 -ALPHA
     */
    public void playToIndividualsAtLocation(Player @NotNull [] players, Location location) {
        for (Player player : players) {
            playToIndividualAtLocation(player, location);
        }
    }

    /**
     * Play a sound to individual players at location.
     *
     * @param players  The players to which you will play a sound.
     * @param location The location of players to which you will play a sound.
     * @since 1.0.3 -ALPHA
     */
    public void playToIndividualsAtLocation(@NotNull List<Player> players, Location location) {
        for (Player player : players) {
            playToIndividualAtLocation(player, location);
        }
    }

    /**
     * Play a sound to individual players at locations.
     *
     * @param players   The players to which you will play a sound.
     * @param locations The locations of players to which you will play a sound.
     * @since 1.0.3 -ALPHA
     */
    public void playToIndividualsAtLocations(Player @NotNull [] players, Location[] locations) {
        for (Player player : players) {
            for (Location location : locations) {
                playToIndividualAtLocation(player, location);
            }
        }
    }

    /**
     * Play a sound to individual players at locations.
     *
     * @param players   The players to which you will play a sound.
     * @param locations The locations of players to which you will play a sound.
     * @since 1.0.3 -ALPHA
     */
    public void playToIndividualsAtLocations(@NotNull List<Player> players, List<Location> locations) {
        for (Player player : players) {
            for (Location location : locations) {
                playToIndividualAtLocation(player, location);
            }
        }
    }

    /**
     * Play a sound to all online players.
     *
     * @since 1.0.3 -ALPHA
     */
    public void playToAll() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            playToIndividual(player);
        }
    }

    /**
     * Play a sound to all online players at location.
     *
     * @param location The location of players to which you will play a sound.
     * @since 1.0.3 -ALPHA
     */
    public void playToAllAtLocation(@NotNull Location location) {
        if (location.getWorld() == null) {
            return;
        }
        location.getWorld().playSound(location, sound, volume, pitch);
    }

    /**
     * Play a sound to all online players at locations.
     *
     * @param locations The locations of players to which you will play a sound.
     * @since 1.0.3 -ALPHA
     */
    public void playToAllAtLocations(Location @NotNull [] locations) {
        for (Location location : locations) {
            playToAllAtLocation(location);
        }
    }

    /**
     * Play a sound to all online players at locations.
     *
     * @param locations The locations of players to which you will play a sound.
     * @since 1.0.3 -ALPHA
     */
    public void playToAllAtLocations(@NotNull List<Location> locations) {
        for (Location location : locations) {
            playToAllAtLocation(location);
        }
    }
}

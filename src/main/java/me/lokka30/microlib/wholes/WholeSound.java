/*
 * Copyright (c) 2020-2022 lokka30. Use of this source code is governed by the MIT license that can be found in the LICENSE.md file.
 * This class is bundled inside the MicroLib resource, a library purposed for Bukkit/SpigotMC plugin developers. Read more about the resource here: https://www.spigotmc.org/resources/microlib.84017/
 */

package me.lokka30.microlib.wholes;

import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * An object that makes it easier to store and play sounds
 *
 * @author lokka30
 * @since 1.0.3
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
     * @since 1.0.3
     */
    public WholeSound(final Sound sound, float volume, float pitch) {
        this.sound = sound;
        this.volume = volume;
        this.pitch = pitch;
    }

    /**
     * Play a sound to individual player.
     *
     * @param player The player to which you will play a sound.
     * @since 1.0.3
     */
    public void playToIndividual(final @NotNull Player player) {
        player.playSound(player.getLocation(), sound, volume, pitch);
    }

    /**
     * Play a sound to individual players.
     *
     * @param players The players to which you will play a sound.
     * @since 1.0.3
     */
    public void playToIndividuals(final Player @NotNull [] players) {
        for (Player player : players) {
            playToIndividual(player);
        }
    }

    /**
     * Play a sound to individual players.
     *
     * @param players The players to which you will play a sound.
     * @since 1.0.3
     */
    public void playToIndividuals(final @NotNull List<Player> players) {
        for (Player player : players) {
            playToIndividual(player);
        }
    }

    /**
     * Play a sound to individual player at location.
     *
     * @param player   The player to which you will play a sound.
     * @param location The location of player to which you will play a sound.
     * @since 1.0.3
     */
    public void playToIndividualAtLocation(final @NotNull Player player, final Location location) {
        player.playSound(location, sound, volume, pitch);
    }

    /**
     * Play a sound to individual players at location.
     *
     * @param players  The players to which you will play a sound.
     * @param location The location of players to which you will play a sound.
     * @since 1.0.3
     */
    public void playToIndividualsAtLocation(final Player @NotNull [] players, final Location location) {
        for (Player player : players) {
            playToIndividualAtLocation(player, location);
        }
    }

    /**
     * Play a sound to individual players at location.
     *
     * @param players  The players to which you will play a sound.
     * @param location The location of players to which you will play a sound.
     * @since 1.0.3
     */
    public void playToIndividualsAtLocation(final @NotNull List<Player> players, final Location location) {
        for (Player player : players) {
            playToIndividualAtLocation(player, location);
        }
    }

    /**
     * Play a sound to individual players at locations.
     *
     * @param players   The players to which you will play a sound.
     * @param locations The locations of players to which you will play a sound.
     * @since 1.0.3
     */
    public void playToIndividualsAtLocations(final Player @NotNull [] players, final Location[] locations) {
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
     * @since 1.0.3
     */
    public void playToIndividualsAtLocations(final @NotNull List<Player> players, final List<Location> locations) {
        for (Player player : players) {
            for (Location location : locations) {
                playToIndividualAtLocation(player, location);
            }
        }
    }

    /**
     * Play a sound to all online players.
     *
     * @since 1.0.3
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
     * @since 1.0.3
     */
    public void playToAllAtLocation(final @NotNull Location location) {
        if (location.getWorld() == null) {
            return;
        }
        location.getWorld().playSound(location, sound, volume, pitch);
    }

    /**
     * Play a sound to all online players at locations.
     *
     * @param locations The locations of players to which you will play a sound.
     * @since 1.0.3
     */
    public void playToAllAtLocations(final Location @NotNull [] locations) {
        for (Location location : locations) {
            playToAllAtLocation(location);
        }
    }

    /**
     * Play a sound to all online players at locations.
     *
     * @param locations The locations of players to which you will play a sound.
     * @since 1.0.3
     */
    public void playToAllAtLocations(final @NotNull List<Location> locations) {
        for (Location location : locations) {
            playToAllAtLocation(location);
        }
    }
}

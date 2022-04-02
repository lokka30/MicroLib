/*
 * Copyright (c) 2020-2022 lokka30. Use of this source code is governed by the MIT license that can be found in the LICENSE.md file.
 * This class is bundled inside the MicroLib resource, a library purposed for Bukkit/SpigotMC plugin developers. Read more about the resource here: https://www.spigotmc.org/resources/microlib.84017/
 */

package me.lokka30.microlib.wholes;

import java.util.List;
import me.lokka30.microlib.messaging.MessageUtils;
import me.lokka30.microlib.other.VersionUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * An object that makes it easier to store and send titles.
 *
 * @author lokka30
 * @since 1.0.3
 */
@SuppressWarnings({"unused"})
public class WholeTitle {

    private final String title;
    private final String subtitle;
    private final int fadeIn;
    private final int stay;
    private final int fadeOut;

    /**
     * Instantiates a new whole title.
     *
     * @param title    The title to be sent.
     * @param subtitle The subtitle to be sent.
     * @param fadeIn   The fade in of title.
     * @param stay     The stay of title.
     * @param fadeOut  The fade out of title.
     * @since 1.0.3
     */
    public WholeTitle(final String title, final String subtitle, int fadeIn, int stay, int fadeOut) {
        this.title = MessageUtils.colorizeAll(title);
        this.subtitle = MessageUtils.colorizeAll(subtitle);
        this.fadeIn = fadeIn;
        this.stay = stay;
        this.fadeOut = fadeOut;
    }

    /**
     * Sends a title to player.
     *
     * @param player The player which will receive a title.
     * @since 1.0.3
     */
    @SuppressWarnings("deprecation")
    public void send(final @NotNull Player player) {

        // 1.7 servers don't have titles.
        if(!VersionUtils.isOneEight()) {
            return;
        }

        // 1.8, 1.9 and 1.10 servers must use an older method,
        // which has been deprecated from the beginning.
        // Use with caution.
        if (!VersionUtils.isOneEleven()) {
            player.sendTitle(title, subtitle);
            return;
        }

        // 1.9 & 1.10
        if (VersionUtils.isSpecific("1.9") || VersionUtils.isSpecific("1.10")) {
            player.sendTitle(title, subtitle);
            return;
        }
        // 1.11 +
        player.sendTitle(title, subtitle, fadeIn, stay, fadeOut);
    }

    /**
     * Sends a title to players.
     *
     * @param players The players which will receive a title.
     * @since 1.0.3
     */
    public void send(final Player @NotNull [] players) {
        for (Player player : players) {
            send(player);
        }
    }

    /**
     * Sends a title to player.
     *
     * @param players The players which will receive a title.
     * @since 1.0.3
     */
    public void send(final @NotNull List<Player> players) {
        for (Player player : players) {
            send(player);
        }
    }

    /**
     * Sends a title to all online players.
     *
     * @since 1.0.3
     */
    public void sendToAll() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            send(player);
        }
    }
}

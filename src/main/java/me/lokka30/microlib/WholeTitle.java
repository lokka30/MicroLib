/*
 * Copyright (c) 2020-2021 lokka30. Use of this source code is governed by the MIT license that can be found in the LICENSE.md file.
 * This class is bundled inside the MicroLib resource, a library purposed for Bukkit/SpigotMC plugin developers. Read more about the resource here: https://www.spigotmc.org/resources/microlib.84017/
 */

package me.lokka30.microlib;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * An object that makes it easier to store and send titles
 *
 * @author lokka30
 * @since unknown
 */
@SuppressWarnings("unused")
public class WholeTitle {

    final String title;
    final String subtitle;
    final int fadeIn;
    final int stay;
    final int fadeOut;

    public WholeTitle(String title, String subtitle, int fadeIn, int stay, int fadeOut) {
        this.title = MessageUtils.colorizeAll(title);
        this.subtitle = MessageUtils.colorizeAll(subtitle);
        this.fadeIn = fadeIn;
        this.stay = stay;
        this.fadeOut = fadeOut;
    }

    public void send(Player player) {
        player.sendTitle(title, subtitle, fadeIn, stay, fadeOut);
    }

    public void send(Player[] players) {
        for (Player player : players) {
            send(player);
        }
    }

    public void send(List<Player> players) {
        for (Player player : players) {
            send(player);
        }
    }

    public void sendToAll() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            send(player);
        }
    }
}

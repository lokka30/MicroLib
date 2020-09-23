package me.lokka30.microlib;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * An Object that makes it easier to store and send titles
 * Creation Date: 15 September 2020
 *
 * @author lokka30
 * @version 1
 * @since v1.0.0-ALPHA
 */
@SuppressWarnings("unused")
public class WholeTitle {

    final String title;
    final String subtitle;
    final int fadeIn;
    final int stay;
    final int fadeOut;

    public WholeTitle(String title, String subtitle, int fadeIn, int stay, int fadeOut) {
        this.title = colorize(title);
        this.subtitle = colorize(subtitle);
        this.fadeIn = fadeIn;
        this.stay = stay;
        this.fadeOut = fadeOut;
    }

    private String colorize(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
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

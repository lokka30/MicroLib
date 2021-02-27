package me.lokka30.microlib;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * An object that makes it easier to store and send titles
 *
 * @author lokka30
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

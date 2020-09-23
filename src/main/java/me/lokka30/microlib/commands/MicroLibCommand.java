package me.lokka30.microlib.commands;

import me.lokka30.microlib.MicroLib;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The /microlib command is handled here
 * Creation Date: 15 September 2020
 *
 * @author lokka30
 * @version 2
 * @since v1.0.0-ALPHA
 */
public class MicroLibCommand implements TabExecutor {

    private final MicroLib instance;

    public MicroLibCommand(MicroLib instance) {
        this.instance = instance;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 0) {
            for (String message : instance.messagesCfg.getStringList("command.main")) {
                sender.sendMessage(instance.colorize(message));
            }
        } else if (args.length == 1) {
            switch (args[0].toLowerCase()) {
                case "reload":
                    if (sender.hasPermission("microlib.reload")) {
                        sender.sendMessage(instance.colorize("&7&oThe reload subcommand has not been created yet. :("));
                        //TODO
                    } else {
                        sender.sendMessage(instance.colorize(Objects.requireNonNull(instance.messagesCfg.getString("command.no-permission"))
                                .replace("%prefix%", Objects.requireNonNull(instance.messagesCfg.getString("prefix")))));
                    }
                    break;
                case "backup":
                    if (sender.hasPermission("microlib.backup")) {
                        sender.sendMessage(instance.colorize("&7&oThe backup subcommand has not been created yet. :("));
                        //TODO
                    } else {
                        sender.sendMessage(instance.colorize(Objects.requireNonNull(instance.messagesCfg.getString("command.no-permission"))
                                .replace("%prefix%", Objects.requireNonNull(instance.messagesCfg.getString("prefix")))));
                    }
                    break;
                default:
                    sender.sendMessage(instance.colorize(Objects.requireNonNull(instance.messagesCfg.getString("command.usage"))
                            .replace("%prefix%", Objects.requireNonNull(instance.messagesCfg.getString("prefix"))
                                    .replace("%label%", label))));
                    break;
            }
        } else {
            sender.sendMessage(instance.colorize(Objects.requireNonNull(instance.messagesCfg.getString("command.usage"))
                    .replace("%prefix%", Objects.requireNonNull(instance.messagesCfg.getString("prefix"))
                            .replace("%label%", label))));
        }
        return true;
    }

    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        List<String> recommendations = new ArrayList<>();
        if (args.length == 0) {
            recommendations.add("reload");
            recommendations.add("backup");
        }
        return recommendations;
    }
}

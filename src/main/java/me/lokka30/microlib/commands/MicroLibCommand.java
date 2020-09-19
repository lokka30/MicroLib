package me.lokka30.microlib.commands;

import me.lokka30.microlib.MicroLib;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.ArrayList;
import java.util.List;

/**
 * The /microlib command is handled here
 * Creation Date: 15 September 2020
 * @author lokka30
 * @since v1.0.0-ALPHA
 * @version 1
 */
public class MicroLibCommand implements TabExecutor {

    private MicroLib instance;
    public MicroLibCommand(MicroLib instance) { this.instance = instance; }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(args.length == 0) {
            sender.sendMessage(" ");
            sender.sendMessage(instance.colorize("&f&nAbout:"));
            sender.sendMessage(instance.colorize("&r &8&m->&r &7Running &b&lMicroLib &bv" + instance.getDescription().getVersion() + "&7, developed by &flokka30&7."));
            sender.sendMessage(instance.colorize("&r &8&m->&r &7&o'" + instance.getDescription().getDescription() + "'"));
            sender.sendMessage(" ");
            sender.sendMessage(instance.colorize("&f&nAvailable Commands:"));
            sender.sendMessage(instance.colorize("&r &8&m->&b /microlib reload&8 (&7reloads the configuration files&8)"));
            sender.sendMessage(instance.colorize("&r &8&m->&b /microlib backup&8 (&7generates a backup of the configuration files&8)"));
            sender.sendMessage(" ");
        } else if(args.length == 1) {
            switch(args[0].toLowerCase()) {
                case "reload":
                    if(sender.hasPermission("microlib.reload")) {
                        sender.sendMessage(instance.colorize("&7&oThe reload subcommand has not been created yet. :("));
                        //TODO
                    } else {
                        sender.sendMessage(instance.prefixMessage("command.no-permission"));
                    }
                    break;
                case "backup":
                    if(sender.hasPermission("microlib.backup")) {
                        sender.sendMessage(instance.colorize("&7&oThe backup subcommand has not been created yet. :("));
                        //TODO
                    } else {
                        sender.sendMessage(instance.prefixMessage("command.no-permission"));
                    }
                    break;
                default:
                    sender.sendMessage(instance.prefixMessage("command.usage").replace("%label%", label));
                    break;
            }
        } else {
            sender.sendMessage(instance.prefixMessage("command.usage").replace("%label%", label));
        }
        return true;
    }

    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        List<String> recommendations = new ArrayList<>();
        if(args.length == 0) {
            recommendations.add("reload");
            recommendations.add("backup");
        }
        return recommendations;
    }
}

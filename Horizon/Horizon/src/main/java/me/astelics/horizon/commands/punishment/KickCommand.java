package me.astelics.horizon.commands.punishment;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KickCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equals("kick")) {
            if (args.length == 0) {
                sender.sendMessage(ChatColor.RED + "Usage: /kick <player> <reason>");
                return true;
            } else if (args.length == 1) {
                sender.sendMessage(ChatColor.RED + "Usage: /kick <player> <reason>");
            } else if (args.length == 2) {
                Player target = Bukkit.getPlayer(args[0]);

                StringBuilder x = new StringBuilder();
                for (int i = 1; i < args.length; i++) {
                    x.append(args[i] + " ");
                }

                String kickExectutor = "Console";
                String reason = x.toString().trim();

                if (sender instanceof Player) {
                    kickExectutor = sender.getName();
                }

                if (target == null) {
                    sender.sendMessage(ChatColor.RED + args[0] + " is not online.");
                    return true;
                } else {
                    target.kickPlayer(ChatColor.RED + "You have been kicked\nBy " + kickExectutor + "\nReason: " + reason);
                    sender.sendMessage(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&',
                            "&b&lPunish &8&l• &c " + target + " has been kicked from the server"));
                }
                return true;
            }
        }
        return true;
    }
}


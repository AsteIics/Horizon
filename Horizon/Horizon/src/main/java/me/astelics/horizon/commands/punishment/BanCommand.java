package me.astelics.horizon.commands.punishment;

import me.astelics.horizon.Horizon;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BanCommand implements CommandExecutor {

    Horizon plugin;
    public BanCommand(Horizon plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equals("ban")) {
            if (args.length == 0) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        "&cUsage: /ban <player> <reason>"));
            } else if (args.length == 1) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        "&cUsage: /ban <player> <reason>"));
            } else if (args.length == 2) {
                StringBuilder x = new StringBuilder();
                for (int i = 1; i < args.length; i++) {
                    x.append(args[i] + " ");
                }

                Player target = Bukkit.getPlayer(args[0]);
                String banExecutor = "Console";
                String reason = x.toString().trim();


                if (sender instanceof Player) {
                    banExecutor = sender.getName();
                }

                if (target == null) {
                    sender.sendMessage(ChatColor.RED + args[0] + " is not online right now!");
                } else {
                    plugin.bannedPlayers.add(target);
                    target.kickPlayer(ChatColor.RED + "You have been banned!\nBy: " + banExecutor + "\nReason: " + reason);
                    sender.sendMessage(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&',
                            "&b&lPunish &8&l• &c " + target + " has been banned from the server"));
                }
            }
        }
        return true;
    }
}

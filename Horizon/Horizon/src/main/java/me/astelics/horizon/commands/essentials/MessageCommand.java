package me.astelics.horizon.commands.essentials;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageCommand implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (command.getName().equals("message")) {
                if (args.length == 0) {
                    sender.sendMessage(ChatColor.RED + "Usage: /message <player> <message>");
                } else if (args.length == 1) {
                    sender.sendMessage(ChatColor.RED + "Usage: /message <player> <message>");
                    //cannot send multiple words
                } else if (args.length == 2) {
                    // when calling receiver returns
                    //CraftPlayer{name=astelics}
                    Player receiver = Bukkit.getPlayer(args[0]);
                    String name = receiver.toString();
                    String message = args[1];
                    String messageSender = "Console";

                    if (sender instanceof Player)
                    {
                        messageSender = sender.getName();
                    }

                    if (receiver == null)
                    {
                        sender.sendMessage(ChatColor.RED + "" + name + " is not online right now!");
                        return true;
                    } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            "&dTo " + name + "&7: " + message));
                        receiver.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            "&dFrom " + messageSender + "&7: " + message));
                        return true;
                    }

                }
            }
        return true;
    }
}

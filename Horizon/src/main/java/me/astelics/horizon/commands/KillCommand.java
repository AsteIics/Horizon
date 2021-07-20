package me.astelics.horizon.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KillCommand implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (command.getName().equals("kill"))
        {
            if (sender instanceof Player)
            {
                Player player = (Player) sender;
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        "&3&lHORIZON &7» &bKilled player " + player.getDisplayName()));
                player.setHealth(0);
            } else {
                System.out.println("[Horizon] Only players can execute this command.");
            }
        }
        return false;
    }
}

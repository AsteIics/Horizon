package me.astelics.horizon.commands;

import me.astelics.horizon.Horizon;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class IncognitoCommand implements CommandExecutor
{
    Horizon plugin;

    public IncognitoCommand(Horizon plugin)
    {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (command.getName().equals("incognito"))
        {
            if (sender instanceof Player)
            {
                Player player = (Player) sender;
                if (plugin.vanishedPlayers.contains(player))
                {
                    for (Player people : Bukkit.getOnlinePlayers())
                    {
                        people.showPlayer(plugin, player);

                    }
                    plugin.vanishedPlayers.remove(player);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            "&b&lVisibility &8&l• &7Incognito mode has been &cdisabled&7."));
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            "&b&lIncognito &8&l• &7You have left incognito."));
                } else if (!plugin.vanishedPlayers.contains(player))
                {
                    for (Player people : Bukkit.getOnlinePlayers())
                    {
                        people.hidePlayer(plugin, player);
                    }
                    plugin.vanishedPlayers.add(player);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            "&b&lVisibility &8&l• &7Incognito mode has been &aenabled&7."));
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            "&b&lIncognito &8&l• &7You have gone incognito."));
                }
            }
        }
        return true;
    }
}
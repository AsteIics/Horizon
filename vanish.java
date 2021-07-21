package me.astelics.horizon.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class IncognitoCommand implements CommandExecutor
{
    boolean isVanished = false;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        Player player = (Player) sender;

        if (command.getName().equals("incognito"))
        {
            if (sender instanceof Player)
            {
                if (!isVanished)
                {
                    isVanished = true;
                    player.setInvisible(true);
                    player.setInvulnerable(true);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            "&b&lVisibility &8&l• &7Incognito mode has been &aenabled&7."));
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            "&b&lIncognito &8&l• &7You have gone incognito."));
                    while (isVanished)
                    {
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
                                TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&',
                                        "&fYou are currently &cINCOGNITO")));
                    }
                } else if (isVanished)
                {
                    isVanished = false;
                    player.setInvisible(false);
                    player.setInvulnerable(false);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            "&b&lVisibility &8&l• &7Incognito mode has been &cdisabled&7."));
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            "&b&lIncognito &8&l• &7You have left incognito."));
                }
            } else {
                System.out.println("[Horizon] Only players can execute this command.");
            }
        }
        return false;
    }
}

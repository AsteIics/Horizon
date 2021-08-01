package me.astelics.horizon.commands.essentials;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equals("heal")) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                if (player.getHealth() == 20) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            "&b&lHeal &8&l• &7You are at full health."));
                }
                else if (player.getHealth() < 20) {
                    player.setHealth(20);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            "&b&lHeal &8&l• &7You have been healed to full health."));
                }
            } else {
                System.out.println("[Horizon] Only players can execute this command");
            }
        }
        return false;
    }
}

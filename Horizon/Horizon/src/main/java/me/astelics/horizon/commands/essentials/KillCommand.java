package me.astelics.horizon.commands.essentials;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KillCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equals("kill")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        "&b&lKill &8&l• &7Killed player " + player.getDisplayName()));
                player.setHealth(0);
            } else {
                System.out.println("[Horizon] Only players can execute this command.");
            }
        }
        return false;
    }
}

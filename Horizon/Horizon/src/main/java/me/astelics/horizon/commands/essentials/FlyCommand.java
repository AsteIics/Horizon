package me.astelics.horizon.commands.essentials;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        if (command.getName().equals("fly")) {
            if (sender instanceof Player) {
                if (player.isFlying() == true) {
                    player.setAllowFlight(false);
                    player.setFlying(false);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            "&b&lFlight &8&l• &7You are no loner flying."));
                } else if (player.isFlying() == false) {
                    player.setAllowFlight(true);
                    player.setFlying(true);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            "&b&lFlight &8&l• &7You are now flying."));
                }
            } else {
                System.out.println("[Horizon] Only players can execute this command");
            }
        }
        return false;
    }
}

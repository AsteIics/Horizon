package me.astelics.horizon.commands.random;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class BigMeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        World world = player.getWorld();

        if (command.getName().equals("bigme")) {
            if (sender instanceof Player) {
                world.spawnEntity(player.getLocation(), EntityType.GIANT);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        "&b&lEntities &8&l• &7You have created a big you!"));
            }
            else {
                System.out.println("[Horizon] Only players can execute this command.");
            }
        }
        return false;
    }
}

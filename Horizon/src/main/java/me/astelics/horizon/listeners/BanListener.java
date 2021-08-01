package me.astelics.horizon.listeners;

import me.astelics.horizon.Horizon;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class BanListener implements Listener
{
    Horizon plugin;

    public BanListener(Horizon plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void PlayerJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (plugin.bannedPlayers.contains(player)) {
            String message = ChatColor.RED + "You are permanently banned!" + "\nBy: ";
            player.kickPlayer(message);
        }
    }
}

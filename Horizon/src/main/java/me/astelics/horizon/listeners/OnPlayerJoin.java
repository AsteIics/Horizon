package me.astelics.horizon.listeners;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnPlayerJoin implements Listener
{
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e)
    {
        Player player = e.getPlayer();
        e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', "&3&lHORIZON » &bWelcome to the server " + player.getDisplayName()));
        System.out.println("[Horizon] Player " + player.getDisplayName() + " has joined the server.");
    }
}

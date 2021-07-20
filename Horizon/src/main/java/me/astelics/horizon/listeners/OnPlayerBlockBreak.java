package me.astelics.horizon.listeners;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerHarvestBlockEvent;

public class OnPlayerBlockBreak implements Listener
{
    @EventHandler
    public void OnPlayerHarvestBlock(PlayerHarvestBlockEvent e, Location l, Block b)
    {
        Player player = e.getPlayer();

        player.getWorld().spawnParticle(Particle.CRIT_MAGIC, l, 10);
        player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                "&3&lHORIZON &7» &bYou broke block " + b));
    }
}

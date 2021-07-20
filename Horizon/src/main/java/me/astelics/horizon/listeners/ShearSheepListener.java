package me.astelics.horizon.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerShearEntityEvent;

public class ShearSheepListener implements Listener
{
    @EventHandler
    public void onShearSheep(PlayerShearEntityEvent e)
    {
        Player player = e.getPlayer();
        Entity entity = e.getEntity();

        if ((entity.getType()) == EntityType.SHEEP)
        {
            e.setCancelled(true);
            player.sendMessage("You can't shear sheep!");
        } else {
            player.sendMessage("You can shear this!");
        }
    }
}

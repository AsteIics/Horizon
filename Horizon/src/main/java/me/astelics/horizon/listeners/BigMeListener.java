package me.astelics.horizon.listeners;

import me.astelics.horizon.utils.BigMeUtils;
import org.bukkit.Material;
import org.bukkit.entity.Giant;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.ItemStack;

public class BigMeListener implements Listener
{
    @EventHandler
    public void onSpawn(CreatureSpawnEvent e)
    {
        ItemStack helmet = new ItemStack(Material.CHAINMAIL_HELMET);
        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);

        if(e.getEntity() instanceof Giant)
        {
            LivingEntity le = e.getEntity();
            BigMeUtils.setHelmet(le, helmet);
            BigMeUtils.setChestplate(le, chestplate);
            BigMeUtils.setLeggings(le, leggings);
            BigMeUtils.setBoots(le, boots);
            le.setCustomName("BIG YOU");
        }
    }
}

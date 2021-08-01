package me.astelics.horizon.utils;

import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;

public class BigMeUtils {
    public static void setHelmet(LivingEntity e, ItemStack helmet) {
        EntityEquipment ee = e.getEquipment();
        ee.setHelmet(helmet);
    }

    public static void setChestplate(LivingEntity e, ItemStack chestplate) {
        EntityEquipment ee = e.getEquipment();
        ee.setChestplate(chestplate);
    }

    public static void setLeggings(LivingEntity e, ItemStack leggings) {
        EntityEquipment ee = e.getEquipment();
        ee.setLeggings(leggings);
    }

    public static void setBoots(LivingEntity e, ItemStack boots) {
        EntityEquipment ee = e.getEquipment();
        ee.setBoots(boots);
    }
}

package me.astelics.horizon;

import me.astelics.horizon.listeners.OnPlayerBlockBreak;
import me.astelics.horizon.listeners.OnPlayerJoin;
import me.astelics.horizon.listeners.ShearSheepListener;
import me.astelics.horizon.listeners.XPBottleBreak;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.astelics.horizon.commands.*;

public final class Horizon extends JavaPlugin implements Listener
{

    @Override
    public void onEnable()
    {
        // Plugin startup logic
        System.out.println("[Horizon] Loaded plugin successfully.");

        getServer().getPluginManager().registerEvents(new XPBottleBreak(), this);
        getServer().getPluginManager().registerEvents(new ShearSheepListener(), this);
        getServer().getPluginManager().registerEvents(new OnPlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new OnPlayerBlockBreak(), this);
        getCommand("kill").setExecutor(new KillCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("fly").setExecutor(new FlyCommand());
    }

    @Override
    public void onDisable()
    {
        // Plugin shutdown logic
        System.out.println("[Horizon] Plugin shut down.");
    }
}

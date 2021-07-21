package me.astelics.horizon;

import me.astelics.horizon.commands.*;
import me.astelics.horizon.listeners.*;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Horizon extends JavaPlugin implements Listener
{
    public ArrayList<Player> vanishedPlayers = new ArrayList<>();

    @Override
    public void onEnable()
    {
        // Plugin startup logic
        System.out.println("[Horizon] Loaded plugin successfully.");

        getServer().getPluginManager().registerEvents(new XPBottleBreak(), this);
        getServer().getPluginManager().registerEvents(new ShearSheepListener(), this);
        getServer().getPluginManager().registerEvents(new OnPlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new BigMeListener(), this);
        getServer().getPluginManager().registerEvents(new JoinEvent(this), this);
        getCommand("incognito").setExecutor(new IncognitoCommand(this));
        getCommand("kill").setExecutor(new KillCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("bigme").setExecutor(new BigMeCommand());
    }

    @Override
    public void onDisable()
    {
        // Plugin shutdown logic
        System.out.println("[Horizon] Plugin shut down.");
    }
}

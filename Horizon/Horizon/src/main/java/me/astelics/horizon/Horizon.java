package me.astelics.horizon;

import me.astelics.horizon.commands.essentials.FlyCommand;
import me.astelics.horizon.commands.essentials.HealCommand;
import me.astelics.horizon.commands.essentials.KillCommand;
import me.astelics.horizon.commands.essentials.MessageCommand;
import me.astelics.horizon.commands.punishment.KickCommand;
import me.astelics.horizon.commands.random.BigMeCommand;
import me.astelics.horizon.commands.staff.IncognitoCommand;
import me.astelics.horizon.listeners.*;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Horizon extends JavaPlugin implements Listener {
    public ArrayList<Player> vanishedPlayers = new ArrayList<>();
    public ArrayList<Player> bannedPlayers = new ArrayList<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        loadCommands();
        loadListeners();

        System.out.println("[Horizon] Loaded plugin successfully.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("[Horizon] Plugin shut down.");
    }

    private void loadCommands() {
        getCommand("incognito").setExecutor(new IncognitoCommand(this));
        getCommand("message").setExecutor(new MessageCommand());
        getCommand("kick").setExecutor(new KickCommand());
        getCommand("kill").setExecutor(new KillCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("bigme").setExecutor(new BigMeCommand());
    }

    private void loadListeners() {
        getServer().getPluginManager().registerEvents(new XPBottleBreak(), this);
        getServer().getPluginManager().registerEvents(new ShearSheepListener(), this);
        getServer().getPluginManager().registerEvents(new OnPlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new BigMeListener(), this);
        getServer().getPluginManager().registerEvents(new IncognitoListener(this), this);
    }
}
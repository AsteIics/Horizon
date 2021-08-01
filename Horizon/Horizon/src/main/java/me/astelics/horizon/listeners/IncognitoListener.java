package me.astelics.horizon.listeners;

import me.astelics.horizon.Horizon;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class IncognitoListener implements Listener {

    Horizon plugin;

    public IncognitoListener(Horizon plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler
    public void PlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        for (int i = 0; i < plugin.vanishedPlayers.size(); i++) {
            player.hidePlayer(plugin, plugin.vanishedPlayers.get(i));
        }
    }
}

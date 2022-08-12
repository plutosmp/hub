package top.plutomc.hub;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public final class PlayerListener implements Listener {
    @EventHandler
    public void playerJoinEvent(PlayerJoinEvent event) {
        event.setJoinMessage(null);

        event.getPlayer().setGameMode(GameMode.ADVENTURE);

        event.getPlayer().teleport(event.getPlayer().getWorld().getSpawnLocation());
    }

    @EventHandler
    public void playerQuitEvent(PlayerQuitEvent event) {
        event.setQuitMessage(null);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void asyncPlayerChatEvent(AsyncPlayerChatEvent event) {
        event.setCancelled(true);
        Hub.instance().getServer().broadcast(ChatColor.WHITE + event.getPlayer().getName() + ": " + event.getMessage(), null);
    }
}
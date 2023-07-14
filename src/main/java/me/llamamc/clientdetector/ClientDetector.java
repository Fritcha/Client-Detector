package me.llamamc.clientdetector;

import me.llamamc.clientdetector.commands.ClientCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class ClientDetector extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getCommand("client").setExecutor(new ClientCommand());
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info("Client Detector loaded successfully!");

    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if(getConfig().getBoolean("IncludeClientInJoinMessage")) {
            event.setJoinMessage("");
            Bukkit.getScheduler().runTaskLater(this, () -> {
                Bukkit.broadcastMessage("§e" + event.getPlayer().getDisplayName() + " joined the game using " + event.getPlayer().getClientBrandName());

            }, 2L);
        }
        Bukkit.getScheduler().runTaskLater(this, () -> {
            if(getConfig().getStringList("BlockedClients").contains(event.getPlayer().getClientBrandName())) {
                event.getPlayer().kickPlayer("§cClient: " + "\"" + event.getPlayer().getClientBrandName() + "\" is not allowed on this server!");

            }
        }, 2L);
    }
}

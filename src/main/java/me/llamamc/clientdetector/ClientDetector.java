package me.llamamc.clientdetector;

import me.llamamc.clientdetector.commands.ClientCommand;
import me.llamamc.clientdetector.commands.MainCommand;
import me.llamamc.clientdetector.commands.MainCommandCompletions;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class ClientDetector extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        saveDefaultConfig();
        getCommand("client").setExecutor(new ClientCommand());
        getCommand("clientdetector").setExecutor(new MainCommand());
        getCommand("clientdetector").setTabCompleter(new MainCommandCompletions());
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info("Client Detector loaded successfully!");

    }
    @Override
    public void onDisable() {
        getLogger().warning("Client Detector disabling!");

    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if(getConfig().getBoolean("IncludeClientInJoinMessage")) {
            if(!event.getPlayer().hasPermission("clientdetector.joinmessage.hide")) {
                event.setJoinMessage("");
                Bukkit.getScheduler().runTaskLater(this, () -> {
                    Bukkit.broadcastMessage("§e" + event.getPlayer().getDisplayName() + " joined the game using " + event.getPlayer().getClientBrandName());

                }, 3L);
            }
        }
        Bukkit.getScheduler().runTaskLater(this, () -> {
            if(getConfig().getStringList("BlockedClients").contains(event.getPlayer().getClientBrandName())) {
                if(!event.getPlayer().hasPermission("clientdetector.clientblocker.bypass")) {
                    if(getConfig().getBoolean("CrashBlockedClients")) {
                        Bukkit.getScheduler().runTaskAsynchronously(new ClientDetector(), () -> {
                            for(int i = 0; i < getConfig().getInt("DisplayAmount"); i++) {
                                if(event.getPlayer().isOnline()) {
                                    event.getPlayer().showElderGuardian();

                                } else {
                                    return;

                                }
                            }
                        });
                    } else {
                        event.getPlayer().kickPlayer("§cClient: " + "\"" + event.getPlayer().getClientBrandName() + "\" is not allowed on this server!");

                    }
                }
            }
        }, 2L);
    }
}

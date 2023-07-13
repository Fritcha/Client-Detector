package me.llamamc.clientdetector;

import me.llamamc.clientdetector.commands.ClientCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class ClientDetector extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Client Detector loaded successfully!");
        getCommand("client").setExecutor(new ClientCommand());

    }
}

package me.llamamc.clientdetector.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class MainCommand implements CommandExecutor {
    final Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("ClientDetector");
    @Override
    public boolean onCommand(@NotNull CommandSender executor, @NotNull Command command, @NotNull String name, String[] args) {
        if(args.length > 1) {
            executor.sendMessage("Usage: /clientdetector <arg>");
            return true;

        } else if(args.length < 1) {
            executor.sendMessage("Usage: /clientdetector <arg>");
            return true;

        } else if(args[0].equals("reload")) {
            assert plugin != null;
            plugin.reloadConfig();
            executor.sendMessage("§1§l[§6§lC§a§lD§1§l] §aSuccessfully reloaded the config!");
            return true;

        } else {
            executor.sendMessage("Usage: /clientdetector <arg>");
            return true;
        }
    }
}

package me.llamamc.clientdetector.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class ClientCommand implements CommandExecutor {
    Plugin plugin = Objects.requireNonNull(Bukkit.getPluginManager().getPlugin("ClientDetector"));
    public static void reload(Plugin plugin) {
        plugin.reloadConfig();

    }
    @Override
    public boolean onCommand(@NotNull CommandSender executor, @NotNull Command command, @NotNull String name, String[] args) {
        if (executor instanceof Player) {
            Player player = (Player) executor;
            if (args.length < 1) {
                player.sendMessage("Usage: /client <player>");
                return false;

            } else if (args.length > 1) {
                player.sendMessage("Usage: /client <player>");
                return false;

            } else {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (target != null) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('$', Objects.requireNonNull(plugin.getConfig().getString("MessagePrefix"))) + ChatColor.RESET + target.getName() + "'s client is" + ChatColor.GRAY + ": " + ChatColor.GREEN + target.getClientBrandName());
                    return true;

                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('$', Objects.requireNonNull(plugin.getConfig().getString("MessagePrefix"))) + ChatColor.RED + "That player does not exist!");
                    return false;

                }
            }
        } else {
            return false;

        }
    }
}

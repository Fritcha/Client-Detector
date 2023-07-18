package me.llamamc.clientdetector.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ClientCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender executor, @NotNull Command command, @NotNull String name, String[] args) {
        if (executor instanceof Player) {
            Player player = (Player) executor;
            if (args.length < 1) {
                player.sendMessage("Usage: /client <player>");
                return true;

            } else if (args.length > 1) {
                player.sendMessage("Usage: /client <player>");
                return true;

            } else {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (target != null) {
                    player.sendMessage("§1§l[§6§lC§a§lD§1§l] §eThe name of " + target.getName() + "'s client is§7: §a" + target.getClientBrandName());

                } else {
                    player.sendMessage("§1§l[§6§lC§a§lD§1§l] §cThat player does not exist!");

                }
            }
            return true;
        }
    return true;
    }
}

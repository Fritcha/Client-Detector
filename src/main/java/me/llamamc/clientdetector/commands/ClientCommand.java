package me.llamamc.clientdetector.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClientCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender executor, Command command, String name, String[] args) {
        if (executor instanceof Player) {
            Player player = (Player) executor;
            if(player.hasPermission("clientdetector.command.client")) {
                if (args.length < 1) {
                    player.sendMessage("Usage: /client <player>");
                    return true;

                } else if (args.length > 1) {
                    player.sendMessage("Usage: /client <player>");

                } else {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if (target != null) {
                        player.sendMessage("§1§l[§6§lC§a§lD§1§l] §rThe name of " + target.getName() + "'s client is: §a" + target.getClientBrandName());

                    } else {
                        player.sendMessage("§1§l[§6§lC§a§lD§1§l] §rThat player does not exist!");

                    }
                }
                return true;
            }
        }
    return true;
    }
}

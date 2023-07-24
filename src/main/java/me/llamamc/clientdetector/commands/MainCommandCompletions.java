package me.llamamc.clientdetector.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;

public class MainCommandCompletions implements TabCompleter {
    @Override
    public List<String> onTabComplete(@NotNull CommandSender executor, @NotNull Command command, @NotNull String name, String[] args) {
        if(args.length == 1) {
            List<String> tabCompletions = new ArrayList<>();
            tabCompletions.add("reload");
            return tabCompletions;

        }
        return null;

    }
}
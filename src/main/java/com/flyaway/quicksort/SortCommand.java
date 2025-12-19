package com.flyaway.quicksort;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SortCommand implements CommandExecutor {
    private final QuickSort plugin;

    public SortCommand(QuickSort plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            plugin.sendMessage(sender, "players-only");
            return true;
        }

        if (args.length > 0 && args[0].equalsIgnoreCase("reload")) {
            if (!player.hasPermission("quicksort.reload")) {
                plugin.sendMessage(player, "no-permissions");
                return true;
            }

            plugin.reloadConfig();
            plugin.sendMessage(player, "reloaded");
            return true;
        }

        return true;
    }
}

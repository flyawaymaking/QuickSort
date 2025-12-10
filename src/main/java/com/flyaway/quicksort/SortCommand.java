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
            sender.sendMessage("§cЭта команда только для игроков!");
            return true;
        }

        if (args.length > 0 && args[0].equalsIgnoreCase("reload")) {
            if (!player.hasPermission("quicksort.reload")) {
                player.sendMessage("§cУ вас нет прав для перезагрузки конфига!");
                return true;
            }

            plugin.reloadConfig();
            player.sendMessage("§aКонфиг QuickSort перезагружен!");
            return true;
        }

        return true;
    }
}

package de.l50n.artflower.commands.userinterface;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Level;

public class InterfaceCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_USE, 1, 1); // Needs to get tested
        } else {
            Bukkit.getLogger().log(Level.INFO, "Dieser Befehl muss von einem Spieler ausgeführt werden!");
        }
        return false;
    }
}

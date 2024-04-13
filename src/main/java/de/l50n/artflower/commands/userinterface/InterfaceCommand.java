package de.l50n.artflower.commands.userinterface;

import de.l50n.artflower.main.ArtFlower;
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

            if (strings.length == 1) {
                switch (strings[0].toLowerCase()) {
                    case "version":
                        player.sendMessage(ArtFlower.getPrefix() + " The status is retrieved...");
                        player.performCommand("version artflower");
                        break;
                    case "sourcecode":
                        player.sendMessage(ArtFlower.getPrefix() + " https://github.com/L50N/art-flower");
                        break;
                    case "open":
                        player.sendMessage(ArtFlower.getPrefix() + " Loading the interface...");
                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1, 1);
                        ArtFlower.getInterfaceInventory().openInventory(player.getPlayer());
                        break;
                    case "help":
                        player.sendMessage(ArtFlower.getPrefix() + " Use \"interface\" followed by one of the arguments (help, open, sourcecode, version)");
                        break;
                    default:
                        player.sendMessage(ArtFlower.getPrefix() + " Wrong argument - use \"interface help\" for more!");
                        break;
                }
            } else {
                player.sendMessage(ArtFlower.getPrefix() + " Loading the interface...");
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1, 1);
                ArtFlower.getInterfaceInventory().openInventory(player.getPlayer());
            }
        } else {
            Bukkit.getLogger().log(Level.INFO, "You must be a player to execute this command!");
        }
        return false;
    }
}

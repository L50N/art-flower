package de.l50n.artflower.commands.facilitations;

import de.l50n.artflower.main.ArtFlower;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Level;

public class GamemodeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            if (strings.length == 1) {
                switch (strings[0].toLowerCase()) {
                    case "survival", "0":
                        player.sendMessage(ArtFlower.getPrefix() + " You are now in survival-mode.");
                        player.setGameMode(GameMode.SURVIVAL);
                        break;
                    case "creative", "1":
                        player.sendMessage(ArtFlower.getPrefix() + " You are now in creative-mode.");
                        player.setGameMode(GameMode.CREATIVE);
                        break;
                    case "adventure", "2":
                        player.sendMessage(ArtFlower.getPrefix() + " You are now in adventure-mode.");
                        player.setGameMode(GameMode.ADVENTURE);
                        break;
                    case "spectator", "3":
                        player.sendMessage(ArtFlower.getPrefix() + " You are now in spectator-mode.");
                        player.setGameMode(GameMode.SPECTATOR);
                        break;
                    default:
                        player.playSound(player.getLocation(), Sound.ITEM_GOAT_HORN_SOUND_6, 1, 1);
                        player.sendMessage(ArtFlower.getPrefix() + " Wrong selection - this game mode does not exist!");
                        break;
                }
            } else {
                player.sendMessage(ArtFlower.getPrefix() + " Usage: /switch to select");
            }
        } else {
            Bukkit.getLogger().log(Level.INFO, "You must be a player to execute this command!");
        }

        return false;
    }
}

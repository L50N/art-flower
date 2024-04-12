package de.l50n.artflower.main;

import de.l50n.artflower.commands.CommandHandler;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Author - L5ON
 * GitHub - https://github.com/L50N
 * Created - 17.12.2023
 */

public final class ArtFlower extends JavaPlugin {
    public static ArtFlower instance;
    public static String ArcPrefix = "§f・§cArtFlower §7>>";

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        CommandHandler commandHandler = new CommandHandler();
        commandHandler.registerCommands();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        instance = null;
    }

    public static ArtFlower getInstance() {
        return instance;
    }

    public static String getPrefix() {
        return ArcPrefix;
    }
}

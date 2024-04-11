package de.l50n.artflower.main;

import de.l50n.artflower.commands.RegisterCommandHandler;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Author - L5ON
 * GitHub - https://github.com/L50N
 * Created - 17.12.2023
 */

public final class ArtFlower extends JavaPlugin {
    public static ArtFlower instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        RegisterCommandHandler registerCommandHandler = new RegisterCommandHandler();
        registerCommandHandler.registerCommands();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        instance = null;
    }

    public static ArtFlower getInstance() {
        return instance;
    }
}

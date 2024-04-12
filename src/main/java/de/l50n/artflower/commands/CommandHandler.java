package de.l50n.artflower.commands;

import de.l50n.artflower.commands.facilitations.GamemodeCommand;
import de.l50n.artflower.commands.userinterface.InterfaceCommand;
import de.l50n.artflower.main.ArtFlower;

public class CommandHandler {
    public void registerCommands() {
        ArtFlower.getInstance().getCommand("interface").setExecutor(new InterfaceCommand());
        ArtFlower.getInstance().getCommand("gm").setExecutor(new GamemodeCommand());
    }
}

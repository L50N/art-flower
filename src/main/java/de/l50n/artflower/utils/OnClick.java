package de.l50n.artflower.utils;

import org.bukkit.event.inventory.InventoryClickEvent;

@FunctionalInterface
public interface OnClick {
    void run(InventoryClickEvent event);
}
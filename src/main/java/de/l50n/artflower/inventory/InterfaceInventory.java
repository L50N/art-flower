package de.l50n.artflower.inventory;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InterfaceInventory implements Listener {
    private final Inventory inventory;

    public InterfaceInventory() {
        inventory = Bukkit.createInventory(null, 9*5, "ArtFlower Interface");
        initializeItems();
    }

    public void openInventory(final HumanEntity player) {
        player.openInventory(inventory);
    }

    private void initializeItems() {
        inventory.addItem(new ItemStack(Material.ACACIA_BOAT));
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getInventory().equals(event.getWhoClicked().getInventory())) {
            event.setCancelled(true);
        }
    }
}

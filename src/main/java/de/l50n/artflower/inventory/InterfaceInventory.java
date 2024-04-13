package de.l50n.artflower.inventory;

import de.l50n.artflower.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InterfaceInventory implements Listener {
    private HashMap<Integer, ItemBuilder> inventoryItems = new HashMap<>();
    private final Inventory inventory;

    public InterfaceInventory() {
        inventory = Bukkit.createInventory(null, 9*6, "ArtFlower Interface");
        initializeBottomBarItems();
        initializeFlowers();
    }

    public void openInventory(final HumanEntity player) {
        initializeInventory();
        player.openInventory(inventory);
    }

    private void initializeInventory() {
        for (int i = 0; i < inventory.getSize(); i++) {
            inventory.setItem(i, null);
        }

        initializeBottomBarItems();
        initializeFlowers();
    }

    private void initializeBottomBarItems() {
        // Inventory Bottom-Bar (Placeholder)
        ItemBuilder inventoryPlaceholder = new ItemBuilder("§r", Material.GRAY_STAINED_GLASS_PANE);

        int bottomBarPlaceholder[] = {36,37,40,43,44};
        inventoryPlaceholder.build();
        for (int i : bottomBarPlaceholder) {
            inventory.setItem(i, inventoryPlaceholder.getItemStack());
        }

        // Inventory Bottom-Bar (Items)
        ItemBuilder backItem = new ItemBuilder("§aOne page back", Material.PLAYER_HEAD);
        backItem.setLore("§7§oGo back one page of the flower list");
        backItem.buildCustomHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDAyY2YwZGVhNGQwNmVmMWRlMjU1YmI4MTVmNjQyNjhkNjhiYjNiOTAzZDYwNjIxYWU5MmUwMDdlMjg4MTk4YyJ9fX0=");
        inventoryItems.put(38, backItem);

        ItemBuilder nextItem = new ItemBuilder("§aOne page further", Material.PLAYER_HEAD);
        nextItem.setLore("§7§oGo one page further in the flower list");
        nextItem.setOnClick(event -> {
            cleanupInventory();
        });
        nextItem.buildCustomHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjVkYTE4NDU0NmEwNWRlOTZhNGQxZmI4MjBmNzJjMDlmMTU5N2RmNTZkODhhNGFiMzVlOWI0YTJjNzgwYWI4NCJ9fX0=");
        inventoryItems.put(39, nextItem);

        ItemBuilder finalizeFlower = new ItemBuilder("§aFinalize flower", Material.FLOWER_POT);
        finalizeFlower.setLore("§7§oFinish the flower you have created");
        finalizeFlower.build();
        inventoryItems.put(41, finalizeFlower);

        ItemBuilder resetConfiguration = new ItemBuilder("§aReset configuration", Material.BREWING_STAND);
        resetConfiguration.setLore("§7§oCreate a new flower by deleting your old one.");
        resetConfiguration.build();
        inventoryItems.put(42, resetConfiguration);

        for (Map.Entry<Integer, ItemBuilder> integerItemBuilderEntry : inventoryItems.entrySet()) {
            inventory.setItem(integerItemBuilderEntry.getKey(), integerItemBuilderEntry.getValue().getItemStack());
        }
    }

    private void cleanupInventory() {
        for (int i = 0; i <= 35; i++) {
            inventory.setItem(i, null);
        }
    }

    private void initializeFlowers() {
        ArrayList<Material> flowers = new ArrayList<>();
        flowers.add(Material.SUNFLOWER);
        flowers.add(Material.LILAC);
        flowers.add(Material.ROSE_BUSH);
        flowers.add(Material.PEONY);
        flowers.add(Material.TALL_GRASS);
        flowers.add(Material.GRASS);
        flowers.add(Material.DEAD_BUSH);
        flowers.add(Material.FERN);
        flowers.add(Material.LARGE_FERN);
        flowers.add(Material.DANDELION);
        flowers.add(Material.POPPY);
        flowers.add(Material.BLUE_ORCHID);
        flowers.add(Material.ALLIUM);
        flowers.add(Material.AZURE_BLUET);
        flowers.add(Material.RED_TULIP);
        flowers.add(Material.ORANGE_TULIP);
        flowers.add(Material.WHITE_TULIP);
        flowers.add(Material.PINK_TULIP);
        flowers.add(Material.OXEYE_DAISY);
        flowers.add(Material.CORNFLOWER);
        flowers.add(Material.WITHER_ROSE);
        flowers.add(Material.BROWN_MUSHROOM);
        flowers.add(Material.RED_MUSHROOM);
        flowers.add(Material.CRIMSON_FUNGUS);
        flowers.add(Material.WARPED_FUNGUS);
        flowers.add(Material.TORCHFLOWER);
        flowers.add(Material.TORCHFLOWER_SEEDS);
        flowers.add(Material.PITCHER_POD);
        flowers.add(Material.PINK_PETALS);

        // Testing flowers
        flowers.add(Material.PINK_PETALS);
        flowers.add(Material.PINK_PETALS);
        flowers.add(Material.PINK_PETALS);
        flowers.add(Material.PINK_PETALS);
        flowers.add(Material.PINK_PETALS);
        flowers.add(Material.PINK_PETALS);
        flowers.add(Material.PINK_PETALS);
        flowers.add(Material.PINK_PETALS);
        flowers.add(Material.PINK_PETALS);
        flowers.add(Material.PINK_PETALS);
        flowers.add(Material.PINK_PETALS);
        flowers.add(Material.PINK_PETALS);
        flowers.add(Material.PINK_PETALS);
        flowers.add(Material.PINK_PETALS);
        flowers.add(Material.PINK_PETALS);
        flowers.add(Material.PINK_PETALS);
        flowers.add(Material.PINK_PETALS);
        flowers.add(Material.PINK_PETALS);
        flowers.add(Material.PINK_PETALS);

        int i = -1;
        for (Material flower : flowers) {
            i++;
            if (i <= 35) {
                inventory.setItem(i, new ItemStack(flower));
            }
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player) {
            if (event.getSlotType() == InventoryType.SlotType.CONTAINER && event.getCurrentItem() != null) {
                Player player = (Player) event.getWhoClicked();
                if (event.getInventory().equals(inventory)) {
                    event.setCancelled(true);
                    ItemBuilder clickedItem = inventoryItems.get(event.getSlot());
                    if (clickedItem!=null) {
                        if (clickedItem.isClickable()) {
                            ((Player) event.getWhoClicked()).playSound(event.getWhoClicked(), Sound.BLOCK_NOTE_BLOCK_IRON_XYLOPHONE,0.3f,1f);
                            clickedItem.getOnClick().run(event);
                        }
                    }
                }
            }
        }
    }
}

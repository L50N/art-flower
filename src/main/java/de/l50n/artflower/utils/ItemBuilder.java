package de.l50n.artflower.utils;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ItemBuilder {
    private ItemStack itemStack;
    private String name;
    private Material material;
    private int amount;
    private List<String> lore;
    private List<Enchantment> enchantments;
    private String value;
    private int id;
    private boolean unbreakable;
    private OnClick onClick;

    public ItemBuilder(String name, Material material, int amount) {
        this.name = name;
        this.material = material;
        this.amount = amount;
        this.lore = new ArrayList<>();
        this.enchantments = new ArrayList<>();
        this.value = "";
        this.id = -1;
        this.unbreakable = false;
        build();
    }

    public ItemBuilder(String name, Material material) {
        this(name,material,1);
    }

    public ItemBuilder build() {
        itemStack = new ItemStack(material, amount);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        itemMeta.setUnbreakable(unbreakable);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.addItemFlags(ItemFlag.HIDE_ITEM_SPECIFICS);
        for (Enchantment enchantment : enchantments) {
            itemMeta.addEnchant(enchantment.getEnchantment(),enchantment.getLevel(),true);
        }
        if(!this.lore.isEmpty()) {
            itemMeta.setLore(this.lore);
        }
        itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemBuilder buildPlayerHead(Player player) {
        setMaterial(Material.PLAYER_HEAD);
        build();
        SkullMeta meta = (SkullMeta) itemStack.getItemMeta();
        meta.setOwningPlayer(player);
        itemStack.setItemMeta(meta);
        return this;
    }

    public ItemBuilder buildPlayerHead(OfflinePlayer player) {
        setMaterial(Material.PLAYER_HEAD);
        build();
        SkullMeta meta = (SkullMeta) itemStack.getItemMeta();
        meta.setOwningPlayer(player);
        itemStack.setItemMeta(meta);
        return this;
    }

    public ItemBuilder buildPlayerHead(String playerName) {
        return buildPlayerHead(Bukkit.getOfflinePlayer(playerName));
    }

    public ItemBuilder buildPlayerHead(UUID playerUUID) {
        return buildPlayerHead(Bukkit.getOfflinePlayer(playerUUID));
    }

    public ItemBuilder buildCustomHead(String value) {
        setValue(value);
        setMaterial(Material.PLAYER_HEAD);
        build();
        SkullMeta meta = (SkullMeta) itemStack.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), name);
        profile.getProperties().put("textures", new Property("textures", value));
        Field profileField = null;
        try {
            profileField = meta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(meta, profile);
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }
        itemStack.setItemMeta(meta);
        return this;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public ItemBuilder setItemStack(ItemStack itemStack) {
        this.itemStack = itemStack;
        return this;
    }

    public String getName() {
        return name;
    }

    public ItemBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public Material getMaterial() {
        return material;
    }

    public ItemBuilder setMaterial(Material material) {
        this.material = material;
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public ItemBuilder setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public List<String> getLore() {
        return lore;
    }

    public ItemBuilder setLore(List<String> lore) {
        this.lore = lore;
        return this;
    }

    public ItemBuilder setLore(String... lore) {
        this.lore = List.of(lore);
        return this;
    }

    public List<Enchantment> getEnchantments() {
        return enchantments;
    }

    public ItemBuilder setEnchantments(List<Enchantment> enchantments) {
        this.enchantments = enchantments;
        return this;
    }

    public String getValue() {
        return value;
    }

    public ItemBuilder setValue(String value) {
        this.value = value;
        return this;
    }

    public int getId() {
        return id;
    }

    public ItemBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public boolean isUnbreakable() {
        return unbreakable;
    }

    public ItemBuilder setUnbreakable(boolean unbreakable) {
        this.unbreakable = unbreakable;
        return this;
    }

    public boolean isClickable() {
        return onClick != null;
    }

    public OnClick getOnClick() {
        return onClick;
    }

    public ItemBuilder setOnClick(OnClick onClick) {
        this.onClick = onClick;
        return this;
    }
}

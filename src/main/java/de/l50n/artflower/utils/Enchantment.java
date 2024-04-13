package de.l50n.artflower.utils;

public class Enchantment {
    private int level;
    private org.bukkit.enchantments.Enchantment enchantment;

    public Enchantment(org.bukkit.enchantments.Enchantment enchantment, int level) {
        this.level = level;
        this.enchantment = enchantment;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public org.bukkit.enchantments.Enchantment getEnchantment() {
        return enchantment;
    }

    public void setEnchantment(org.bukkit.enchantments.Enchantment enchantment) {
        this.enchantment = enchantment;
    }
}

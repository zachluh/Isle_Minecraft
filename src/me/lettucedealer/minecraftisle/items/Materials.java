package me.lettucedealer.minecraftisle.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Materials {

    public ItemStack Kevlar() {
        ItemStack kevlar = new ItemStack(Material.DRIED_KELP);
        ItemMeta meta = kevlar.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN + "Kevlar");

        meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        
        kevlar.setItemMeta(meta);
        return kevlar;
    }

    public ItemStack Plastic(int coal_blocks) {
        ItemStack plastic = new ItemStack(Material.WHITE_DYE, coal_blocks);
        ItemMeta meta = plastic.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "Plastic");

        List<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add(ChatColor.ITALIC + "Rarity: " + ChatColor.YELLOW + "Level 2");
        meta.setLore(lore);

        plastic.setItemMeta(meta);
        return plastic;
    }
}

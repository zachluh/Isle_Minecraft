package me.lettucedealer.minecraftisle.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Weapons {
    public ItemStack scoped_rifle(String ammo) {
        ItemStack sniper = new ItemStack(Material.WOODEN_HOE);
        ItemMeta meta = sniper.getItemMeta();
        meta.setDisplayName("Scoped Rifle");
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.ITALIC + ammo + " / " + ammo);
        meta.setLore(lore);

        meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        sniper.setItemMeta(meta);

        return sniper;
    }
}

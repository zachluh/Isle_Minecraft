package me.lettucedealer.minecraftisle.items;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.List;

public class Armor {

    public ItemStack Ballistic_Vest() {
        ItemStack vest = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta vest_meta =  (LeatherArmorMeta) vest.getItemMeta();

        vest_meta.setColor(Color.BLUE);
        vest_meta.setDisplayName(ChatColor.BLUE + "Ballistic Vest");

        vest_meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 1, true);
        vest_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        vest_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        List<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add(ChatColor.ITALIC + "Rarity: " + ChatColor.YELLOW + "Level 3");
        vest_meta.setLore(lore);

        vest.setItemMeta(vest_meta);

        return vest;
    }


}

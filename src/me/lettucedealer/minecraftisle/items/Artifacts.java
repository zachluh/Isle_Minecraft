package me.lettucedealer.minecraftisle.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Artifacts {


    public ItemStack artifactA() {
        ItemStack artifact = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
        ItemMeta meta = artifact.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Artifact A");
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GREEN + "" + ChatColor.ITALIC + "You might want this during an ambush");
        meta.setLore(lore);

        meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        artifact.setItemMeta(meta);

        return artifact;
    }

    public ItemStack artifactB() {
        ItemStack artifact = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta meta = artifact.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Artifact B");
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GREEN + "" + ChatColor.ITALIC + "Become as strong as 10 of your fellow men");
        meta.setLore(lore);

        meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        artifact.setItemMeta(meta);

        return artifact;
    }

    public ItemStack artifactC() {
        ItemStack artifact = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
        ItemMeta meta = artifact.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "Artifact C");
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GREEN + "" + ChatColor.ITALIC + "See everything");
        meta.setLore(lore);

        meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        artifact.setItemMeta(meta);

        return artifact;
    }

    public ItemStack artifactD() {
        ItemStack artifact = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta meta = artifact.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Artifact D");
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GREEN + "" + ChatColor.ITALIC + "A second chance");
        meta.setLore(lore);

        meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        artifact.setItemMeta(meta);

        return artifact;
    }

}

package me.lettucedealer.minecraftisle.items;

import net.minecraft.server.v1_16_R1.Items;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.List;

public class Headwear {
    public ItemStack Night_Vision() {

        ItemStack goggles = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta gogglesmeta =  (LeatherArmorMeta) goggles.getItemMeta();

        gogglesmeta.setColor(Color.BLACK);
        gogglesmeta.setDisplayName(ChatColor.GREEN + "Night Vision Goggles");

        goggles.setItemMeta(gogglesmeta);

        return goggles;
    }
}

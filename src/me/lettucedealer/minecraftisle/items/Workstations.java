package me.lettucedealer.minecraftisle.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Workstations {

    public ItemStack Material_Compressor() {
        ItemStack material_compressor = new ItemStack(Material.BLAST_FURNACE);
        ItemMeta meta = material_compressor.getItemMeta();

        meta.setDisplayName(ChatColor.GOLD + "Material Compressor");
        material_compressor.setItemMeta(meta);

        return material_compressor;

    }
}

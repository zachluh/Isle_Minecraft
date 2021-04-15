package me.lettucedealer.minecraftisle.GUIPanels;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class WorkstationsGUI {

    public boolean isActive;

    public void createCompressorInv(Player player) {
        Inventory inv = Bukkit.createInventory(null, 9, "Material Compressor");

        ItemStack exit = new ItemStack(Material.BARRIER);
        ItemMeta exitMeta = exit.getItemMeta();

        exitMeta.setDisplayName(ChatColor.RED + "Exit");

        List<String> exitLore = new ArrayList<String>();
        exitLore.add(ChatColor.GREEN + "Click to exit");
        exitMeta.setLore(exitLore);
        exit.setItemMeta(exitMeta);

        inv.setItem(8, exit);

        player.openInventory(inv);

    }
}

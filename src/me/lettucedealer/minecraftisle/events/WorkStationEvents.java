package me.lettucedealer.minecraftisle.events;


import me.lettucedealer.minecraftisle.GUIPanels.WorkstationsGUI;
import me.lettucedealer.minecraftisle.Main;
import me.lettucedealer.minecraftisle.items.Materials;
import me.lettucedealer.minecraftisle.items.Workstations;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class WorkStationEvents implements Listener {
    private Workstations workstations = new Workstations();
    private WorkstationsGUI gui = new WorkstationsGUI();
    private Materials mats = new Materials();

    public WorkStationEvents(Main plugin) {

    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
       Player player = event.getPlayer();
       player.sendMessage("it passed");
        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            Block block = event.getClickedBlock();
            int xAxis = block.getLocation().getBlockX();
            int yAxis = block.getLocation().getBlockY();
            int zAxis = block.getLocation().getBlockZ();
            if (block.getType().equals(Material.COBBLESTONE_WALL)) {
                if (new Location(block.getWorld() ,xAxis, yAxis-1, zAxis).getBlock().getType().equals(Material.BLAST_FURNACE)) {
                    gui.createCompressorInv(event.getPlayer());
                }
            }
        }
    }

    @EventHandler
    public void onGuiInteract(InventoryClickEvent event) {
        if (event.getView().getTitle().equals("Material Compressor")) {
            Bukkit.broadcastMessage("inventory opened");
                    if (event.getCurrentItem().getType().equals(Material.COAL_BLOCK)) {
                        event.getClickedInventory().setItem(event.getSlot(), mats.Plastic(event.getCurrentItem().getAmount()));
            }
        }
    }

}

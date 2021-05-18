package me.lettucedealer.minecraftisle.weaponry;

import net.minecraft.server.v1_16_R1.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Weapon {
    public int ammo;
    public int mag_size;

    public Weapon(int ammo, int mag_size) {
        this.ammo = ammo;
        this.mag_size = mag_size;



    }

    @EventHandler
    public void updateAmmoEvent(PlayerInteractEvent event, ItemStack item) {
        String currentAmmo = item.getItemMeta().getLore().get(0);
        String[] ammoString = currentAmmo.split(" ");
        int newAmmo = Integer.parseInt(ammoString[0]) - 1;

        item.getItemMeta().getLore().set(0, newAmmo + " / " + mag_size);
    }

}

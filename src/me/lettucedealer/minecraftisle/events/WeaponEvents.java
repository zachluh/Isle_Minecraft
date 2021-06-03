package me.lettucedealer.minecraftisle.events;


import me.lettucedealer.minecraftisle.Main;
import me.lettucedealer.minecraftisle.weaponry.Scoped_Rifle;
import me.lettucedealer.minecraftisle.weaponry.Weapon;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.bukkit.Bukkit.getLogger;

public class WeaponEvents implements Listener {

    HashMap<String, Weapon> map = new HashMap<String, Weapon>();
    Scoped_Rifle scopedRifle = new Scoped_Rifle();

    public WeaponEvents() {
        map.put("Scoped Rifle", scopedRifle);
    }



    @EventHandler(priority = EventPriority.HIGHEST)
    public void shoot(PlayerInteractEvent event) {
        getLogger().info("1");
        ItemStack item = event.getItem();
        
        if (item != null) {
            getLogger().info("2");
            Weapon weapon = map.get(item.getItemMeta().getDisplayName());
            getLogger().info(item.getItemMeta().getDisplayName());


            if (weapon != null) {
                getLogger().info("true");
                weapon.shoot(event.getPlayer());
            }

            else {
                getLogger().info("null");
            }
        }



    }


}


package me.lettucedealer.minecraftisle.events;

import me.lettucedealer.minecraftisle.Main;
import me.lettucedealer.minecraftisle.items.Artifacts;
import me.lettucedealer.minecraftisle.items.Headwear;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ArtifactEvents implements Listener {
    public Artifacts artifacts = new Artifacts();
    public Headwear headwear = new Headwear();
    public boolean isActive = false;
    public boolean hasNightVision = false;
    public boolean hasBallistic = false;
    public ArtifactEvents(Main plugin) {

    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {

        if (!(event.getEntity() instanceof Player)) {
            return;
        }
        Player player = (Player) event.getEntity();
        for (ItemStack item : player.getInventory().getContents()) {
            if (item != null && item.hasItemMeta()) {
                if (item.getItemMeta().getDisplayName().contains("Artifact A")) {
                    player.sendMessage(ChatColor.GREEN + "You are invisible!");
                    player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 4000, 10));
                }

                if (item.getItemMeta().getDisplayName().contains("Artifact D") && player.getHealth() <= 2) {
                    player.getInventory().removeItem(item);
                    player.sendMessage(ChatColor.GREEN + "Your heart starts to pump again!");
                    player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 8000, 3));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 8000, 6));
                    player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                }
            }
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Artifact B")) {
            isActive = !isActive;
            if (isActive) {
                player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Artifact B" + ChatColor.GREEN + " has been activated");
                player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 3));
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 3));
                player.sendMessage(ChatColor.GREEN + "You feel way stronger than before");
            }

            else {
                player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Artifact B" + ChatColor.GREEN + " has been deactivated");
                player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
                player.removePotionEffect(PotionEffectType.SPEED);
            }
        }
    }

    @EventHandler
    public void onDropItem(PlayerDropItemEvent e) {
        Item item = e.getItemDrop();
        Player player = (Player) e.getPlayer();
        if (item.getItemStack().hasItemMeta()) {
            if (item.getItemStack().getItemMeta().getDisplayName().contains("Artifact B")) {
                player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
                player.removePotionEffect(PotionEffectType.SPEED);
            }
        }
    }

    @EventHandler
    public void onClickEvent(InventoryClickEvent e) {

        hasNightVision = false;
        hasBallistic = false;
        Player player = (Player) e.getWhoClicked();
        AttributeInstance health = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        for (ItemStack item: e.getWhoClicked().getInventory().getArmorContents()) {
            if (item != null && item.hasItemMeta()) {
                if (item.getItemMeta().getDisplayName().contains("Night Vision Goggles")) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 3));
                    hasNightVision = true;

                }

                if (item.getItemMeta().getDisplayName().contains("Ballistic Vest")) {

                    health.setBaseValue(40);
                    player.setHealth(health.getValue());
                    hasBallistic = true;
                }
            }
        }

        if (!hasNightVision) {
            player.removePotionEffect(PotionEffectType.NIGHT_VISION);
        }

        if (!hasBallistic) {
            health.setBaseValue(20);
            player.setHealth(health.getValue());
        }
    }

}

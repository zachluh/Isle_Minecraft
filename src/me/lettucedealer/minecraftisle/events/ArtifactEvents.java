package me.lettucedealer.minecraftisle.events;

import me.lettucedealer.minecraftisle.Main;
import me.lettucedealer.minecraftisle.items.Artifacts;
import me.lettucedealer.minecraftisle.items.Headwear;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

import static org.apache.logging.log4j.LogManager.getLogger;

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
        ItemStack item = player.getInventory().getItemInMainHand();

        if (item != null && item.hasItemMeta()) {
            if (item.getItemMeta().getDisplayName().contains("Artifact B")) {
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
    public void onMoveEvent(PlayerMoveEvent e) {

        boolean isThere = false;
        hasNightVision = false;
        hasBallistic = false;
        Player player = e.getPlayer();
        AttributeInstance health = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        for (ItemStack item: player.getInventory().getArmorContents()) {
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



        for (ItemStack item: player.getInventory().getContents()) {

            if (item != null && item.hasItemMeta()) {
                if (item.getItemMeta().getDisplayName().contains("Artifact C")) {
                    isThere = true;


                }

            }


        }

        if (isThere) {
            glowEntitiesInChunks(player, true);
        }

        else {
            glowEntitiesInChunks(player, false);

        }

        if (!hasNightVision) {
            player.removePotionEffect(PotionEffectType.NIGHT_VISION);
        }

        if (!hasBallistic) {
            health.setBaseValue(20);
            player.setHealth(health.getValue());
        }


    }

    public void glowEntitiesInChunks(Player player, boolean isRunning) {



        Chunk playerChunk = player.getLocation().getChunk();
        ArrayList<Chunk> chunks = new ArrayList<>();
        chunks.add(playerChunk);

        for(int x=-17;x<=17;x++) {
            for(int z=-17;z<=17;z++) {
                 chunks.add(new Location(player.getWorld(), (playerChunk.getX() + x), 64, (playerChunk.getZ()) + z).getChunk());
            }
        }

        for (Chunk chunk: chunks) {
           Entity[] entities = chunk.getEntities();
           for (Entity entity: entities) {
                   if (entity instanceof Monster && isRunning) {
                       entity.setGlowing(true);
                    }
                   if(!isRunning) {
                       for (Entity superentity : player.getWorld().getEntities()) {
                           superentity.setGlowing(false);
                       }
                   }

           }
        }


    }

}

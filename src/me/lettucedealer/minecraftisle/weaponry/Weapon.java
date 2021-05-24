package me.lettucedealer.minecraftisle.weaponry;

import net.minecraft.server.v1_16_R1.PacketPlayOutWorldParticles;
import net.minecraft.server.v1_16_R1.Particles;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import static org.bukkit.Bukkit.getLogger;

public class Weapon {
    public int ammo;
    public int mag_size;
    public int range;
    public ItemStack item;

    public Weapon(int ammo, int mag_size, int range, ItemStack item) {
        this.ammo = ammo;
        this.mag_size = mag_size;
        this.range = range;
        this.item = item;



    }


    public void updateAmmo() {

        String currentAmmo = item.getItemMeta().getLore().get(0);
        String[] ammoString = currentAmmo.split(" ");
        int newAmmo = Integer.parseInt(ammoString[0]) - 1;

        item.getItemMeta().getLore().set(0, newAmmo + " / " + mag_size);
    }


    @EventHandler
    public void shoot(PlayerInteractEvent event, Player player) {
        getLogger().info("true");
        if (event.getItem().getItemMeta().getDisplayName() == item.getItemMeta().getDisplayName()) {

            Location location = player.getLocation();
            float x = (float) location.getX();
            float y = (float) location.getY();
            float z = (float) location.getZ();

            float[] bulletRotation = getRotationalAxis(location);

            for (int i =0; i == range; i++) {
                PacketPlayOutWorldParticles shotLine = new PacketPlayOutWorldParticles(Particles.END_ROD, true, x, y, z, bulletRotation[0], bulletRotation[1], 0, 0, 1);
                for (Player p: Bukkit.getOnlinePlayers()) {
                    ((CraftPlayer)p).getHandle().playerConnection.sendPacket(shotLine);
                }
                x += 0.1f;
            }

            updateAmmo();
        }

    }

    public float[] getRotationalAxis(Location location) {
        double yaw = (location.getYaw() - 90) % 360;
        double pitch = (location.getPitch() - 90) % 360;

        if (yaw < 0) {
            yaw += 360;
        }

        if (pitch < 0) {
            pitch += 360;
        }

        float[] rotation = new float[2];
        rotation[0] = (float) yaw;
        rotation[1] = (float) pitch;

        return rotation;
    }

}

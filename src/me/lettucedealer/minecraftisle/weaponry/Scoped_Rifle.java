package me.lettucedealer.minecraftisle.weaponry;

import me.lettucedealer.minecraftisle.items.Weapons;
import org.bukkit.inventory.ItemStack;

public class Scoped_Rifle extends Weapon{

    static Weapons weapons = new Weapons();

    static ItemStack gun = weapons.scoped_rifle("1");

    public Scoped_Rifle() {

        super(1, 1, 100, gun);
    }
}

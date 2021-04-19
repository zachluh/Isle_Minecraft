package me.lettucedealer.minecraftisle.recipes;

import me.lettucedealer.minecraftisle.Main;
import me.lettucedealer.minecraftisle.items.*;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.apache.logging.log4j.LogManager.getLogger;


public class Recipes implements Listener {

    public Recipes(Main plugin) {

    }

    private Artifacts artifacts = new Artifacts();
    private Headwear headwear = new Headwear();
    private Workstations workstations = new Workstations();
    private Materials materials = new Materials();
    private Armor armor = new Armor();

    String[] r = {"Kevlar", "Ballistic Vest"};
    String[] m = {"Plastic", "Kevlar"};
    List<String> results = new ArrayList<String>(Arrays.asList(r));
    List<String> mats = new ArrayList<String>(Arrays.asList(m));


    public ShapedRecipe artifact_a_recipe(Main plugin) {
        ItemStack item = artifacts.artifactA();

        NamespacedKey key = new NamespacedKey(plugin, "artifact_a");
        ShapedRecipe recipe = new ShapedRecipe(key, item);

        recipe.shape(" A ", "ABA", " A ");

        recipe.setIngredient('A', Material.GOLD_BLOCK);
        recipe.setIngredient('B', Material.NETHER_STAR);

        return recipe;
    }

    public ShapedRecipe artifact_b_recipe(Main plugin) {
        ItemStack item = artifacts.artifactB();

        NamespacedKey key = new NamespacedKey(plugin, "artifact_b");
        ShapedRecipe recipe = new ShapedRecipe(key, item);

        recipe.shape(" A ", "ABA", " A ");

        recipe.setIngredient('A', Material.REDSTONE_BLOCK);
        recipe.setIngredient('B', Material.NETHER_STAR);

        return recipe;
    }

    public ShapedRecipe artifact_c_recipe(Main plugin) {
        ItemStack item = artifacts.artifactC();

        NamespacedKey key = new NamespacedKey(plugin, "artifact_c");
        ShapedRecipe recipe = new ShapedRecipe(key, item);

        recipe.shape(" A ", "ABA", " A ");

        recipe.setIngredient('A', Material.LAPIS_BLOCK);
        recipe.setIngredient('B', Material.NETHER_STAR);

        return recipe;
    }

    public ShapedRecipe artifact_d_recipe(Main plugin) {
        ItemStack item = artifacts.artifactD();

        NamespacedKey key = new NamespacedKey(plugin, "artifact_d");
        ShapedRecipe recipe = new ShapedRecipe(key, item);

        recipe.shape(" A ", "ABA", " A ");

        recipe.setIngredient('A', Material.EMERALD_BLOCK);
        recipe.setIngredient('B', Material.NETHER_STAR);

        return recipe;
    }

    public ShapedRecipe night_vision_recipe(Main plugin) {
        ItemStack item = headwear.Night_Vision();

        NamespacedKey key = new NamespacedKey(plugin, "night_vision_goggles");
        ShapedRecipe recipe = new ShapedRecipe(key, item);

        recipe.shape("AAA", "ABA", "CCC");

        recipe.setIngredient('A', Material.COAL_BLOCK);
        recipe.setIngredient('B', Material.ENDER_EYE);
        recipe.setIngredient('C', Material.GREEN_STAINED_GLASS_PANE);

        return recipe;
    }

    public ShapedRecipe compressor_recipe(Main plugin) {
        ItemStack item = workstations.Material_Compressor();

        NamespacedKey key = new NamespacedKey(plugin, "material_compressor");
        ShapedRecipe recipe = new ShapedRecipe(key, item);

        recipe.shape("AAA", " B ", "AAA");

        recipe.setIngredient('A', Material.PISTON);
        recipe.setIngredient('B', Material.BLAST_FURNACE);

        return recipe;
    }

    public ShapedRecipe kevlar_recipe(Main plugin) {
        ItemStack item = materials.Kevlar();

        NamespacedKey key = new NamespacedKey(plugin, "kevlar");
        ShapedRecipe recipe = new ShapedRecipe(key, item);

        recipe.shape("AAA", "AAA", "AAA");

        recipe.setIngredient('A', Material.WHITE_DYE);


        return recipe;
    }

    public ShapedRecipe ballistic_recipe(Main plugin) {
        ItemStack item = armor.Ballistic_Vest();

        NamespacedKey key = new NamespacedKey(plugin, "ballistic_vest");
        ShapedRecipe recipe = new ShapedRecipe(key, item);

        recipe.shape("A A", "AAA", "AAA");

        recipe.setIngredient('A', Material.DRIED_KELP);


        return recipe;
    }

    @EventHandler
    public void onCraft(PrepareItemCraftEvent event) {

        if (event.getRecipe() != null){

            ItemStack result = event.getRecipe().getResult();


            if (result.hasItemMeta() && results.contains(result.getItemMeta().getDisplayName())) {


                boolean foundspecial = false;
                for (ItemStack item: event.getInventory().getMatrix()) {

                    if (item != null && item.hasItemMeta()) {
                        if (mats.contains(item.getItemMeta().getDisplayName())) {
                            foundspecial = true;
                            break;
                        }
                    }
                }
                if (!foundspecial) {
                    getLogger().info("4");
                    event.getInventory().setResult(null);
                }

                ItemStack invresult = event.getInventory().getResult();
                checkMultiples(event, invresult);
            }


        }
    }

    public void checkMultiples(PrepareItemCraftEvent event, ItemStack result) {
        int amount = 64;
        for (ItemStack item : event.getInventory().getMatrix()) {
            if (item != null) {
                if(item.getAmount() < amount)
                    amount = item.getAmount();
            }

        }


        result.setAmount(amount);
        event.getInventory().setResult(result);

        for (ItemStack item: event.getInventory().getMatrix()) {
            item.setAmount(item.getAmount()-amount);
        }
    }

}

package me.lettucedealer.minecraftisle;

import me.lettucedealer.minecraftisle.events.ArtifactEvents;
import me.lettucedealer.minecraftisle.events.WorkStationEvents;
import me.lettucedealer.minecraftisle.items.Artifacts;
import me.lettucedealer.minecraftisle.recipes.Recipes;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.Random;

public class Main extends JavaPlugin {

    Recipes recipes = new Recipes(this);
    @Override
    public void onEnable() {
        getLogger().info("very base");
        Bukkit.getServer().getPluginManager().registerEvents(new ArtifactEvents(this), this);
        Bukkit.getServer().getPluginManager().registerEvents(new WorkStationEvents(this), this);
        Bukkit.getServer().getPluginManager().registerEvents(new Recipes(this), this);
        Bukkit.addRecipe(recipes.artifact_a_recipe(this));
        Bukkit.addRecipe(recipes.artifact_b_recipe(this));
        Bukkit.addRecipe(recipes.artifact_c_recipe(this));
        Bukkit.addRecipe(recipes.artifact_d_recipe(this));
        Bukkit.addRecipe(recipes.night_vision_recipe(this));
        Bukkit.addRecipe(recipes.compressor_recipe(this));
        Bukkit.addRecipe(recipes.kevlar_recipe(this));
        Bukkit.addRecipe(recipes.ballistic_recipe(this));
    }

    @Override
    public void onDisable() {
        getLogger().info("very uncool");
    }

    Artifacts artifacts = new Artifacts();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (label.equalsIgnoreCase("tprandom")) {
            if (!(sender instanceof Player)) {
                return true;
            }
            Player player = (Player) sender;
            Location loc = player.getLocation();
            Random rand = new Random();
            Integer x = rand.nextInt(100);
            Integer y = rand.nextInt(100);
            Integer z = rand.nextInt(100);
            Location newloc = loc.add(x, y, z);

            player.teleport(newloc);
        }

        if (label.equalsIgnoreCase("tpto")) {
            Player player = (Player) sender;
            if (args.length == 0) {
                player.sendMessage(ChatColor.RED + "Who do you want to tp to");
            }

            else {
                Player target = Bukkit.getPlayerExact(args[0]);

                if (target == null) {
                    player.sendMessage(ChatColor.RED + "This player either doesnt exist or isnt online right now");
                }

                else {
                    player.teleport(target.getLocation());
                    player.sendMessage(ChatColor.GREEN + "You have been teleported to" + target.getName());
                }
            }

        }


        if (label.equalsIgnoreCase("tptome")) {
            Player player = (Player) sender;
            if (args.length == 0) {
                player.sendMessage(ChatColor.RED + "Who do u wanna tp to u");
            } else {
                Player target = Bukkit.getPlayerExact(args[0]);

                if (target == null) {
                    player.sendMessage(ChatColor.RED + "This player either doesnt exist or isnt online right now");
                } else {
                    target.teleport(player.getLocation());
                    player.sendMessage(ChatColor.GREEN + "You have teleported " + target.getName() + " to you");
                }
            }
        }





        return false;
    }






}

package ml.yotdev.stormbow.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class CommandStormBow implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player)sender;

            if (args.length == 0) {
                player.sendMessage("§4Please choose a player");
                player.sendMessage("§4/stormbow <player>");
            }
            else {
                // Find player
                String pName = args[0];
                Player target = Bukkit.getPlayer(pName);
                if (target != null) {
                    target.sendMessage("§dYou obtained the StormBow");
                }
                else {
                    player.sendMessage("§4Player not found");
                }

                // Creates/gives bow
                ItemStack stormbow = new ItemStack(Material.BOW, 1);
                ItemMeta sbmeta = stormbow.getItemMeta();
                sbmeta.setDisplayName("§5StormBow");
                sbmeta.setLore(Arrays.asList("§bA bow that", "§bshoots lightnings"));
                stormbow.setItemMeta(sbmeta);
                target.getInventory().addItem(stormbow);
            }
        }
        else{
            sender.sendMessage("§4Console cannot use this command");
        }
        return false;
    }
}

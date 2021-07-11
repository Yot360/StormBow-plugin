package ml.yotdev.stormbow;

import ml.yotdev.stormbow.commands.CommandStormBow;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        colorStr("[StormBow] &aPlugin successfully loaded!");
        getCommand("stormbow").setExecutor(new CommandStormBow());
        getServer().getPluginManager().registerEvents(new BowEvents(), this);
    }
    // Adds color
    public void colorStr(String string){
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', string));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        colorStr("[StormBow] &aPlugin successfully stopped!");
    }
}

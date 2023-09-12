package hrusinski.mrp.Listeners;

import hrusinski.mrp.MRP;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.File;

import static hrusinski.mrp.Config.PlayerConfig.createPlayerConfig;

public class PlayerJoinQuit implements Listener {

    File file = new File(MRP.instance.getDataFolder(), "config.yml");
    FileConfiguration config = YamlConfiguration.loadConfiguration(file);

    @EventHandler
    public void PlayerJoinChat(PlayerJoinEvent event){
        createPlayerConfig();
        if(config.getString("region").equals("CZ")) {
            File fileCZ = new File(MRP.instance.getDataFolder(), "region/CZ.yml");
            FileConfiguration configCZ = YamlConfiguration.loadConfiguration(fileCZ);
            Player player = event.getPlayer();

            event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', configCZ.getString("Messages.Events.PlayerJoin").replaceAll("%player%", player.getName())));
        }
        if(config.getString("region").equals("EN")) {
            File fileEN = new File(MRP.instance.getDataFolder(), "region/EN.yml");
            FileConfiguration configEN = YamlConfiguration.loadConfiguration(fileEN);
            Player player = event.getPlayer();

            event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', configEN.getString("Messages.Events.PlayerJoin").replaceAll("%player%", player.getName())));
        }
    }

    @EventHandler
    public void PlayerQuitChat(PlayerQuitEvent event){
        if(config.getString("region").equals("CZ")) {
            File fileCZ = new File(MRP.instance.getDataFolder(), "region/CZ.yml");
            FileConfiguration configCZ = YamlConfiguration.loadConfiguration(fileCZ);
            Player player = event.getPlayer();

            event.setQuitMessage(ChatColor.translateAlternateColorCodes('&', configCZ.getString("Messages.Events.PlayerQuit").replaceAll("%player%", player.getName())));
        }
        if(config.getString("region").equals("EN")) {
            File fileEN = new File(MRP.instance.getDataFolder(), "region/EN.yml");
            FileConfiguration configEN = YamlConfiguration.loadConfiguration(fileEN);
            Player player = event.getPlayer();

            event.setQuitMessage(ChatColor.translateAlternateColorCodes('&', configEN.getString("Messages.Events.PlayerQuit").replaceAll("%player%", player.getName())));
        }
    }
}

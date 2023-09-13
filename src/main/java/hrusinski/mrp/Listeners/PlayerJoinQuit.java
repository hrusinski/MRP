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
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static hrusinski.mrp.Config.PlayerConfig.createPlayerConfig;
import static hrusinski.mrp.Func.CitizenCard.createCC;
import static hrusinski.mrp.Func.CustomHp.setMaxHp;

public class PlayerJoinQuit implements Listener {

    File file = new File(MRP.instance.getDataFolder(), "config.yml");
    FileConfiguration config = YamlConfiguration.loadConfiguration(file);

    @EventHandler
    public void PlayerJoinChat(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String pname = player.getName();

        File fileCC = new File(MRP.instance.getDataFolder(), pname + ".yml");

        File fileP = new File(MRP.instance.getDataFolder(), pname+".yml");
        FileConfiguration configP = YamlConfiguration.loadConfiguration(fileP);

        if (!fileCC.exists()) {
            createCC(player);
        }
        if (!fileP.exists()){
            createPlayerConfig(player);
        }
        setMaxHp(player);

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(configP.getString("Status").equals("Died")) return;
        if(configP.getString("Status").equals("Dead")) return;

        if (config.getString("region").equals("CZ")) {
            File fileCZ = new File(MRP.instance.getDataFolder(), "region/CZ.yml");
            FileConfiguration configCZ = YamlConfiguration.loadConfiguration(fileCZ);

            event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', configCZ.getString("Messages.Events.PlayerJoin").replaceAll("%player%", player.getName())));
        }
        if (config.getString("region").equals("EN")) {
            File fileEN = new File(MRP.instance.getDataFolder(), "region/EN.yml");
            FileConfiguration configEN = YamlConfiguration.loadConfiguration(fileEN);

            event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', configEN.getString("Messages.Events.PlayerJoin").replaceAll("%player%", player.getName())));
        }
    }

    @EventHandler
    public void PlayerQuitChat(PlayerQuitEvent event){
        Player player = event.getPlayer();
        String pname = player.getName();

        File fileCC = new File(MRP.instance.getDataFolder(), pname + ".yml");
        FileConfiguration configCC = YamlConfiguration.loadConfiguration(fileCC);

        File fileP = new File(MRP.instance.getDataFolder(), pname+".yml");
        FileConfiguration configP = YamlConfiguration.loadConfiguration(file);

        if(config.getString("region").equals("CZ")) {
            File fileCZ = new File(MRP.instance.getDataFolder(), "region/CZ.yml");
            FileConfiguration configCZ = YamlConfiguration.loadConfiguration(fileCZ);

            event.setQuitMessage(ChatColor.translateAlternateColorCodes('&', configCZ.getString("Messages.Events.PlayerQuit").replaceAll("%player%", player.getName())));
        }
        if(config.getString("region").equals("EN")) {
            File fileEN = new File(MRP.instance.getDataFolder(), "region/EN.yml");
            FileConfiguration configEN = YamlConfiguration.loadConfiguration(fileEN);

            event.setQuitMessage(ChatColor.translateAlternateColorCodes('&', configEN.getString("Messages.Events.PlayerQuit").replaceAll("%player%", player.getName())));
        }

        try {
            configCC.save(fileCC);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        try {
            configP.save(fileP);
        } catch (IOException e){
            e.printStackTrace(System.out);
        }
    }
}

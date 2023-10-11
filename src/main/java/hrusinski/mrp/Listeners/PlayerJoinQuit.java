package hrusinski.mrp.Listeners;

import hrusinski.mrp.MRP;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
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

        File fileCC = new File(MRP.instance.getDataFolder(), "/CC/"+ pname+".yml");

        File fileP = new File(MRP.instance.getDataFolder(), "/players/" + pname+".yml");

        if (!fileCC.exists()) {
            createCC(player);
        }
        if (!fileP.exists()){
            createPlayerConfig(player);
        }
        setMaxHp(player);

        if (config.isSet("region")) {
            File fileLan = new File(MRP.instance.getDataFolder(), "region/" + config.getString("region") + ".yml");
            FileConfiguration configLan = YamlConfiguration.loadConfiguration(fileLan);

            event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', configLan.getString("Messages.Events.PlayerJoin").replaceAll("%player%", player.getName())));
        } else {
            File fileEN = new File(MRP.instance.getDataFolder(), "region/EN.yml");
            FileConfiguration configEN = YamlConfiguration.loadConfiguration(fileEN);

            event.setJoinMessage(configEN.getString("Messages.WrongLanguage"));
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @EventHandler
    public void PlayerQuitChat(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        String pname = player.getName();

        File fileCC = new File(MRP.instance.getDataFolder(), "/players/" + pname + ".yml");
        FileConfiguration configCC = YamlConfiguration.loadConfiguration(fileCC);

        File fileP = new File(MRP.instance.getDataFolder(), "/players/" + pname + ".yml");
        FileConfiguration configP = YamlConfiguration.loadConfiguration(file);

        if (config.isSet("region")) {
            File fileLan = new File(MRP.instance.getDataFolder(), "region/" + config.getString("region") + ".yml");
            FileConfiguration configLan = YamlConfiguration.loadConfiguration(fileLan);

            event.setQuitMessage(ChatColor.translateAlternateColorCodes('&', configLan.getString("Messages.Events.PlayerQuit").replaceAll("%player%", player.getName())));
        } else {
            File fileEN = new File(MRP.instance.getDataFolder(), "region/EN.yml");
            FileConfiguration configEN = YamlConfiguration.loadConfiguration(fileEN);

            event.setQuitMessage(configEN.getString("Messages.WrongLanguage"));
        }
    }
}

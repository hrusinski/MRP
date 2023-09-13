package hrusinski.mrp.Func;

import hrusinski.mrp.MRP;
import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.io.File;

public class OOC implements Listener {

    @EventHandler
    public void onChatToOOC(AsyncChatEvent event){
        File file = new File(MRP.instance.getDataFolder(), "config.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        Player player = event.getPlayer();
        String pname = player.getName();

        event.setCancelled(true);

        String message = event.originalMessage().toString();

        if(config.getString("region").equals("EN")){
            File fileEN = new File(MRP.instance.getDataFolder(), "region/EN.yml");
            FileConfiguration configEN = YamlConfiguration.loadConfiguration(fileEN);

            for (Player players : Bukkit.getOnlinePlayers()){
                players.sendMessage(ChatColor.translateAlternateColorCodes('&', configEN.getString("Messages.OOC").replaceAll("%nick%", pname).replaceAll("%message%", message)));
            }
        } else {
            File fileCZ = new File(MRP.instance.getDataFolder(), "region/CZ.yml");
            FileConfiguration configCZ = YamlConfiguration.loadConfiguration(fileCZ);

            for (Player players : Bukkit.getOnlinePlayers()){
                players.sendMessage(ChatColor.translateAlternateColorCodes('&', configCZ.getString("Messages.OOC").replaceAll("%nick%", pname).replaceAll("%message%", message)));
            }
        }


    }
}

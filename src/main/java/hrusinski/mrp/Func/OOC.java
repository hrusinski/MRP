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
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.io.File;

public class OOC implements Listener {

    @EventHandler
    public void onChatToOOC(AsyncPlayerChatEvent event){
        File file = new File(MRP.instance.getDataFolder(), "config.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        Player player = event.getPlayer();
        String pname = player.getName();


        String message = event.getMessage();

        if (config.isSet("region")) {
            File fileLan = new File(MRP.instance.getDataFolder(), "region/" + config.getString("region") + ".yml");
            FileConfiguration configLan = YamlConfiguration.loadConfiguration(fileLan);

            event.setFormat(ChatColor.translateAlternateColorCodes('&', configLan.getString("Messages.OOC").replaceAll("%nick%", pname).replaceAll("%message%", message)));
        } else {
            File fileEN = new File(MRP.instance.getDataFolder(), "region/EN.yml");
            FileConfiguration configEN = YamlConfiguration.loadConfiguration(fileEN);

            player.getServer().getConsoleSender().sendMessage(configEN.getString("Messages.WrongLanguage"));
        }
    }
}

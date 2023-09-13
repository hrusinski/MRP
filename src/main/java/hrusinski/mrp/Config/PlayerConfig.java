package hrusinski.mrp.Config;

import hrusinski.mrp.MRP;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.io.File;
import java.io.IOException;

public class PlayerConfig implements Listener {

    public static void createPlayerConfig(Player player){
        File file = new File(MRP.instance.getDataFolder(), "config.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        String pname = player.getName();

        File fileP = new File(MRP.instance.getDataFolder(), pname+".yml");
        FileConfiguration configP = YamlConfiguration.loadConfiguration(fileP);

        configP.set("IP", player.getAddress().toString());
        configP.set("Status", "Dead");

        try {
            configP.save(fileP);
        } catch (IOException e){
            e.printStackTrace(System.out);
        }
    }
}

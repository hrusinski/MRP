package hrusinski.mrp.Func;

import hrusinski.mrp.MRP;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class CustomHp {

    public static void setMaxHp(Player player){
        File file = new File(MRP.instance.getDataFolder(), "config.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        player.setMaxHealth(config.getDouble("Func.CustomHp"));
    }
}

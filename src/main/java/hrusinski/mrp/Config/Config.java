package hrusinski.mrp.Config;

import hrusinski.mrp.MRP;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {

    public static void configCreate(){
        File file = new File(MRP.instance.getDataFolder(), "config.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        if(!config.isLocation("region")){
            config.set("region", "EN");
            config.set("Func.OneLive", "true");
            config.set("Func.CustomHp", 10);
            config.set("Func.Me&DoBlockDistance", 15);
            config.set("Func.LOOCDistance", 15);
            try{
                config.save(file);
            } catch (IOException e){
                e.printStackTrace(System.out);
            }
        }

    }
}

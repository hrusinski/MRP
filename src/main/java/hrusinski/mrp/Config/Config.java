package hrusinski.mrp.Config;

import hrusinski.mrp.MRP;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {

    public static void configCreate() {
        File file = new File(MRP.instance.getDataFolder(), "config.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        if (!config.isLocation("region")) {
            config.set("region", "EN");
        }
        if (!config.isSet("Func.OneLive")) {
            config.set("Func.OneLive", true);
        }
        if (!config.isSet("Func.CustomHp")) {
            config.set("Func.CustomHp", 10);
        }
        if (!config.isSet("Func.Me&DoBlockDistance")) {
            config.set("Func.Me&DoBlockDistance", 15);
        }
        if (!config.isSet("Func.LOOCDistance")) {
            config.set("Func.LOOCDistance", 15);
        }
        if (!config.isSet("Func.Login")) {
            config.set("Func.Login", true);
        }

        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
}

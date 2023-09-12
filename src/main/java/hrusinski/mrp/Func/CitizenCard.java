package hrusinski.mrp.Func;

import hrusinski.mrp.MRP;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class CitizenCard {

    public static void createCC(Player player){
        File file = new File(MRP.instance.getDataFolder(), "config.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        String pname = player.getName();

        File fileCC = new File(MRP.instance.getDataFolder(), "/CC/"+pname+".yml");
        FileConfiguration configCC = YamlConfiguration.loadConfiguration(fileCC);

        if(config.getString("region").equals("EN")) {
            File fileEN = new File(MRP.instance.getDataFolder(), "region/EN.yml");
            FileConfiguration configEN = YamlConfiguration.loadConfiguration(fileEN);

            configCC.set("Info."+configEN.getString("CC.Name"), "Steve");
            configCC.set("Info."+configEN.getString("CC.Surname"), "Mine");
            configCC.set("Info."+configEN.getString("CC.Age"), "21");
            configCC.set("Info."+configEN.getString("CC.Gender"), "Male");
            configCC.set("Info."+configEN.getString("CC.Nationality"), "MineNation");
        } else {
            File fileCZ = new File(MRP.instance.getDataFolder(), "region/CZ.yml");
            FileConfiguration configCZ = YamlConfiguration.loadConfiguration(fileCZ);

            configCC.set("Info."+configCZ.getString("CC.Name"), "Steve");
            configCC.set("Info."+configCZ.getString("CC.Surname"), "Mine");
            configCC.set("Info."+configCZ.getString("CC.Age"), "21");
            configCC.set("Info."+configCZ.getString("CC.Gender"), "Muž");
            configCC.set("Info."+configCZ.getString("CC.Nationality"), "MineNárod");
        }

        try {
            configCC.save(fileCC);
        } catch (IOException e){
            e.printStackTrace(System.out);
        }
    }
}

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

         if (config.isSet("region")) {
             File fileLan = new File(MRP.instance.getDataFolder(), "region/" + config.getString("region") + "yml");
             FileConfiguration configLan = YamlConfiguration.loadConfiguration(fileLan);

             configCC.set("Info."+configLan.getString("CC.Name"), "Steve");
             configCC.set("Info."+configLan.getString("CC.Surname"), "Mine");
             configCC.set("Info."+configLan.getString("CC.Age"), "21");
             configCC.set("Info."+configLan .getString("CC.Gender"), "Male");
             configCC.set("Info."+configLan.getString("CC.Nationality"), "MineNation");
         } else {
             File fileEN = new File(MRP.instance.getDataFolder(), "region/EN.yml");
             FileConfiguration configEN = YamlConfiguration.loadConfiguration(fileEN);

             configCC.set("Info."+configEN.getString("CC.Name"), "Steve");
             configCC.set("Info."+configEN.getString("CC.Surname"), "Mine");
             configCC.set("Info."+configEN .getString("CC.Age"), "21");
             configCC.set("Info."+configEN.getString("CC.Gender"), "Male");
             configCC.set("Info."+configEN.getString("CC.Nationality"), "MineNation");
         }

        try {
            configCC.save(fileCC);
        } catch (IOException e){
            e.printStackTrace(System.out);
        }
    }
}

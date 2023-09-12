package hrusinski.mrp.Config;

import hrusinski.mrp.MRP;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Language {

    public static void langCZ(){
        File fileCZ = new File(MRP.instance.getDataFolder(), "region/CZ.yml");
        FileConfiguration configCZ = YamlConfiguration.loadConfiguration(fileCZ);

        configCZ.set("Logger.EnablingPlugin", " plugin se zapíná");
        configCZ.set("Logger.EnablePlugin", " plugin se zapnul");
        configCZ.set("Logger.DisablingPlugin", " plugin se vypíná");
        configCZ.set("Logger.DisablePlugin", " plugin se vypnul");
        configCZ.set("Messages.Events.PlayerJoin", "&6&l%player% &r&6přišel do města!");
        configCZ.set("Messages.Events.PlayerQuit", "&6&l%player% &r&6odešel z města.");

        try{
            configCZ.save(fileCZ);
        } catch (IOException e){
            e.printStackTrace(System.out);
        }
    }

    public static void langEN(){
        File fileEN = new File(MRP.instance.getDataFolder(), "region/EN.yml");
        FileConfiguration configEN = YamlConfiguration.loadConfiguration(fileEN);

        configEN.set("Logger.EnablingPlugin", " plugin is enabling");
        configEN.set("Logger.EnablePlugin", " plugin was enabled");
        configEN.set("Logger.DisablingPlugin", " plugin is disabling");
        configEN.set("Logger.DisablePlugin", " plugin was disabled");
        configEN.set("Messages.Events.PlayerJoin", "&6&l%player% &r&6came to city!");
        configEN.set("Messages.Events.PlayerQuit", "&6&l%player% &r&6left city.");

        try{
            configEN.save(fileEN);
        } catch (IOException e){
            e.printStackTrace(System.out);
        }
    }
}

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
        configCZ.set("Messages.Events.Death", "&c&l%player% &r&cumřel.");
        configCZ.set("Messages.Command.NotPlayer", "&4Tento příkaz smí použít pouze hráč.");
        configCZ.set("Messages.Command.CC.Name", "&4Tento příkaz smí použít pouze hráč.");
        configCZ.set("Messages.Command.CC.PlayerNotFound", "&4Špatně zadaný nick hráče.");
        configCZ.set("CC.Name", "&fJméno");
        configCZ.set("CC.Surname", "&fPřijmení");
        configCZ.set("CC.Age", "&fVěk");
        configCZ.set("CC.Gender", "&fPohlaví");
        configCZ.set("CC.Nationality", "&fNárodnost");

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
        configEN.set("Messages.Events.Death", "&c&l%player% &r&died.");
        configEN.set("Messages.Command.NotPlayer", "&4This command can execute player only.");
        configEN.set("Messages.Command.CC.Name", "&eYou changed your name.");
        configEN.set("Messages.Command.CC.PlayerNotFound", "&eWrong player nickname.");
        configEN.set("CC.Name", "&fName");
        configEN.set("CC.Surname", "&fSurname");
        configEN.set("CC.Age", "&fAge");
        configEN.set("CC.Gender", "&fGender");
        configEN.set("CC.Nationality", "&fNationality");

        try{
            configEN.save(fileEN);
        } catch (IOException e){
            e.printStackTrace(System.out);
        }
    }
}

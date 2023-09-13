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
        configCZ.set("Messages.Command.CC.Name", "&2Změnil sis jméno.");
        configCZ.set("Messages.Command.CC.Surname", "&2Změnil sis přijmení.");
        configCZ.set("Messages.Command.CC.Age", "&2Změnil sis věk.");
        configCZ.set("Messages.Command.CC.Gender", "&2Změnil sis pohlaví.");
        configCZ.set("Messages.Command.CC.Nationality", "&2Změnil sis národnost.");
        configCZ.set("Messages.Command.CC.PlayerNotFound", "&4Špatně zadaný nick hráče.");
        configCZ.set("Messages.Command.Error", "&4Špatně zadaný příkaz.");
        configCZ.set("Messages.Command.Me", "&b&l[ME] &r&4%name% %action%");
        configCZ.set("Messages.Command.Do", "&b&l[DO] &r&4%name% %action%");
        configCZ.set("Messages.Command.LOOC", "&b&l[LOOC] &r&4%nick% %text%");
        configCZ.set("Messages.Command.Announce", "&c&l[OZNÁMENÍ] &f&l%text%");
        configCZ.set("Messages.OOC", "&b&l[OOC] &r&4%nick% %message%");
        configCZ.set("Messages.CC.Name", "&4Jméno: ");
        configCZ.set("Messages.CC.Surname", "&4Přijmení: ");
        configCZ.set("Messages.CC.Age", "&4Věk: ");
        configCZ.set("Messages.CC.Gender", "&4Pohlaví: ");
        configCZ.set("Messages.CC.Nationality", "&4Národnost: ");
        configCZ.set("CC.Name", "Jméno");
        configCZ.set("CC.Surname", "Přijmení");
        configCZ.set("CC.Age", "Věk");
        configCZ.set("CC.Gender", "Pohlaví");
        configCZ.set("CC.Nationality", "Národnost");

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
        configEN.set("Messages.Command.CC.Name", "&2You changed your name.");
        configEN.set("Messages.Command.CC.Surname", "&2You changed your surname.");
        configEN.set("Messages.Command.CC.Age", "&2You changed your age.");
        configEN.set("Messages.Command.CC.Gender", "&2You changed your gender.");
        configEN.set("Messages.Command.CC.Nationality", "&2You changed your nationality.");
        configEN.set("Messages.Command.CC.PlayerNotFound", "&4Wrong player nickname.");
        configEN.set("Messages.Command.Error", "&4Wrong command.");
        configEN.set("Messages.Command.Me", "&b&l[ME] &r&f%name% %action%");
        configEN.set("Messages.Command.Do", "&b&l[DO] &r&f%name% %action%");
        configEN.set("Messages.Command.LOOC", "&b&l[LOOC] &r&f%nick% %text%");
        configEN.set("Messages.Command.Announce", "&c&l[ANNOUNCEMENT] &f&l%text%");
        configEN.set("Messages.OOC", "&b&l[OOC] &r&f%nick% %message%");
        configEN.set("Messages.CC.Name", "&fJméno: ");
        configEN.set("Messages.CC.Surname", "&fPřijmení: ");
        configEN.set("Messages.CC.Age", "&fVěk: ");
        configEN.set("Messages.CC.Gender", "&fPohlaví: ");
        configEN.set("Messages.CC.Nationality", "&fNárodnost: ");
        configEN.set("CC.Name", "Name");
        configEN.set("CC.Surname", "Surname");
        configEN.set("CC.Age", "Age");
        configEN.set("CC.Gender", "Gender");
        configEN.set("CC.Nationality", "Nationality");

        try{
            configEN.save(fileEN);
        } catch (IOException e){
            e.printStackTrace(System.out);
        }
    }
}

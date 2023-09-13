package hrusinski.mrp;

import hrusinski.mrp.Commands.*;
import hrusinski.mrp.Func.DeathToSpec;
import hrusinski.mrp.Func.OOC;
import hrusinski.mrp.Listeners.PlayerJoinQuit;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static hrusinski.mrp.Config.Config.configCreate;
import static hrusinski.mrp.Config.Language.langCZ;
import static hrusinski.mrp.Config.Language.langEN;

public final class MRP extends JavaPlugin {

    public static MRP instance;

    @Override
    public void onEnable() {
        instance = this;
        File file = new File(MRP.instance.getDataFolder(), "config.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        configCreate();
        langCZ();
        langEN();


        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        File fileCZ = new File(MRP.instance.getDataFolder(), "region/CZ.yml");
        FileConfiguration configCZ = YamlConfiguration.loadConfiguration(fileCZ);

        File fileEN = new File(MRP.instance.getDataFolder(), "region/EN.yml");
        FileConfiguration configEN = YamlConfiguration.loadConfiguration(fileEN);

        if (config.get("region") == "CZ") {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "MRP" + ChatColor.RESET.YELLOW + configCZ.getString("Logger.EnablingPlugin"));
        } else {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "MRP" + ChatColor.RESET.YELLOW + configEN.getString("Logger.EnablingPlugin"));
        }


        if (config.get("region") == "CZ") {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "MRP" + ChatColor.RESET.YELLOW + configCZ.getString("Logger.EnablingPlugin") + ".");
        } else {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "MRP" + ChatColor.RESET.YELLOW + configEN.getString("Logger.EnablingPlugin") + ".");
        }


        if (config.get("region") == "CZ") {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "MRP" + ChatColor.RESET.YELLOW + configCZ.getString("Logger.EnablingPlugin") + "..");
        } else {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "MRP" + ChatColor.RESET.YELLOW + configEN.getString("Logger.EnablingPlugin") + "..");
        }

        getServer().getPluginManager().registerEvents(new PlayerJoinQuit(), this);
        getServer().getPluginManager().registerEvents(new DeathToSpec(), this);

        getServer().getPluginManager().registerEvents(new OOC(), this);


        if (config.get("region") == "CZ") {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "MRP" + ChatColor.RESET.YELLOW + configCZ.getString("Logger.EnablingPlugin") + "...");
        } else {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "MRP" + ChatColor.RESET.YELLOW + configEN.getString("Logger.EnablingPlugin") + "...");
        }

        getCommand("cardName").setExecutor(new CCName());
        getCommand("cardSurname").setExecutor(new CCSurname());
        getCommand("cardAge").setExecutor(new CCAge());
        getCommand("cardGender").setExecutor(new CCGender());
        getCommand("cardNationality").setExecutor(new CCNationality());
        getCommand("Card").setExecutor(new CC());

        getCommand("looc").setExecutor(new LOOCcmd());
        getCommand("me").setExecutor(new MEcmd());
        getCommand("do").setExecutor(new DOcmd());


        if (config.get("region") == "CZ") {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "MRP" + ChatColor.RESET.YELLOW + configCZ.getString("Logger.EnablePlugin"));
        } else {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "MRP" + ChatColor.RESET.YELLOW + configEN.getString("Logger.EnablePlugin"));
        }
    }

    @Override
    public void onDisable() {
        File file = new File(MRP.instance.getDataFolder(), "config.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        File fileCZ = new File(MRP.instance.getDataFolder(), "region/CZ.yml");
        FileConfiguration configCZ = YamlConfiguration.loadConfiguration(fileCZ);

        File fileEN = new File(MRP.instance.getDataFolder(), "region/EN.yml");
        FileConfiguration configEN = YamlConfiguration.loadConfiguration(fileEN);

        if (config.get("region") == "CZ") {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GOLD+""+ ChatColor.BOLD+"MRP" + ChatColor.RESET.YELLOW + configCZ.getString("Logger.DisablingPlugin"));
        } else {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GOLD+""+ ChatColor.BOLD+"MRP" + ChatColor.RESET.YELLOW + configEN.getString("Logger.DisablingPlugin"));
        }




        if (config.get("region") == "CZ") {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GOLD+""+ ChatColor.BOLD+"MRP" + ChatColor.RESET.YELLOW + configCZ.getString("Logger.DisablingPlugin") + ".");
        } else {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GOLD+""+ ChatColor.BOLD+"MRP" + ChatColor.RESET.YELLOW + configEN.getString("Logger.DisablingPlugin") + ".");
        }




        if (config.get("region") == "CZ") {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GOLD+""+ ChatColor.BOLD+"MRP" + ChatColor.RESET.YELLOW + configCZ.getString("Logger.DisablingPlugin") + "..");
        } else {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GOLD+""+ ChatColor.BOLD+"MRP" + ChatColor.RESET.YELLOW + configEN.getString("Logger.DisablingPlugin") + "..");
        }




        if (config.get("region") == "CZ") {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GOLD+""+ ChatColor.BOLD+"MRP" + ChatColor.RESET.YELLOW + configCZ.getString("Logger.DisablingPlugin") + "...");
        } else {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GOLD+""+ ChatColor.BOLD+"MRP" + ChatColor.RESET.YELLOW + configEN.getString("Logger.DisablingPlugin") + "...");
        }




        if (config.get("region") == "CZ") {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GOLD+""+ ChatColor.BOLD+"MRP" + ChatColor.RESET.YELLOW + configCZ.getString("Logger.DisablePlugin"));
        } else {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GOLD+""+ ChatColor.BOLD+"MRP" + ChatColor.RESET.YELLOW + configEN.getString("Logger.DisablePlugin"));
        }
    }
}

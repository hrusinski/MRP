package hrusinski.mrp.Commands;

import hrusinski.mrp.MRP;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class CC implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String string, @NotNull String[] args) {

        File file = new File(MRP.instance.getDataFolder(), "config.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        if(sender instanceof Player){

            Player player = ((Player) sender).getPlayer();
            String pname = player.getName();

            File fileCC = new File(MRP.instance.getDataFolder(), "/CC/"+pname+".yml");
            FileConfiguration configCC = YamlConfiguration.loadConfiguration(fileCC);

            if(args.length == 1 && player.getServer().getPlayer(args[0]) instanceof Player){

                Player target = player.getServer().getPlayer(args[0]);

                if(config.getString("region").equals("EN")){
                    File fileEN = new File(MRP.instance.getDataFolder(), "region/EN.yml");
                    FileConfiguration configEN = YamlConfiguration.loadConfiguration(fileEN);

                    target.sendMessage(ChatColor.translateAlternateColorCodes('&', configEN.getString("CC.Name") + configCC.getString("Info.Name")));
                    target.sendMessage(ChatColor.translateAlternateColorCodes('&', configEN.getString("CC.Surname") + configCC.getString("Info.Surname")));
                    target.sendMessage(ChatColor.translateAlternateColorCodes('&', configEN.getString("CC.Age") + configCC.getString("Info.Age")));
                    target.sendMessage(ChatColor.translateAlternateColorCodes('&', configEN.getString("CC.Gender") + configCC.getString("Info.Gender")));
                    target.sendMessage(ChatColor.translateAlternateColorCodes('&', configEN.getString("CC.Nationality") + configCC.getString("Info.Nationality")));

                } else {
                    File fileCZ = new File(MRP.instance.getDataFolder(), "region/CZ.yml");
                    FileConfiguration configCZ = YamlConfiguration.loadConfiguration(fileCZ);

                    target.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
                    target.sendMessage(ChatColor.translateAlternateColorCodes('&', configCZ.getString("CC.Name") + configCC.getString("Info.Name")));
                    target.sendMessage(ChatColor.translateAlternateColorCodes('&', configCZ.getString("CC.Surname") + configCC.getString("Info.Surname")));
                    target.sendMessage(ChatColor.translateAlternateColorCodes('&', configCZ.getString("CC.Age") + configCC.getString("Info.Age")));
                    target.sendMessage(ChatColor.translateAlternateColorCodes('&', configCZ.getString("CC.Gender") + configCC.getString("Info.Gender")));
                    target.sendMessage(ChatColor.translateAlternateColorCodes('&', configCZ.getString("CC.Nationality") + configCC.getString("Info.Nationality")));
                    target.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
                }
            } else if (args.length == 0) {
                if(config.getString("region").equals("EN")){
                    File fileEN = new File(MRP.instance.getDataFolder(), "region/EN.yml");
                    FileConfiguration configEN = YamlConfiguration.loadConfiguration(fileEN);

                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', configEN.getString("CC.Name")  + configCC.getString("Info.Name")));
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', configEN.getString("CC.Surname")  + configCC.getString("Info.Surname")));
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', configEN.getString("CC.Age")  + configCC.getString("Info.Age")));
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', configEN.getString("CC.Gender")  + configCC.getString("Info.Gender")));
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', configEN.getString("CC.Nationality")  + configCC.getString("Info.Nationality")));

                } else {
                    File fileCZ = new File(MRP.instance.getDataFolder(), "region/CZ.yml");
                    FileConfiguration configCZ = YamlConfiguration.loadConfiguration(fileCZ);

                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', configCZ.getString("CC.Name") + configCC.getString("Info.Name")));
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', configCZ.getString("CC.Surname") + configCC.getString("Info.Surname")));
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', configCZ.getString("CC.Age") + configCC.getString("Info.Age")));
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', configCZ.getString("CC.Gender") + configCC.getString("Info.Gender")));
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', configCZ.getString("CC.Nationality") + configCC.getString("Info.Nationality")));
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
                }
            } else if (args.length == 1) {
                if(config.getString("region").equals("EN")){
                    File fileEN = new File(MRP.instance.getDataFolder(), "region/EN.yml");
                    FileConfiguration configEN = YamlConfiguration.loadConfiguration(fileEN);

                    sender.getServer().getConsoleSender().sendMessage(configEN.getString("Messages.Command.CC.PlayerNotFound"));
                } else {
                    File fileCZ = new File(MRP.instance.getDataFolder(), "region/CZ.yml");
                    FileConfiguration configCZ = YamlConfiguration.loadConfiguration(fileCZ);

                    sender.getServer().getConsoleSender().sendMessage(configCZ.getString("Messages.Command.CC.PlayerNotFound"));
                }
            } else {
                if(config.getString("region").equals("EN")){
                    File fileEN = new File(MRP.instance.getDataFolder(), "region/EN.yml");
                    FileConfiguration configEN = YamlConfiguration.loadConfiguration(fileEN);

                    sender.getServer().getConsoleSender().sendMessage(configEN.getString("Messages.Command.Error"));
                } else {
                    File fileCZ = new File(MRP.instance.getDataFolder(), "region/CZ.yml");
                    FileConfiguration configCZ = YamlConfiguration.loadConfiguration(fileCZ);

                    sender.getServer().getConsoleSender().sendMessage(configCZ.getString("Messages.Command.Error"));
                }
            }


        } else {
            if(config.getString("region").equals("EN")){
                File fileEN = new File(MRP.instance.getDataFolder(), "region/EN.yml");
                FileConfiguration configEN = YamlConfiguration.loadConfiguration(fileEN);

                sender.getServer().getConsoleSender().sendMessage(configEN.getString("Messages.Command.NotPlayer"));
            } else {
                File fileCZ = new File(MRP.instance.getDataFolder(), "region/CZ.yml");
                FileConfiguration configCZ = YamlConfiguration.loadConfiguration(fileCZ);

                sender.getServer().getConsoleSender().sendMessage(configCZ.getString("Messages.Command.NotPlayer"));
            }

        }
        return true;
    }
}

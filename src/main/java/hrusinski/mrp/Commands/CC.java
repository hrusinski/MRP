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

                if (config.isSet("region")) {
                    File fileLan = new File(MRP.instance.getDataFolder(), "region/" + config.getString("region") + "yml");
                    FileConfiguration configLan = YamlConfiguration.loadConfiguration(fileLan);

                    target.sendMessage(ChatColor.translateAlternateColorCodes('&', configLan.getString("Messages.CC.Name") + configCC.getString("Info.Name")));
                    target.sendMessage(ChatColor.translateAlternateColorCodes('&', configLan.getString("Messages.CC.Surname") + configCC.getString("Info.Surname")));
                    target.sendMessage(ChatColor.translateAlternateColorCodes('&', configLan.getString("Messages.CC.Age") + configCC.getString("Info.Age")));
                    target.sendMessage(ChatColor.translateAlternateColorCodes('&', configLan.getString("Messages.CC.Gender") + configCC.getString("Info.Gender")));
                    target.sendMessage(ChatColor.translateAlternateColorCodes('&', configLan.getString("Messages.CC.Nationality") + configCC.getString("Info.Nationality")));
                } else {
                    File fileEN = new File(MRP.instance.getDataFolder(), "region/EN.yml");
                    FileConfiguration configEN = YamlConfiguration.loadConfiguration(fileEN);

                    sender.getServer().getConsoleSender().sendMessage(configEN.getString("Messages.WrongLanguage"));
                }
            } else if (args.length == 0) {
                if (config.isSet("region")) {
                    File fileLan = new File(MRP.instance.getDataFolder(), "region/" + config.getString("region") + "yml");
                    FileConfiguration configLan = YamlConfiguration.loadConfiguration(fileLan);

                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', configLan.getString("Messages.CC.Name") + configCC.getString("Info.Name")));
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', configLan.getString("Messages.CC.Surname") + configCC.getString("Info.Surname")));
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', configLan.getString("Messages.CC.Age") + configCC.getString("Info.Age")));
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', configLan.getString("Messages.CC.Gender") + configCC.getString("Info.Gender")));
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', configLan.getString("Messages.CC.Nationality") + configCC.getString("Info.Nationality")));
                } else {
                    File fileEN = new File(MRP.instance.getDataFolder(), "region/EN.yml");
                    FileConfiguration configEN = YamlConfiguration.loadConfiguration(fileEN);

                    sender.getServer().getConsoleSender().sendMessage(configEN.getString("Messages.WrongLanguage"));
                }
            } else if (args.length == 1) {
                if (config.isSet("region")) {
                    File fileLan = new File(MRP.instance.getDataFolder(), "region/" + config.getString("region") + ".yml");
                    FileConfiguration configLan = YamlConfiguration.loadConfiguration(fileLan);

                    sender.getServer().getConsoleSender().sendMessage(configLan.getString("Messages.Command.CC.PlayerNotFound"));
                } else {
                    File fileEN = new File(MRP.instance.getDataFolder(), "region/EN.yml");
                    FileConfiguration configEN = YamlConfiguration.loadConfiguration(fileEN);

                    sender.getServer().getConsoleSender().sendMessage(configEN.getString("Messages.WrongLanguage"));
                }
            } else {
                if (config.isSet("region")) {
                    File fileLan = new File(MRP.instance.getDataFolder(), "region/" + config.getString("region") + ".yml");
                    FileConfiguration configLan = YamlConfiguration.loadConfiguration(fileLan);

                    sender.getServer().getConsoleSender().sendMessage(configLan.getString("Messages.Command.Error"));
                } else {
                    File fileEN = new File(MRP.instance.getDataFolder(), "region/EN.yml");
                    FileConfiguration configEN = YamlConfiguration.loadConfiguration(fileEN);

                    sender.getServer().getConsoleSender().sendMessage(configEN.getString("Messages.WrongLanguage"));
                }
            }


        } else {
            if (config.isSet("region")) {
                File fileLan = new File(MRP.instance.getDataFolder(), "region/" + config.getString("region") + ".yml");
                FileConfiguration configLan = YamlConfiguration.loadConfiguration(fileLan);

                sender.getServer().getConsoleSender().sendMessage(configLan.getString("Messages.Command.NotPlayer"));
            } else {
                File fileEN = new File(MRP.instance.getDataFolder(), "region/EN.yml");
                FileConfiguration configEN = YamlConfiguration.loadConfiguration(fileEN);

                sender.getServer().getConsoleSender().sendMessage(configEN.getString("Messages.WrongLanguage"));
            }

        }
        return true;
    }
}

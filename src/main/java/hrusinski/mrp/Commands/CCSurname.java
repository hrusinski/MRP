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
import java.io.IOException;

public class CCSurname implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String string, @NotNull String[] args) {

        File file = new File(MRP.instance.getDataFolder(), "config.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        if(sender instanceof Player){

            Player player = ((Player) sender).getPlayer();
            String pname = player.getName();

            File fileCC = new File(MRP.instance.getDataFolder(), "/CC/"+pname+".yml");
            FileConfiguration configCC = YamlConfiguration.loadConfiguration(fileCC);

            if(args.length == 1){
                if(config.getString("region").equals("EN")){
                    File fileEN = new File(MRP.instance.getDataFolder(), "region/EN.yml");
                    FileConfiguration configEN = YamlConfiguration.loadConfiguration(fileEN);

                    configCC.set("Info.Surname", args[0].toString());
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', configEN.getString("Messages.Command.CC.Surname")));
                } else {
                    File fileCZ = new File(MRP.instance.getDataFolder(), "region/CZ.yml");
                    FileConfiguration configCZ = YamlConfiguration.loadConfiguration(fileCZ);

                    configCC.set("Info.Surname", args[0].toString());
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', configCZ.getString("Messages.Command.CC.Surname")));
                }
                try {
                    configCC.save(fileCC);
                } catch (IOException e){
                    e.printStackTrace(System.out);
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

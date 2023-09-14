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

public class CCAge implements CommandExecutor {

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
                if (config.isSet("region")) {
                    File fileLan = new File(MRP.instance.getDataFolder(), "region/" + config.getString("region") + ".yml");
                    FileConfiguration configLan = YamlConfiguration.loadConfiguration(fileLan);

                    configCC.set("Info.Age", args[0].toString());
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', configLan.getString("Messages.Command.CC.Age")));
                } else {
                    File fileEN = new File(MRP.instance.getDataFolder(), "region/EN.yml");
                    FileConfiguration configEN = YamlConfiguration.loadConfiguration(fileEN);

                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', configEN.getString("Messages.WrongLanguage")));
                }
                try {
                    configCC.save(fileCC);
                } catch (IOException e){
                    e.printStackTrace(System.out);
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

package hrusinski.mrp.Commands;

import hrusinski.mrp.MRP;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class ME implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String string, @NotNull String[] args) {

        File file = new File(MRP.instance.getDataFolder(), "config.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        if(sender instanceof Player){

            String action;

            for (int i =)

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

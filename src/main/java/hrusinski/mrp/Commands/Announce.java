package hrusinski.mrp.Commands;

import hrusinski.mrp.MRP;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class Announce implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String string, @NotNull String[] args) {

        File file = new File(MRP.instance.getDataFolder(), "config.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        String text = "";

        for (int i = 0; i < args.length; i++) {
            text += args[i] + " ";
        }

        for (Player players : Bukkit.getOnlinePlayers()) {
            if(config.getString("region").equals("EN")){
                File fileEN = new File(MRP.instance.getDataFolder(), "region/EN.yml");
                FileConfiguration configEN = YamlConfiguration.loadConfiguration(fileEN);

                players.sendMessage(ChatColor.translateAlternateColorCodes('&', configEN.getString("Messages.Command.Announce").replaceAll("%text%", text)));

            } else {
                File fileCZ = new File(MRP.instance.getDataFolder(), "region/CZ.yml");
                FileConfiguration configCZ = YamlConfiguration.loadConfiguration(fileCZ);

                players.sendMessage(ChatColor.translateAlternateColorCodes('&', configCZ.getString("Messages.Command.Announce").replaceAll("%text%", text)));
            }
        }
        return true;
    }
}

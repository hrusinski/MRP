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

public class DOcmd implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String string, @NotNull String[] args) {

        File file = new File(MRP.instance.getDataFolder(), "config.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        if (sender instanceof Player) {

            Player player = ((Player) sender).getPlayer();

            String pname = player.getName();

            String action = "";

            for (int i = 0; i < args.length; i++) {
                action += args[i] + " ";
            }

            File fileCC = new File(MRP.instance.getDataFolder(), "/CC/" + pname + ".yml");
            FileConfiguration configCC = YamlConfiguration.loadConfiguration(fileCC);

            for (Player players : Bukkit.getOnlinePlayers()) {
                if (player.getLocation().distanceSquared(players.getLocation()) <= config.getDouble("Func.Me&DoBlockDistance")) {
                    if (config.isSet("region")) {
                        File fileLan = new File(MRP.instance.getDataFolder(), "region/" + config.getString("region") + ".yml");
                        FileConfiguration configLan = YamlConfiguration.loadConfiguration(fileLan);

                        players.sendMessage(ChatColor.translateAlternateColorCodes('&', configLan.getString("Messages.Command.Do").replaceAll("%name%", configCC.getString("Info.Name")+" " + configCC.getString("Info.Surname")).replaceAll("%action%", action)));
                    } else {
                        File fileEN = new File(MRP.instance.getDataFolder(), "region/EN.yml");
                        FileConfiguration configEN = YamlConfiguration.loadConfiguration(fileEN);

                        players.sendMessage(ChatColor.translateAlternateColorCodes('&', configEN.getString("Messages.WrongLanguage")));
                    }
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

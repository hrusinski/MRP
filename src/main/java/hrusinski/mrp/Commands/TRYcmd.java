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
import java.util.Arrays;
import java.util.Random;
import java.util.random.RandomGenerator;

public class TRYcmd implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String string, @NotNull String[] args) {

        File file = new File(MRP.instance.getDataFolder(), "config.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        if (sender instanceof Player) {

            Player player = ((Player) sender).getPlayer();

            String pname = player.getName();

            File fileCC = new File(MRP.instance.getDataFolder(), "/CC/" + pname + ".yml");
            FileConfiguration configCC = YamlConfiguration.loadConfiguration(fileCC);

            for (Player players : Bukkit.getOnlinePlayers()) {
                if (player.getLocation().distanceSquared(players.getLocation()) <= config.getDouble("Func.Me&DoBlockDistance")) {
                    if (config.isSet("region")) {
                        File fileLan = new File(MRP.instance.getDataFolder(), "region/" + config.getString("region") + ".yml");
                        FileConfiguration configLan = YamlConfiguration.loadConfiguration(fileLan);

                        String [] trylist = { Arrays.toString(configLan.getStringList("Try").toArray()) };

                        Random random = new Random();

                        int random_int = trylist.length;

                        String trymessage = trylist[random_int];

                        players.sendMessage(ChatColor.translateAlternateColorCodes('&', configLan.getString("Messages.Command.Try").replaceAll("%name%", configCC.getString("Info.Name") + configCC.getString("Info.Surname")).replaceAll("%try%", trymessage)));
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

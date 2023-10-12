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

public class LOGINcmd implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        File file = new File(MRP.instance.getDataFolder(), "config.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        File fileLan = new File(MRP.instance.getDataFolder(), "region/" + config.getString("region") + ".yml");
        FileConfiguration configLan = YamlConfiguration.loadConfiguration(fileLan);

        if (config.isSet("region")) {
            if (sender instanceof Player) {
                Player player = ((Player) sender).getPlayer();
                String pname = player.getName();

                File fileP = new File(MRP.instance.getDataFolder(), "/players/" + pname + ".yml");
                FileConfiguration configP = YamlConfiguration.loadConfiguration(fileP);

                if (config.getBoolean("Func.Login")) {
                    if (configP.isSet("Password")) {
                        if (args.length == 1) {
                            if (args[0] == configP.getString("Password")) {
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', configLan.getString("Messages.Command.LoginSuccess")));
                                configP.set("Logged", true);
                                try {
                                    configP.save(fileP);
                                } catch (IOException e) {
                                    e.printStackTrace(System.out);
                                }
                            }
                        } else {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', configLan.getString("Messages.Command.LoginFail")));
                        }
                    } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', configLan.getString("Messages.Command.Register")));
                    }
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', configLan.getString("Messages.Command.NotPlayer")));
            }
        }
        else
        {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', configLan.getString("Messages.WrongLanguage")));
        }
        return true;
    }
}

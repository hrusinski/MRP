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

                // Je už přihlášený?
                if (!configP.getBoolean("Logged")) {
                    // Má nastavené heslo?
                    if (configP.isSet("Password")) {
                        // Zadal správně hesla?
                        if (args.length == 1 && args[0].equals(configP.getString("Password"))) {
                            // Nastavit heslo a pustit
                            configP.set("Logged", true);
                            try {
                                configP.save(fileP);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', configLan.getString("Messages.Command.Login.Successful")));
                        } else {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', configLan.getString("Messages.Command.Login")));
                        }
                    } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', configLan.getString("Messages.Command.Register")));
                    }
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', configLan.getString("Messages.Command.Login")));
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', configLan.getString("Messages.Command.NotPlayer")));
            }
        } else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', configLan.getString("Messages.WrongLanguage")));
        }
        return true;
    }
}

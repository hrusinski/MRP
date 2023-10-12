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

public class REGISTERcmd implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (sender instanceof Player){
            if(sender instanceof Player){
                Player player = ((Player) sender).getPlayer();
                String pname = player.getName();

                File file = new File(MRP.instance.getDataFolder(), "config.yml");
                FileConfiguration config = YamlConfiguration.loadConfiguration(file);

                File fileP = new File(MRP.instance.getDataFolder(), "/players/" + pname+".yml");
                FileConfiguration configP = YamlConfiguration.loadConfiguration(fileP);

                if(config.getBoolean("Func.Login")){
                    if(!configP.isSet("Password")){

                    }
                }
        }

        return true;
    }
}

package hrusinski.mrp.Func;

import hrusinski.mrp.MRP;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.io.File;
import java.io.IOException;

public class DeathToSpec implements Listener {

    @EventHandler
    public void onPlayerDeathSpec(PlayerDeathEvent event){
        Player player = event.getPlayer();
        String pname = player.getName();

        File file = new File(MRP.instance.getDataFolder(), "config.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        if(config.getBoolean("Func.OneLive")){
            if (config.isSet("region")) {
                File fileLan = new File(MRP.instance.getDataFolder(), "region/" + config.getString("region") + "yml");
                FileConfiguration configLan = YamlConfiguration.loadConfiguration(fileLan);

                player.sendMessage(ChatColor.translateAlternateColorCodes('&', configLan.getString("Messages.Events.Death")));
                player.setGameMode(GameMode.SPECTATOR);
            } else {
                File fileEN = new File(MRP.instance.getDataFolder(), "region/EN.yml");
                FileConfiguration configEN = YamlConfiguration.loadConfiguration(fileEN);

                player.getServer().getConsoleSender().sendMessage(configEN.getString("Messages.WrongLanguage"));
            }
            File fileP = new File(MRP.instance.getDataFolder(), pname+".yml");
            FileConfiguration configP = YamlConfiguration.loadConfiguration(file);
            configP.set("Status", "Died");
            try {
                configP.save(fileP);
            } catch (IOException e){
                e.printStackTrace(System.out);
            }
        }
    }
}

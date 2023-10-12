package hrusinski.mrp.Func;

import hrusinski.mrp.MRP;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.PlayerInventory;

import java.io.File;

public class LoginPlayer implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        File file = new File(MRP.instance.getDataFolder(), "config.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        Player player = event.getPlayer();
        String pname = player.getName();

        File fileP = new File(MRP.instance.getDataFolder(), "/players/" + pname+".yml");
        FileConfiguration configP = YamlConfiguration.loadConfiguration(fileP);

        if (config.getBoolean("Func.Login")) {
            if (!configP.getBoolean("Logged")) {


                PlayerInventory pInv = player.getInventory();
                player.setWalkSpeed(0);
                Location pLoc = player.getLocation();

                player.getInventory().clear();

                while (!configP.getBoolean("Logged")){
                    player.teleport(pLoc);
                }
                while(true){
                    if(configP.getBoolean("Logged")){
                        player.setWalkSpeed(0.2f);
                        player.getInventory().setContents(pInv.getContents());
                    }
                }
            }
        }
    }
}

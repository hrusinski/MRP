package hrusinski.mrp.Func;

import hrusinski.mrp.MRP;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class OneLive implements Listener {

    @EventHandler
    public void onJoinGameModeChange(PlayerJoinEvent event) {
        File file = new File(MRP.instance.getDataFolder(), "config.yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

        Player player = event.getPlayer();
        String pname = player.getName();

        File fileP = new File(MRP.instance.getDataFolder(), "/players/" + pname + ".yml");
        YamlConfiguration configP = YamlConfiguration.loadConfiguration(fileP);

        player.setInvulnerable(true);
        player.setWalkSpeed(0);

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        player.setInvulnerable(false);
        player.setWalkSpeed(0.2f);

        if (configP.getString("GameMode").toUpperCase().equals("SURVIVAL")) {
            player.setGameMode(GameMode.SURVIVAL);
        } else if (configP.getString("GameMode").toUpperCase().equals("CREATIVE")) {
            player.setGameMode(GameMode.CREATIVE);
        } else if (configP.getString("GameMode").toUpperCase().equals("ADVENTURE")) {
            player.setGameMode(GameMode.ADVENTURE);
        } else if (configP.getString("GameMode").toUpperCase().equals("SPECTATOR")) {
            player.setGameMode(GameMode.SPECTATOR);
        }
    }

    @EventHandler
    public void onDead(PlayerDeathEvent event){
        File file = new File(MRP.instance.getDataFolder(), "config.yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

        Player player = event.getPlayer();
        String pname = player.getName();

        File fileP = new File(MRP.instance.getDataFolder(), "/players/" + pname+".yml");
        YamlConfiguration configP = YamlConfiguration.loadConfiguration(fileP);

        if(config.getBoolean("Func.OneLive")){
            player.setGameMode(GameMode.SPECTATOR);
            configP.set("GameMode", "SPECTATOR");
            configP.set("Died", true);
            try {
                configP.save(fileP);
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        }
    }

    @EventHandler
    public void onGameModeChange(PlayerGameModeChangeEvent event){
        File file = new File(MRP.instance.getDataFolder(), "config.yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

        Player player = event.getPlayer();
        String pname = player.getName();

        File fileP = new File(MRP.instance.getDataFolder(), "/players/" + pname+".yml");
        YamlConfiguration configP = YamlConfiguration.loadConfiguration(fileP);

        if (event.getNewGameMode().equals(GameMode.SURVIVAL)){
            configP.set("GameMode", "SURVIVAL");
        } else if (event.getNewGameMode().equals(GameMode.CREATIVE)) {
            configP.set("GameMode", "CREATIVE");
        } else if (event.getNewGameMode().equals(GameMode.ADVENTURE)) {
            configP.set("GameMode", "ADVENTURE");
        } else if (event.getNewGameMode().equals(GameMode.SPECTATOR)) {
            configP.set("GameMode", "SPECTATOR");
        }
        try {
            configP.save(fileP);
        } catch (IOException e){
            e.printStackTrace(System.out);
        }
    }
}

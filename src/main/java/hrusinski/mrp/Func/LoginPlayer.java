package hrusinski.mrp.Func;

import hrusinski.mrp.MRP;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LoginPlayer implements Listener {

    @EventHandler
    public void onPlayerJoinLogin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String pname = player.getName();

        File fileP = new File(MRP.instance.getDataFolder(), "/players/" + pname + ".yml");
        FileConfiguration configP = YamlConfiguration.loadConfiguration(fileP);

        if (configP.getBoolean("Logged")) {
            // Hráč je již přihlášen, nemusíme provádět žádné další kroky
            return;
        }

        File file = new File(MRP.instance.getDataFolder(), "config.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        File fileLan = new File(MRP.instance.getDataFolder(), "region/" + config.getString("region") + ".yml");
        FileConfiguration configLan = YamlConfiguration.loadConfiguration(fileLan);

        if (config.getBoolean("Func.Login")) {
            PlayerInventory pInv = player.getInventory();
            player.getInventory().clear();

            if (configP.isSet("Password")) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', configLan.getString("Messages.Command.Login")));
            } else {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', configLan.getString("Messages.Command.Register")));
            }

            // Plánování asynchronní úlohy po uplynutí 10 sekund
            int delayTicks = 200; // 1 sekunda = 20 herních ticků (10 sekund = 200 ticků)

            BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
            scheduler.runTaskLater(MRP.instance, () -> {
                // Tato část kódu se spustí asynchronně po uplynutí 10 sekund
                player.getInventory().setContents(pInv.getContents());
            }, delayTicks);

            new BukkitRunnable() {
                private int repetitions = 0;

                @Override
                public void run() {
                    if (repetitions < 3) {
                        repetitions++;
                        // Kód, který se spustí každých 10 sekund (po třetím opakování vyhodí hráče)
                        if(configP.isSet("Password")){
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', configLan.getString("Messages.Command.Login")));
                            this.cancel();
                        } else {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', configLan.getString("Messages.Command.Register")));
                            this.cancel();
                        }
                    } else {
                        // Po třetím opakování vyhoď hráče
                        this.cancel();
                        player.kickPlayer(ChatColor.translateAlternateColorCodes('&', configLan.getString("Messages.Login.TooLongTime")));
                    }
                }
            }.runTaskTimer(MRP.instance, delayTicks, delayTicks);
        }
    }

    @EventHandler
    public void onPlayerMoveLogin(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        String pname = player.getName();

        File fileP = new File(MRP.instance.getDataFolder(), "/players/" + pname + ".yml");
        FileConfiguration configP = YamlConfiguration.loadConfiguration(fileP);

        if (configP.getBoolean("Logged")) return;

        File file = new File(MRP.instance.getDataFolder(), "config.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        File fileLan = new File(MRP.instance.getDataFolder(), "region/" + config.getString("region") + ".yml");
        FileConfiguration configLan = YamlConfiguration.loadConfiguration(fileLan);

        event.setCancelled(true);
    }
}
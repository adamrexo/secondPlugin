package eu.rexo.secondplugin.Listeners;

import eu.rexo.secondplugin.Utils.DBManager;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Quit implements Listener {
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        String nickname = event.getPlayer().getName();
        String uuid = String.valueOf(event.getPlayer().getUniqueId());

        Date unfOdchod = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fOdchod = dateFormat.format(unfOdchod);

        event.getPlayer().chat("Zaznamenán odchod v: " + fOdchod);

        DBManager db = new DBManager();
        db.pridatOdchod(nickname, uuid, fOdchod);
    }
}
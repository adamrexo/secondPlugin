package eu.rexo.secondplugin.Listeners;

import eu.rexo.secondplugin.Utils.*;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Join implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        String nickname = event.getPlayer().getName();
        String uuid = String.valueOf(event.getPlayer().getUniqueId());

        Date unfPrichod = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fPrichod = dateFormat.format(unfPrichod);

        event.getPlayer().chat("Zaznamenán příchod v: " + fPrichod);

        DBManager db = new DBManager();
        db.pridatPrichod(nickname, uuid, fPrichod);
    }
}

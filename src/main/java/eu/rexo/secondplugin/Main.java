package eu.rexo.secondplugin;

import org.bukkit.plugin.java.*;
import eu.rexo.secondplugin.Utils.*;
import eu.rexo.secondplugin.Commands.*;
import eu.rexo.secondplugin.Listeners.*;
import org.bukkit.scheduler.BukkitScheduler;

public final class Main extends JavaPlugin {

    private DBManager db = new DBManager();

    @Override
    public void onEnable() {
        db.createTable();
        getCommand("menu").setExecutor(new menu());

        getCommand("prichody").setExecutor(new prichody());
        getCommand("odchody").setExecutor(new odchody());
        getServer().getPluginManager().registerEvents(new Join(), this);
        getServer().getPluginManager().registerEvents(new Quit(), this);
        getServer().getPluginManager().registerEvents(new GUIManager(), this);

        BukkitScheduler scheduler = getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                getServer().broadcastMessage("time loop");
            }
        }, 0, 1200);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}

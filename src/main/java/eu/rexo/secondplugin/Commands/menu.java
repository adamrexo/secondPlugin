package eu.rexo.secondplugin.Commands;

import eu.rexo.secondplugin.Listeners.GUIManager;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import java.sql.SQLException;

public class menu implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            GUIManager.openMainMenu(player);
            return true;
        } else {
            sender.sendMessage("Tento příkaz může používat pouze hráč.");
            return false;
        }
    }
}
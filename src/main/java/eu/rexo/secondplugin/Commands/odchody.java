package eu.rexo.secondplugin.Commands;

import eu.rexo.secondplugin.Utils.*;
import org.bukkit.command.*;
import java.sql.SQLException;

public class odchody implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        DBManager db = new DBManager();
        String[] odchody = new String[0];
        try {
            odchody = db.ziskatOdchody(sender.getName());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        for (int j = 0; j < odchody.length; j++) {
            String odchod = odchody[j];

            if (odchod != null) {
                sender.sendMessage(odchod);
            }
        }
        return true;
    }
}
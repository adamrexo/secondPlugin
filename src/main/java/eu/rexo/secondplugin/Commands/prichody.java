package eu.rexo.secondplugin.Commands;

import eu.rexo.secondplugin.Utils.*;
import org.bukkit.command.*;
import java.sql.SQLException;

public class prichody implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        DBManager db = new DBManager();
        String[] prichody = new String[0];
        try {
            prichody = db.ziskatPrichody(sender.getName());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        for (int j = 0; j < prichody.length; j++) {
            String prichod = prichody[j];

            if (prichod != null) {
                sender.sendMessage(prichod);
            }
        }
        return true;
    }
}
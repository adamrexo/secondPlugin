package eu.rexo.secondplugin.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class GUIManager implements Listener {
    private static Inventory menu;

    public GUIManager() {
        menu = Bukkit.createInventory(null, 9, "Hlavní menu");

        menu.setItem(3, createButtonItem(Material.PAPER, "Vypíše Test Paper"));
        menu.setItem(5, createButtonItem(Material.CHEST, "Vypíše Test Chest"));
    }

    private ItemStack createButtonItem(Material material, String displayName) {
        ItemStack item = new ItemStack(material);
        item.getItemMeta().setDisplayName(displayName);
        return item;
    }

    public static void openMainMenu(Player player) {
        player.openInventory(menu);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getInventory().equals(menu) && event.getCurrentItem() != null) {
            Player player = (Player) event.getWhoClicked();

            ItemStack clickedItem = event.getCurrentItem();
            int slot = event.getSlot();

            if (slot == 3) {
                player.sendMessage("Test Paper");
            } else if (slot == 5) {
                player.sendTitle("Test", "Chest");
            }

            event.setCancelled(true);
        }
    }
}

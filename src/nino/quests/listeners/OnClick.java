package nino.quests.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.Plugin;

public class OnClick implements Listener {
    Plugin plugin;

    public OnClick(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void onItemClick(InventoryClickEvent event){
        if(event.getClickedInventory()!=null){
            if(event.getClickedInventory().getTitle().equalsIgnoreCase(ChatColor.DARK_GREEN+"Quests")){

            }
        }
    }
}

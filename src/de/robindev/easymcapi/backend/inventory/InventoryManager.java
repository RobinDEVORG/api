package de.robindev.easymcapi.backend.inventory;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import de.robindev.easymcapi.Main;

/**
* @author RobinDEV (17.09.2016, 00:26:10)
*/
public class InventoryManager implements Listener {
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if (Main.CLICK_LISTENERS.containsKey(event.getCurrentItem())) {
			Main.CLICK_LISTENERS.get(event.getCurrentItem()).onClick(event.getCurrentItem());
		}
		
		if (Main.NO_CLICK.contains(event.getInventory())) {
			event.setCancelled(true);
		}
	}
}

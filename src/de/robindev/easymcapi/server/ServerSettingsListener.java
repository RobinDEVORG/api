package de.robindev.easymcapi.server;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

/**
 * @author RobinDEV (23.09.2016, 17:09:45)
 */
public class ServerSettingsListener implements Listener {

	@EventHandler
	public void onFoodLevelChange(FoodLevelChangeEvent event) {
		event.setCancelled(!ServerSettings.isFoodCanceled());
	}

	@EventHandler
	public void onEntityDamage(EntityDamageEvent event) {
		if (event.getEntityType().equals(EntityType.PLAYER)) {
			event.setCancelled(ServerSettings.isPlayerDamageCanceled());
		} else {
			event.setCancelled(ServerSettings.isEntityDamageCanceled());
		}
	}
}

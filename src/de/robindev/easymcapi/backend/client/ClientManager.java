package de.robindev.easymcapi.backend.client;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import de.robindev.easymcapi.player.Client;

/**
 * @author RobinDEV (23.09.2016, 22:00:43)
 */
public class ClientManager implements Listener {
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();

		if (Client.players.containsKey(player.getName().toLowerCase())) {
			Client.players.remove(player.getName().toLowerCase());
		}
	}
}

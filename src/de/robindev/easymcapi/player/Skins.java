package de.robindev.easymcapi.player;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

import de.robindev.easymcapi.Main;
import de.robindev.easymcapi.entity.Entities;
import de.robindev.easymcapi.external.jofkos.GameProfileFetcher;
import de.robindev.easymcapi.external.jofkos.UUIDFetcher;
import de.robindev.easymcapi.packet.Packets;
import de.robindev.easymcapi.playerlist.PlayerList;

/**
 * @author RobinDEV (25.09.2016, 11:09:36)
 */
public abstract class Skins {

	private static Map<Player, PlayerAttributes> attributes = new HashMap<>();

	public static void changeSkin(Player player, String name) {
		CraftPlayer cPlayer = Packets.toCraftPlayer(player);

		GameProfile skinProfile = null;
		GameProfile playerProfile = cPlayer.getProfile();

		try {
			skinProfile = GameProfileFetcher.fetch(UUIDFetcher.getUUID(name));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Collection<Property> properties = skinProfile.getProperties().get("textures");

		playerProfile.getProperties().removeAll("textures");
		playerProfile.getProperties().putAll("textures", properties);

		Entities.destroy(cPlayer.getHandle());
		PlayerList.removePlayer(player);

		attributes.put(cPlayer, new PlayerAttributes(player));

		cPlayer.setHealth(0.0D);

		new BukkitRunnable() {

			@Override
			public void run() {
				cPlayer.spigot().respawn();
				cPlayer.setHealth(0.0D);
				PlayerList.addPlayer(player);

				Bukkit.getOnlinePlayers().stream().filter(all -> !all.getName().equals(player.getName()))
						.forEach(all -> {
							Entities.destroy(cPlayer.getHandle(), all);
						});

				attributes.get(player).copyOn(player);
			}
		}.runTaskLater(Main.instance, 4);
	}
}

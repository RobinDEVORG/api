package de.robindev.easymcapi.backend;

import java.io.File;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.robindev.easymcapi.backend.rank.Rank;
import de.robindev.easymcapi.codec.CodecTable;
import de.robindev.easymcapi.configuration.XYamlConfiguration;
import de.robindev.easymcapi.external.jofkos.UUIDFetcher;
import de.robindev.easymcapi.player.Client;
import de.robindev.easymcapi.scoreboard.XScoreboard;

/**
 * @author RobinDEV (25.09.2016, 12:05:49)
 */
public abstract class PlayerDatabase {

	private static XYamlConfiguration data = new XYamlConfiguration(new File("plugins/EasyMC/Data/players.yml"));

	private static XScoreboard rankScoreboard = new XScoreboard();
	
	public static void init() {
		for (Rank rank : Rank.values()) {
			rankScoreboard.addTeam(rank.getTeamName(), rank.getPrefix());
		}
	}
	
	public static void createIndex(String name) {
		data.set(getUUIDString(name) + "." + CodecTable.DATA_RANK, CodecTable.DATA_RANK_PLAYER);
		data.set(getUUIDString(name) + "." + CodecTable.DATA_MONEY, CodecTable.encode(String.valueOf(0)));
		data.set(getUUIDString(name) + "." + CodecTable.DATA_SKIN, CodecTable.DATA_NO_SKIN);
		data.saveConfiguration();
	}

	public static boolean hasIndex(String name) {
		return data.getString(getUUIDString(name) + "." + CodecTable.DATA_RANK) != null;
	}

	private static String getUUIDString(String name) {
		return UUIDFetcher.getUUID(name).toString();
	}

	public static class SkinManager {

		public static String getSkin(String name) {
			return CodecTable.decode(data.getString(getUUIDString(name) + "." + CodecTable.DATA_SKIN));
		}

		public static void setSkin(String player, String name) {
			data.set(getUUIDString(player) + "." + CodecTable.DATA_SKIN, CodecTable.encode(name));
			data.saveConfiguration();
		}
	}

	public static class RankManager {

		public static String getRankString(String name) {
			return CodecTable.decode(data.getString(getUUIDString(name) + "." + CodecTable.DATA_RANK).toUpperCase())
					.toUpperCase();
		}

		public static Rank getRank(String name) {
			return Rank.valueOf(getRankString(name).substring(5));
		}
	}

	public static class PlayerJoinEventListener implements Listener {

		@EventHandler
		public void onPlayerJoin(PlayerJoinEvent event) {

			Client client = Client.getClient(event.getPlayer().getName());

			if (!hasIndex(client.getName())) {
				createIndex(client.getName());
			}

			String skin = SkinManager.getSkin(client.getName());
			
			if (!skin.equals("00")) {
				client.setSkin(skin);
			}

			client.sendMessage("§aRang: " + RankManager.getRank(client.getName()));

		}
	}

}

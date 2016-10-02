package de.robindev.easymcapi.player;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

import de.robindev.easymcapi.packet.Packets;
import de.robindev.easymcapi.playerlist.PlayerList;
import net.minecraft.server.v1_8_R3.Packet;

/**
* @author RobinDEV (23.09.2016, 21:54:48)
*/
public class Client extends CraftPlayer {
	
	public static Map<String, Client> players = new HashMap<>();
	
	private Player player;
	
	private Client(Player player) {
		super((CraftServer) Bukkit.getServer(), ((CraftPlayer) player).getHandle());
		this.player = player;

		players.put(player.getName().toLowerCase(), this);
	}
	
	public static Client getClient(String name) {
		if (players.containsKey(name.toLowerCase())) {
			return players.get(name.toLowerCase());
		} else {
			Player player = Bukkit.getPlayer(name);
			return player != null ? new Client(player) : null;
		}
	}
	
	@Override
	public boolean hasPermission(Permission perm) {
		return player.hasPermission(perm);
	}
	
	@Override
	public boolean hasPermission(String perm) {
		return player.hasPermission(perm);
	}
	
	public void sendPacket(Packet<?> packet) {
		Packets.sendPacket(packet, player);
	}
	
	public void sendEmptyMessage() {
		sendMessage("");
	}
	
	public void sendEmptyMessage(int times) {
		for (int i = 0; i < times; i++) {
			sendEmptyMessage();
		}
	}
	
	public int getPing() {
		return getHandle().ping;
	}
	
	public void addToTab() {
		PlayerList.addPlayer(player);
	}
	
	public void removeFromTab() {
		PlayerList.removePlayer(player);
	}
	
	public void updateForTab() {
		PlayerList.update(player);
	}
	
	public void setSkin(String skin) {
		Skins.changeSkin(player, skin);
	}
}

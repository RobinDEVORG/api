package de.robindev.easymcapi.packet;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.Packet;

/**
* @author RobinDEV (15.09.2016, 21:16:25)
*/
public abstract class Packets {
	
	public static void sendPacket(Packet<?> packet, Player target) {
		toCraftPlayer(target).getHandle().playerConnection.sendPacket(packet);
	}
	
	
	public static void broadcastPacket(Packet<?> packet) {
		Bukkit.getOnlinePlayers().stream().forEach(player -> {
			sendPacket(packet, player);
		});
	}
	
	public static void broadcastPacketToList(Packet<?> packet, List<Player> targets) {
		targets.stream().forEach(player -> {
			sendPacket(packet, player);
		});
	}
	
	public static CraftPlayer toCraftPlayer(Player player) {
		return (CraftPlayer) player;
	}
}

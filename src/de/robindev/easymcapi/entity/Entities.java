package de.robindev.easymcapi.entity;

import java.util.List;

import org.bukkit.entity.Player;

import de.robindev.easymcapi.packet.Packets;
import net.minecraft.server.v1_8_R3.Entity;
import net.minecraft.server.v1_8_R3.EntityHuman;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityDestroy;
import net.minecraft.server.v1_8_R3.PacketPlayOutNamedEntitySpawn;

/**
* @author RobinDEV (25.09.2016, 11:25:13)
*/
public abstract class Entities {
	
	public static void destroy(Entity entity) {
		PacketPlayOutEntityDestroy packet = new PacketPlayOutEntityDestroy(entity.getId());
		Packets.broadcastPacket(packet);
	}
	
	public static void destroy(Entity entity, Player player) {
		PacketPlayOutEntityDestroy packet = new PacketPlayOutEntityDestroy(entity.getId());
		Packets.sendPacket(packet, player);
	}
	
	public static void destoryToList(Entity entity, List<Player> players) {
		players.stream().forEach(player -> {
			destroy(entity, player);
		});
	}
	
	public static void spawnNamed(EntityHuman entity) {
		PacketPlayOutNamedEntitySpawn packet = new PacketPlayOutNamedEntitySpawn(entity);
		Packets.broadcastPacket(packet);
	}
	
	public static void spawnNamed(EntityHuman entity, Player player) {
		PacketPlayOutNamedEntitySpawn packet = new PacketPlayOutNamedEntitySpawn(entity);
		Packets.sendPacket(packet, player);
	}
	
	public static void spawnNamedToList(EntityHuman entity, List<Player> players) {
		players.stream().forEach(player -> {
			spawnNamed(entity, player);
		});
	}
}

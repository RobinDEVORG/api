package de.robindev.easymcapi.playerlist;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import de.robindev.easymcapi.packet.Packets;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerInfo;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerInfo.EnumPlayerInfoAction;

/**
* @author RobinDEV (15.09.2016, 21:16:16)
*/
public abstract class PlayerList {
	
	public static void addPlayer(Player player) {
		PacketPlayOutPlayerInfo packet = new PacketPlayOutPlayerInfo(EnumPlayerInfoAction.ADD_PLAYER, ((CraftPlayer) player).getHandle());
		
		Packets.broadcastPacket(packet);
	}
	
	public static void removePlayer(Player player) {
		PacketPlayOutPlayerInfo packet = new PacketPlayOutPlayerInfo(EnumPlayerInfoAction.ADD_PLAYER, ((CraftPlayer) player).getHandle());
		
		Packets.broadcastPacket(packet);
	}
	
	public static void update(Player player) {
		removePlayer(player);
		addPlayer(player);
	}
	
	public static void addPlayerForPlayers(Player toAdd, Player... toAddTo) {
		PacketPlayOutPlayerInfo packet = new PacketPlayOutPlayerInfo(EnumPlayerInfoAction.ADD_PLAYER, ((CraftPlayer) toAdd).getHandle());
		
		for (Player player : toAddTo) {
			Packets.sendPacket(packet, player);
		}
	}
	
	public static void removePlayerForPlayers(Player toRemove, Player... toRemoveTo) {
		PacketPlayOutPlayerInfo packet = new PacketPlayOutPlayerInfo(EnumPlayerInfoAction.REMOVE_PLAYER, ((CraftPlayer) toRemove).getHandle());
		
		for (Player player : toRemoveTo) {
			Packets.sendPacket(packet, player);
		}
	}
}

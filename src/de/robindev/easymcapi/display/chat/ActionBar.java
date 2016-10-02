package de.robindev.easymcapi.display.chat;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;

import de.robindev.easymcapi.display.Sendable;
import de.robindev.easymcapi.packet.Packets;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;

/**
* @author RobinDEV (15.09.2016, 21:00:34)
*/
public class ActionBar implements Sendable {
	
	private String message;
	private List<String> targets;
	private IChatBaseComponent component;
	
	public ActionBar(String message) {
		this.message = message;
		
		targets = new ArrayList<>();
		
		component = Chat.getComponentFromString(message);
	}
	
	public ActionBar(String message, List<String> targets) {
		this(message);
		this.targets = targets;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void addTarget(String name) {
		targets.add(name);
	}
	
	public void removeTarget(String name) {
		targets.remove(name);
	}
	
	public void setTargets(List<String> targets) {
		this.targets = targets;
	}
	
	public List<?> getTargets() {
		return targets;
	}
	
	@Override
	public void send() {
		PacketPlayOutChat packet = new PacketPlayOutChat(component, (byte) 2);
		
		Bukkit.getOnlinePlayers().stream().forEach(player -> {
			if (targets.contains(player.getName())) {
				Packets.sendPacket(packet, player);
			}
		});
	}
}

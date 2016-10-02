package de.robindev.easymcapi.display.title;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;

import de.robindev.easymcapi.display.Sendable;
import de.robindev.easymcapi.display.chat.Chat;
import de.robindev.easymcapi.packet.Packets;
import de.robindev.easymcapi.reflection.Reflections;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;

/**
* @author RobinDEV (15.09.2016, 21:50:03)
*/
public class Title implements Sendable {
	
	private String message;
	private Subtitle subtitle;
	private List<String> targets;
	private IChatBaseComponent component;
	
	public Title(String message, Subtitle subtitle) {
		this.message = message;
		
		this.subtitle = subtitle;
		
		targets = new ArrayList<>();
		
		component = Chat.getComponentFromString(message);
	}
	
	public Title(String message, Subtitle subtitle, List<String> targets) {
		this(message, subtitle);
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
	
	public void setSubtitle(Subtitle subtitle) {
		this.subtitle = subtitle;
	}
	
	public Subtitle getSubtitle() {
		return subtitle;
	}
	
	@Override
	public void send() {
		PacketPlayOutTitle packetTitle = new PacketPlayOutTitle(EnumTitleAction.TITLE, component);
		
		if (subtitle != null) {
			subtitle.setTargets(targets);
			PacketPlayOutTitle packetSubtitle = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, Chat.getComponentFromString(subtitle.getMessage()));
			Bukkit.getOnlinePlayers().stream().forEach(player -> {
				if (targets.contains(player.getName())) {
					Packets.sendPacket(packetSubtitle, player);
				}
			});
		}
		
		Reflections.setField(packetTitle, "c", 10);
		Reflections.setField(packetTitle, "d", 10);
		Reflections.setField(packetTitle, "e", 10);
		
		Bukkit.getOnlinePlayers().stream().forEach(player -> {
			if (targets.contains(player.getName())) {
				Packets.sendPacket(packetTitle, player);
			}
		});
	}
}

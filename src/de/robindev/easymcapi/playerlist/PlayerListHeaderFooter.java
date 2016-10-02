package de.robindev.easymcapi.playerlist;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;

import de.robindev.easymcapi.display.Sendable;
import de.robindev.easymcapi.display.chat.Chat;
import de.robindev.easymcapi.packet.Packets;
import de.robindev.easymcapi.reflection.Reflections;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter;

/**
 * @author RobinDEV (15.09.2016, 21:21:08)
 */
public class PlayerListHeaderFooter implements Sendable {

	private String header;
	private String footer;
	
	private List<String> targets;
	
	private IChatBaseComponent headerComponent;
	private IChatBaseComponent footerComponent;

	public PlayerListHeaderFooter(String header, String footer) {
		this.header = header;
		this.footer = footer;
		
		targets = new ArrayList<>();

		headerComponent = Chat.getComponentFromString(header);
		footerComponent = Chat.getComponentFromString(footer);
	}

	public PlayerListHeaderFooter(String header, String footer, List<String> targets) {
		this(header, footer);
		this.targets = targets;
	}

	public void setHeader(String header) {
		this.header= header;
	}

	public String getHeader() {
		return header;
	}
	
	public void setFooter(String footer) {
		this.footer = footer;
	}
	
	public String getFooter() {
		return footer;
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
		PacketPlayOutPlayerListHeaderFooter packet = new PacketPlayOutPlayerListHeaderFooter();
		
		Reflections.setField(packet, "a", headerComponent);
		Reflections.setField(packet, "b", footerComponent);
		
		Bukkit.getOnlinePlayers().stream().forEach(player -> {
			if (targets.contains(player.getName())) {
				Packets.sendPacket(packet, player);
			}
		});
	}
}

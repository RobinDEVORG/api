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
 * @author RobinDEV (15.09.2016, 21:55:25)
 */
public class Subtitle implements Sendable {

	private String message;
	private List<String> targets;
	private IChatBaseComponent component;

	public Subtitle(String message) {
		this.message = message;

		targets = new ArrayList<>();

		component = Chat.getComponentFromString(message);
	}

	public Subtitle(String message, List<String> targets) {
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
		PacketPlayOutTitle packet = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, component);

		Reflections.setField(packet, "c", 10);
		Reflections.setField(packet, "d", 10);
		Reflections.setField(packet, "e", 10);

		Bukkit.getOnlinePlayers().stream().forEach(player -> {
			if (targets.contains(player.getName())) {
				Packets.sendPacket(packet, player);
			}
		});
	}
}

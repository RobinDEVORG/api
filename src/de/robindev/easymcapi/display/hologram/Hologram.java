package de.robindev.easymcapi.display.hologram;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;

/**
* @author RobinDEV (23.09.2016, 17:22:35)
*/
public class Hologram {
	
	private ArmorStand armorStand;
	
	public Hologram(Location location, String text) {
		armorStand = (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
		armorStand.setCustomName(text);
		armorStand.setCustomNameVisible(true);
		armorStand.setGravity(false);
		armorStand.setVisible(false);
	}
	
	public void setText(String text) {
		armorStand.setCustomName(text);
	}
	
	public String getText() {
		return armorStand.getCustomName();
	}
	
	public void move(Location location) {
		armorStand.teleport(location);
	}
	
	public void destroy() {
		armorStand.remove();
	}
}

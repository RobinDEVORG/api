package de.robindev.easymcapi.builder.item;

import org.bukkit.Material;

/**
* @author RobinDEV (16.09.2016, 21:52:32)
*/
public interface ItemBuilderPresets {
	
	public static ItemBuilder PLACEHOLDER = new ItemBuilder(Material.STAINED_GLASS_PANE)
			.addAllItemFlags()
			.setDisplayName("§c");
	
	public static ItemBuilder EXIT = new ItemBuilder(Material.BARRIER)
			.addAllItemFlags()
			.setDisplayName("§cLeave");
}

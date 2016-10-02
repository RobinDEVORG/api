package de.robindev.easymcapi.configuration;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

/**
 * @author RobinDEV (23.09.2016, 15:29:59)
 */
public class XYamlConfiguration extends YamlConfiguration {

	private File file;

	public XYamlConfiguration(File file) {
		this.file = file;
		loadConfiguration(file);
	}

	public File getFile() {
		return file;
	}

	public void saveLocation(String key, Location location) {
		set(key + ".World", location.getWorld().getName());
		set(key + ".X", location.getX());
		set(key + ".Y", location.getY());
		set(key + ".Z", location.getZ());
		set(key + ".Yaw", location.getYaw());
		set(key + ".Pitch", location.getPitch());
		saveConfiguration();
	}

	public Location getLocation(String key) {
		return new Location(Bukkit.getWorld(getString(key + ".World")), getDouble(key + ".X"), getDouble(key + ".Y"),
				getDouble(key + ".Z"), (float) getDouble(key + ".Yaw"), (float) getDouble(key + ".Pitch"));
	}

	public void saveConfiguration() {
		Configurations.save(file, this);
	}
}

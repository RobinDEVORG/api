package de.robindev.easymcapi.configuration;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;

/**
* @author RobinDEV (16.09.2016, 14:01:19)
*/
public abstract class Configurations {
	
	public static void save(File file, FileConfiguration cfg) {
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

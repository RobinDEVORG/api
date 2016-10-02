package de.robindev.easymcapi.server;

import de.robindev.easymcapi.Main;

/**
* @author RobinDEV (23.09.2016, 17:06:20)
*/
public abstract class ServerSettings {
	
	public static void setFoodCanceled(boolean canceled) {
		Main.SERVER_SETTINGS.set("Server.Settings.Food", canceled);
		Main.SERVER_SETTINGS.saveConfiguration();
	}
	
	public static void setMessagesCancelled(boolean join, boolean quit, boolean kick) {
		Main.SERVER_SETTINGS.set("Server.Settings.Message.Join", join);
		Main.SERVER_SETTINGS.set("Server.Settings.Message.Quit", quit);
		Main.SERVER_SETTINGS.set("Server.Settings.Message.Kick", kick);
	}
	
	public static void setPlayerDamageCanceled(boolean canceled) {
		Main.SERVER_SETTINGS.set("Server.Settings.Damage.Player", canceled);
		Main.SERVER_SETTINGS.saveConfiguration();
	}
	
	public static void setEntityDamageCanceled(boolean canceled) {
		Main.SERVER_SETTINGS.set("Server.Settings.Damage.Entity", canceled);
		Main.SERVER_SETTINGS.saveConfiguration();
	}

	public static boolean isFoodCanceled() {
		return Main.SERVER_SETTINGS.getBoolean("Server.Settings.Food");
	}
	
	public static boolean isPlayerDamageCanceled() {
		return Main.SERVER_SETTINGS.getBoolean("Server.Settings.Damage.Player");
	}
	
	public static boolean isEntityDamageCanceled() {
		return Main.SERVER_SETTINGS.getBoolean("Server.Settings.Damage.Entity");
	}
	
	public static boolean isMessageCancelled(String msgCodec) {
		return true;
	}
}

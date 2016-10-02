package de.robindev.easymcapi;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.math.RandomUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import de.robindev.easymcapi.backend.PlayerDatabase;
import de.robindev.easymcapi.backend.client.ClientManager;
import de.robindev.easymcapi.backend.inventory.InventoryManager;
import de.robindev.easymcapi.builder.item.ClickListener;
import de.robindev.easymcapi.command.SkinCommand;
import de.robindev.easymcapi.configuration.XYamlConfiguration;
import de.robindev.easymcapi.server.ServerSettingsListener;

/**
 * @author RobinDEV (15.09.2016, 20:58:56)
 */
public class Main extends JavaPlugin {

	public static final List<Inventory> NO_CLICK = new ArrayList<>();
	public static final Map<ItemStack, ClickListener> CLICK_LISTENERS = new HashMap<>();

	public static final XYamlConfiguration SERVER_SETTINGS = new XYamlConfiguration(
			new File("plugins/XSpigot/server/serversettings.yml"));

	public static Main instance;

	@Override
	public void onEnable() {
		instance = this;

		getServer().getPluginManager().registerEvents(new InventoryManager(), this);
		getServer().getPluginManager().registerEvents(new ServerSettingsListener(), this);
		getServer().getPluginManager().registerEvents(new ClientManager(), this);
		getServer().getPluginManager().registerEvents(new PlayerDatabase.PlayerJoinEventListener(), this);

		new SkinCommand();
		RandomUtils.nextInt();
		System.out.println("EasyMCAPI >> Bibliothek geladen!");
	}

	@Override
	public void onDisable() {
		System.out.println("EasyMCAPI >> Bibliothek beendet!");
	}

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {

		if (cmd.getName().equals("aids")) {
			Player player = (Player) cs;
			
		}
		return true;
	}
}

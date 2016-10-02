package de.robindev.easymcapi.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import de.robindev.easymcapi.player.Client;

/**
* @author RobinDEV (16.09.2016, 21:33:09)
*/
public abstract class XCommand<T extends JavaPlugin> implements CommandExecutor {
	
	protected T instance;
	
	public XCommand(T instance, String commandName) {
		this.instance = instance;
		instance.getCommand(commandName).setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		return cs instanceof Player ? execute(Client.getClient(((Player) cs).getName()), cmd, args) : true;
	}
	
	protected abstract boolean execute(Client player, Command cmd, String[] args);
}

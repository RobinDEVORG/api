package de.robindev.easymcapi.command;

import org.bukkit.command.Command;

import de.robindev.easymcapi.Main;
import de.robindev.easymcapi.player.Client;

/**
* @author RobinDEV (25.09.2016, 13:54:55)
*/
public class SkinCommand extends XCommand<Main> {

	public SkinCommand() {
		super(Main.instance, "skin");
	}

	@Override
	protected boolean execute(Client player, Command cmd, String[] args) {
		
		player.setSkin(args[0]);
		
		return true;
	}

}

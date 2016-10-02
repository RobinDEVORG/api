package de.robindev.easymcapi.player;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
* @author RobinDEV (25.09.2016, 11:41:30)
*/
public class PlayerAttributes {
	
	public double health;
	public double maxHealth;
	public int food;
	public float exp;
	public int level;
	public int fireTicks;
	public Location location;
	public GameMode gameMode;
	
	public PlayerAttributes(Player player) {
		health = player.getHealth();
		maxHealth = player.getMaxHealth();
		food = player.getFoodLevel();
		exp = player.getExp();
		level = player.getLevel();
		fireTicks = player.getFireTicks();
		location = player.getLocation();
		gameMode = player.getGameMode();
	}
	
	public void copyOn(Player player) {
		player.setHealth(health);
		player.setMaxHealth(maxHealth);
		player.setFoodLevel(food);
		player.setExp(exp);
		player.setLevel(level);
		player.setFireTicks(fireTicks);
		player.teleport(location);
		player.setGameMode(gameMode);
	}
}

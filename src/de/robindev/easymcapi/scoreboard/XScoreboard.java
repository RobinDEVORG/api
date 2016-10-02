package de.robindev.easymcapi.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

/**
 * @author RobinDEV (09.09.2016, 17:23:48)
 */
public class XScoreboard {

	private Scoreboard scoreboard;

	public XScoreboard() {
		scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
	}

	public Objective addObjective(String name, DisplaySlot slot) {
		if (name.length() > 16) {
			System.err.println("XSpigot >> Objectivename can't be longer than 16 Characters!");
			return null;
		}

		Objective objective = scoreboard.registerNewObjective("o" + name, "t" + name);
		objective.setDisplaySlot(slot);
		objective.setDisplayName(name);

		return objective;
	}

	public Score addScore(Objective o, String name, int pos) {
		Score score = o.getScore(name);
		score.setScore(pos);

		return score;
	}

	public Team addTeam(String name, String prefix) {
		Team team = scoreboard.registerNewTeam(name);
		team.setPrefix(prefix);

		return team;
	}

	public void sendToAllPlayers() {
		Bukkit.getOnlinePlayers().stream().forEach(player -> {
			player.setScoreboard(scoreboard);
		});
	}

	public void addPlayerToTeam(String playerName, String teamName) {
		Team team = scoreboard.getTeam(teamName);
		if (!team.hasEntry(playerName)) {
			team.addEntry(playerName);
		}

	}

	public void removePlayerFromTeam(String playerName, String teamName) {
		Team team = scoreboard.getTeam(teamName);
		if (team.hasEntry(playerName)) {
			team.removeEntry(playerName);
		}

	}

	public Team addTeam(String name, String prefix, String suffix) {
		Team team = scoreboard.registerNewTeam(name);
		team.setPrefix(prefix);
		team.setSuffix(suffix);

		return team;
	}

	public Scoreboard toScoreboard() {
		return scoreboard;
	}
}

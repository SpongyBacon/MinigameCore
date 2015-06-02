package com.codebeasts.minigamecore.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.ScoreboardManager;

import com.codebeasts.minigamecore.MinigameCore;

public class Scoreboard {
	
	private MinigameCore plugin;
	public Scoreboard(MinigameCore plugin) {
		this.plugin = plugin;
	}
	
	private ScoreboardManager sbm = plugin.getServer().getScoreboardManager();
	
	private HashMap<String, org.bukkit.scoreboard.Scoreboard> boards = new HashMap<String, org.bukkit.scoreboard.Scoreboard>();
	private HashMap<UUID, String> boardUsers = new HashMap<UUID, String>();
	
	public org.bukkit.scoreboard.Scoreboard getBoard(String id) {
		if (!(boards.containsKey(id))) return null;
		
		return boards.get(id);
	}
	
	public void giveBoard(Player p, String id) {
		p.setScoreboard(getBoard(id));
		
		if (boardUsers.containsKey(p.getUniqueId())) {
			boardUsers.remove(p.getUniqueId());
		}
		
		boardUsers.put(p.getUniqueId(), id);
	}
	
	public void updateBoard(String id) {
		for (UUID uuid : boardUsers.keySet()) {
			Player p = null;
			try { p = Bukkit.getPlayer(uuid); } catch (Exception e) { }
			
			p.setScoreboard(sbm.getNewScoreboard());
		}
	}
	
	public Score[] generateScores(String[] st) {
		ArrayList<Score> scores = new ArrayList<Score>();
		Objective o = sbm.getNewScoreboard().registerNewObjective("test", "dummy");
		
		for (String s : st) {
			Score sc = o.getScore(s);
			
			scores.add(sc);
		}
		
		return scores.toArray(new Score[scores.size()]);
	}
	
	@SuppressWarnings("deprecation")
	public void newBoard(String id, String displayName, Score[] s) {
		org.bukkit.scoreboard.Scoreboard sb = sbm.getNewScoreboard();
		
		Objective o = sb.registerNewObjective("test", "dummy");
		o.setDisplayName(id);
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		for (Score sc : s) {
			o.getScore(sc.getPlayer()).setScore(sc.getScore());
		}
		
		boards.put(id, sb);
	}

}

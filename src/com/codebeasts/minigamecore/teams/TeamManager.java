package com.codebeasts.minigamecore.teams;

import java.util.Random;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.codebeasts.minigamecore.arena.Arena;

public class TeamManager {
	
	public TeamManager() {
		
	}
	
	public Team findTeam(Arena a) {
		int red = 0, blue = 0;
		for (Team t : a.assignedTeam.values()) {
			if (t == Team.RED) red++;
			if (t == Team.BLUE) blue++;
		}
		
		if (red > blue) {
			return Team.BLUE;
		}
		
		if (blue > red) {
			return Team.RED;
		}
		
		// if same size/fucked up
		Random r = new Random();
		boolean rb = r.nextBoolean();
		
		if (rb) return Team.BLUE;
		else return Team.RED;
	}
	
	public void forceBalance(Arena a) {
		for (UUID id : a.currentPlayers) {
			Player p = Bukkit.getPlayer(id);
			
			// This (should) re-assign the teams & be balanced.
			a.setTeam(p, findTeam(a));
		}
	}

}

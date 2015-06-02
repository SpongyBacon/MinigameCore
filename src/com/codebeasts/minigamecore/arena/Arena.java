package com.codebeasts.minigamecore.arena;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.codebeasts.minigamecore.arena.types.ArenaType;
import com.codebeasts.minigamecore.configs.ArenasFile;
import com.codebeasts.minigamecore.teams.Team;

public class Arena extends ArenaManager {
	
	/*
	 * Maps
	 * - Rotation
	 * - Builds
	 * - Selection
	 * Settings
	 * - Max players
	 * - Min players
	 * Listeners
	 * Lists
	 * - Current players
	 */
	
	private String id;
	
	private ArenaType primaryType;
	private ArenaType secoundaryType;
	
	private ArenasFile file;
	
	private ArrayList<Integer> ffaSpawns;
	private ArrayList<UUID> players;
	
	public HashMap<UUID, Team> assignedTeam;
	
	public Arena(String id, ArenaType primaryType, ArenaType secoundaryType) {
		this.id = id;
		
		this.primaryType = primaryType;
		this.secoundaryType = secoundaryType;
		
		this.file = ArenasFile.getInstance();
		
		if (secoundaryType == ArenaType.FFA) ffaSpawns = new ArrayList<Integer>();
		
		players = new ArrayList<UUID>();
		if (secoundaryType != ArenaType.FFA) assignedTeam = new HashMap<UUID, Team>();
	}
	
	public String getId() {	return id; }
	public void setId(String newId) { id = newId; }
	
	public ArenaType getPrimaryType() { return primaryType; }
	public void setPrimaryType(ArenaType arenaType) { primaryType = arenaType; }
	
	public ArenaType getSecoundaryType() { return secoundaryType; }
	public void setSecoundaryType(ArenaType arenaType) { secoundaryType = arenaType; }
	
	private Runnable startRunnable;
	public void setStartRunnable(Runnable r) { startRunnable = r; }
	
	public void start() {
		startRunnable.run();
	}
	
	private Runnable endRunnable;
	public void setEndRunnable(Runnable r) { endRunnable = r; }
	
	public void setSpawn(Location l, Team team) {
		if (secoundaryType == ArenaType.FFA) return;
		
		file.setSpawn(id, team, l);
	}
	
	public void setSpawns(Location red, Location blue) {
		if (secoundaryType == ArenaType.FFA) return;
		
		file.setSpawn(id, Team.BLUE, blue);
		file.setSpawn(id, Team.RED, red);
	}
	
	// FFA
	public void addSpawn(Location spawn) {
		if (secoundaryType != ArenaType.FFA) return;
		
		ffaSpawns.add(file.addSpawn(id, spawn));
	}
	
	// For ffa
	public void setSpawns(Location[] spawns) {
		if (secoundaryType != ArenaType.FFA) return;
		
		for (Location l : spawns) {
			ffaSpawns.add(file.addSpawn(id, l));
		}
	}
	
	public Location getSpawn(Team team) {
		return file.getSpawn(id, team);
	}
	
	// FFA
	public Location getSpawn() {
		Random r = new Random();
		
		return file.getSpawn(id, "" + ffaSpawns.get(r.nextInt(ffaSpawns.size())));
	}
	
	public void addPlayer(Player p) {
		if (!(players.contains(p.getUniqueId()))) players.add(p.getUniqueId());
		if (!(currentPlayers.contains(p.getUniqueId()))) players.add(p.getUniqueId());
	}
	
	public void addPlayer(Player p, Team t) {
		if (!(players.contains(p.getUniqueId()))) players.add(p.getUniqueId());
		if (!(assignedTeam.containsKey(p.getUniqueId()))) assignedTeam.put(p.getUniqueId(), t);
		if (!(currentPlayers.contains(p.getUniqueId()))) players.add(p.getUniqueId());
	}
	
	public void removePlayer(Player p) {
		if (players.contains(p.getUniqueId())) players.remove(p.getUniqueId());
		if (assignedTeam.containsKey(p.getUniqueId())) assignedTeam.remove(p.getUniqueId());
		if (currentPlayers.contains(p.getUniqueId())) players.remove(p.getUniqueId());
	}
	
	public Team getTeam(Player p) {
		return assignedTeam.get(p.getUniqueId());
	}
	
	public void setTeam(Player p, Team team) {
		if (assignedTeam.containsKey(p.getUniqueId())) {
			assignedTeam.remove(p.getUniqueId());
		}
		
		assignedTeam.put(p.getUniqueId(), team);
	}
	
	public void removeFromTeam(Player p) {
		if (assignedTeam.containsKey(p.getUniqueId())) {
			assignedTeam.remove(p.getUniqueId());
		}
	}
	
	private Runnable rotateRunnable;
	public void setRotateRunnable(Runnable r) { rotateRunnable = r; }
	
	public void rotate() {
		rotateRunnable.run();
	}
	
	public void end() {
		endRunnable.run();
	}
	
	public void destroy(boolean sure) {
		if (sure) {
			setId(null);
			file.removeArena(this);
		} else {
			return;
		}
	}

}

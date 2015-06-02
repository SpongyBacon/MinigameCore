package com.codebeasts.minigamecore.arena;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.entity.Player;

import com.codebeasts.minigamecore.configs.ArenasFile;

public class ArenaManager {
	
	public ArenaManager() {
		
	}
	
	private ArrayList<Arena> arenas = new ArrayList<Arena>();
	private ArrayList<String> arenaIds = new ArrayList<String>();
	
	public ArrayList<UUID> currentPlayers = new ArrayList<UUID>();
	
	public Arena[] getArenas() { return arenas.toArray(new Arena[arenas.size()]); }
	
	public boolean isArena(String id) {
		if (!(arenaIds.contains(id))) return false;
		else return true;
	}
	
	public Arena getArena(String id) {
		if (!(isArena(id))) return null;
		else {
			for (Arena a : arenas) {
				if (a.getId().equalsIgnoreCase(id)) {
					return a;
				}
			}
		}
		
		return null;
	}
	
	public void registerArena(Arena a) {
		arenas.add(a);
		arenaIds.add(a.getId());
	}
	
	public void unregisterArena(Arena a) {
		arenas.remove(a);
		arenaIds.remove(a.getId());
	}
	
	@SuppressWarnings("unused")
	public void setupArenas() {
		for (Arena a : arenas) {
			// TODO
		}
	}
	
	public void createArena(Arena a) {
		if (isArena(a.getId())) return;
		
		ArenasFile.getInstance().addArena(a);
		registerArena(a);
	}
	
	public void removeArena(Arena a) {
		if (!(isArena(a.getId()))) return;
		
		unregisterArena(a);
		a.destroy(true);
	}
	
	public void removeArena(String id) {
		if (!(isArena(id))) return;
		
		Arena a = getArena(id);
		
		unregisterArena(a);
		a.destroy(true);
	}
	
	public boolean isInArena(Player p) {
		if (currentPlayers.contains(p.getUniqueId())) return true; 
		else return false;
	}

}

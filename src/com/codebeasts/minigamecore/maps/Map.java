package com.codebeasts.minigamecore.maps;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import com.codebeasts.minigamecore.arena.Arena;

public class Map {
	
	private String id;
	private Arena arena;
	private int priority;
	
	private World world;
	private String worldName;
	
	private Location mapSpawn;
	
	public Map(String id, Arena arena) {
		this.id = id;
		this.arena = arena;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String newId) {
		this.id = newId;
	}
	
	public Arena getAssignedArena() {
		return this.arena;
	}
	
	public String getAssignedArenaId() {
		return this.arena.getId();
	}
	
	public void setAssignedArena(Arena a) {
		this.arena = a;
	}
	
	public int getPriority() {
		return this.priority;
	}
	
	public void setPriority(int i) {
		this.priority = i;
	}
	
	public World getWorld() {
		return this.world;
	}
	
	public void setWorld(World w) {
		this.world = w;
	}
	
	public void unloadWorld() {
		this.worldName = world.getName();
		
		Bukkit.unloadWorld(worldName, false);
	}
	
	public void loadWorld() {
		Bukkit.getWorld(worldName);
	}
	
	public void regenerate() {
		unloadWorld();
		loadWorld();
	}
	
	public Location getMapSpawn() {
		return this.mapSpawn;
	}
	
	public void setMapSpawn(Location l) {
		this.mapSpawn = l;
	}
	
	public void setup(Arena a, int prio, Location l) {
		setAssignedArena(a);
		setPriority(prio);
		setWorld (l.getWorld());
		setMapSpawn(l);
	}
	
	public void setMap(Map m) {
		setup(m.getAssignedArena(), m.getPriority(), m.getMapSpawn());
		m.destroy();
	}
	
	public void destroy() {
		unloadWorld();
		
		this.id = null;
		this.arena = null;
		this.priority = -1;
		this.world = null;
		this.worldName = null;
		this.mapSpawn = null;
	}

}

package com.codebeasts.minigamecore.configs;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import com.codebeasts.minigamecore.arena.Arena;
import com.codebeasts.minigamecore.teams.Team;

public class ArenasFile {
	
	private static ConfigFiles configs;
	/*private MinigameCore plugin;
	
	private ArenaManager am;*/
	
	public ArenasFile(ConfigFiles configs/*, MinigameCore plugin*/) {
		ArenasFile.configs = configs;
		/*this.plugin = plugin;
		
		this.am = plugin.getArenaManager();*/
	}
	
	private FileConfiguration getConfig() {
		if (configs.getConfig("arenas") == null) {
			configs.saveFile("arenas");
		}
		
		return configs.getConfig("arenas");
	}
	
	private void save() {
		configs.saveFile("arenas");
	}
	
	private boolean hasSection(String id) {
		if (getSection(id) == null) return false;
		else return true;
	}
	
	private ConfigurationSection getSection(String id) {
		return getConfig().getConfigurationSection(id);
	}
	
	private void createSection(String id) {
		if (!(hasSection(id))) getConfig().createSection(id);
		save();
	}
	
	private void removeSection(String id) {
		if (hasSection(id)) getConfig().set(id, null);
		save();
	}
	
	public void setSpawn(String id, Team team, Location loc) {
		getConfig().set(id + ".spawns." + team.name().toLowerCase() + ".world", loc.getWorld().getName());
		getConfig().set(id + ".spawns." + team.name().toLowerCase() + ".x", loc.getBlockX());
		getConfig().set(id + ".spawns." + team.name().toLowerCase() + ".y", loc.getBlockY());
		getConfig().set(id + ".spawns." + team.name().toLowerCase() + ".z", loc.getBlockZ());
		
		getConfig().set(id + ".spawns." + team.name().toLowerCase() + ".yaw", loc.getYaw());
		getConfig().set(id + ".spawns." + team.name().toLowerCase() + ".pitch", loc.getPitch());
		
		save();
	}
	
	private int countSpawns(String id) {
		int i = 0;
		for (@SuppressWarnings("unused") String s : getConfig().getConfigurationSection(id + ".spawns").getKeys(false)) {
			i++;
		}
		
		return i;
	}
	
	// ffa
	public int addSpawn(String id, Location loc) {
		int spawnId = countSpawns(id) + 1; // works out new spawn id
		
		getConfig().set(id + ".spawns." + spawnId + ".world", loc.getWorld().getName());
		getConfig().set(id + ".spawns." + spawnId + ".x", loc.getBlockX());
		getConfig().set(id + ".spawns." + spawnId + ".y", loc.getBlockY());
		getConfig().set(id + ".spawns." + spawnId + ".z", loc.getBlockZ());
		
		getConfig().set(id + ".spawns." + spawnId + ".yaw", loc.getYaw());
		getConfig().set(id + ".spawns." + spawnId + ".pitch", loc.getPitch());
		
		save();
		
		return spawnId;
	}
	
	public Location getSpawn(String id, Team team) {
		World w = Bukkit.getWorld(getConfig().getString(id + ".spawns." + team.name().toLowerCase() + ".world"));
		int x = getConfig().getInt(id + ".spawns." + team.name().toLowerCase() + ".x");
		int y = getConfig().getInt(id + ".spawns." + team.name().toLowerCase() + ".y");
		int z = getConfig().getInt(id + ".spawns." + team.name().toLowerCase() + ".z");
		
		Location loc = new Location(w, x, y, z);
		loc.setYaw((float) getConfig().getDouble(id + ".spawns." + team.name().toLowerCase() + ".yaw"));
		loc.setPitch((float) getConfig().getDouble(id + ".spawns." + team.name().toLowerCase() + ".pitch"));
	
		return loc;
	}
	
	// ffa
	public Location getSpawn(String id, String spawnId) {
		World w = Bukkit.getWorld(getConfig().getString(id + ".spawns." + spawnId + ".world"));
		int x = getConfig().getInt(id + ".spawns." + spawnId + ".x");
		int y = getConfig().getInt(id + ".spawns." + spawnId + ".y");
		int z = getConfig().getInt(id + ".spawns." + spawnId + ".z");
		
		Location loc = new Location(w, x, y, z);
		loc.setYaw((float) getConfig().getDouble(id + ".spawns." + spawnId + ".yaw"));
		loc.setPitch((float) getConfig().getDouble(id + ".spawns." + spawnId + ".pitch"));
	
		return loc;
	}
	
	public void addArena(Arena a) {
		if (!(hasSection(a.getId()))) {
			createSection(a.getId());
		}
	}
	
	public void removeArena(Arena a) {
		if (hasSection(a.getId())) {
			removeSection(a.getId());
		}
	}
	
	public static ArenasFile getInstance() {
		return new ArenasFile(configs);
	}

}

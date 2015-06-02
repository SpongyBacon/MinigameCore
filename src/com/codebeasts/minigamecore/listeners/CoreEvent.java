package com.codebeasts.minigamecore.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import com.codebeasts.minigamecore.MinigameCore;
import com.codebeasts.minigamecore.arena.ArenaManager;

public abstract class CoreEvent {

	public MinigameCore plugin;
	public ArenaManager am;
	
	public CoreEvent(MinigameCore plugin) {
		this.plugin = plugin;
		this.am = plugin.getArenaManager();
	}
	
	public boolean isPlayer(Entity e) {
		if (e instanceof Player) return true;
		else return false;
	}
	
	public boolean isPlayer(Player p) {
		if (p instanceof Player) return true;
		else return false;
	}
	
	public boolean isInArena(Player p) {
		return am.isInArena(p);
	}
	
}
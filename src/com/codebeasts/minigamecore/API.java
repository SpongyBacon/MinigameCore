package com.codebeasts.minigamecore;

import com.codebeasts.minigamecore.apis.Eco;
import com.codebeasts.minigamecore.apis.Pets;
import com.codebeasts.minigamecore.apis.ServerList;
import com.codebeasts.minigamecore.arena.ArenaManager;
import com.codebeasts.minigamecore.listeners.Listeners;
import com.codebeasts.minigamecore.maps.MapManager;
import com.codebeasts.minigamecore.teams.TeamManager;
import com.codebeasts.minigamecore.ui.Scoreboard;
import com.codebeasts.minigamecore.utils.CodeUtils;

@SuppressWarnings("unused")
public class API {
	
	private MinigameCore plugin;
	
	//private Scoreboard scoreboard;
	private Eco eco;
	private ServerList serverList;
	private Pets pets;
	private TeamManager teamManager;
	private MapManager mapManager;
	
	private Listeners listeners;
	
	public API(MinigameCore plugin, Listeners listeners, ServerList serverList) {
		this.plugin = plugin;
		
		//this.scoreboard = new Scoreboard(plugin);
		this.eco = new Eco();
		this.serverList = serverList;
		this.pets = new Pets();
		this.teamManager = new TeamManager();
		this.mapManager = new MapManager();
		
		this.listeners = listeners;
	}
	
	public CodeUtils getCodeUtils() {
		return plugin.getCodeUtils();
	}
	
	public ArenaManager getArenaManager() {
		return plugin.getArenaManager();
	}
	
	//public Scoreboard getScoreboard() {
	//	return scoreboard;
	//}
	
	public Listeners getListeners() {
		return listeners;
	}
	
	public Eco getEconomy() {
		return eco;
	}
	
	public ServerList getServerList() {
		return serverList;
	}
	
	public Pets getPets() {
		return pets;
	}
	
	public TeamManager getTeamManager() {
		return teamManager;
	}
	
	public MapManager getMapManager() {
		return mapManager;
	}

}

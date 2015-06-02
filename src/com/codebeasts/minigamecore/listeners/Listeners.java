package com.codebeasts.minigamecore.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import com.codebeasts.minigamecore.MinigameCore;

public class Listeners implements Listener {
	
	@SuppressWarnings("unused")
	private MinigameCore plugin;
	
	public PlayerInteract playerInteract;
	public PlayerDeath playerDeath;
	public PlayerRespawn playerRespawn;
	public PlayerJoin playerJoin;
	
	public Listeners(MinigameCore plugin) {
		this.plugin = plugin;
		
		this.playerInteract = new PlayerInteract(plugin);
		this.playerDeath = new PlayerDeath(plugin);
		this.playerRespawn = new PlayerRespawn(plugin);
		this.playerJoin = new PlayerJoin(plugin);
	}
	
	public void setRunnable(CoreListener l, Runnable r) {
		if (l == CoreListener.PlayerInteract) playerInteract.setRunnable(r);
		if (l == CoreListener.PlayerDeath) playerDeath.setRunnable(r);
		if (l == CoreListener.PlayerRespawn) playerRespawn.setRunnable(r);
		if (l == CoreListener.PlayerJoin) playerJoin.setRunnable(r);
	}
	
	/* ===========================================================
	 * [x][x][x] [x]       [x][x][x] [x]   [x] [x][x][x] [x][x][x]
	 * [x]   [x] [x]       [x]   [x] [x]   [x] [x]       [x]   [x]
	 * [x][x][x] [x]       [x][x][x] [x]   [x] [x][x][x] [x][x]
	 * {x]       [x]       [x]   [x]    [x]    [x]       [x]   [x]
	 * [x]       [x][x][x] [x]   [x]    [x]    [x][x][x] [x]   [x]
	 * =========================================================== */
	
	@EventHandler public void onInteract(PlayerInteractEvent e) { playerInteract.execute(e); }
	@EventHandler public void onDeath(PlayerDeathEvent e) { playerDeath.execute(e); }
	@EventHandler public void onRespawn(PlayerRespawnEvent e) { playerRespawn.execute(e); }
	@EventHandler public void onJoin(PlayerJoinEvent e) { playerJoin.execute(e); }
	
}

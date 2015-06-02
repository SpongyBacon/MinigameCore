package com.codebeasts.minigamecore.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.codebeasts.minigamecore.MinigameCore;

public class PlayerDeath extends CoreEvent {
	
	public PlayerDeath(MinigameCore plugin) {
		super(plugin);
	}
	
	/* Start of generic include */
	private Runnable runnable; public void setRunnable(Runnable r) { runnable = r; } private Player player; public Player getPlayer() { return player; }
	/* End of generic include */
	
	public Player getKiller() {
		return this.getPlayer().getKiller();
	}
	
	public void execute(PlayerDeathEvent e) {
		if (!(isInArena(e.getEntity()))) return;
		if (isPlayer(e.getEntity())) this.player = e.getEntity(); else return;
		
		if (runnable != null) runnable.run();
	}
	
}

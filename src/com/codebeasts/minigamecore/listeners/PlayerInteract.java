package com.codebeasts.minigamecore.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.codebeasts.minigamecore.MinigameCore;

public class PlayerInteract extends CoreEvent {
	
	public PlayerInteract(MinigameCore plugin) {
		super(plugin);
	}
	
	/* Start of generic include */
	private Runnable runnable; public void setRunnable(Runnable r) { runnable = r; } private Player player; public Player getPlayer() { return player; }
	/* End of generic include */
	
	public void execute(PlayerInteractEvent e) {
		if (e.isCancelled()) return;
		if (!(isInArena(e.getPlayer()))) return;
		if (isPlayer(e.getPlayer())) this.player = e.getPlayer(); else return;
		
		if (runnable != null) runnable.run();
	}
	
}

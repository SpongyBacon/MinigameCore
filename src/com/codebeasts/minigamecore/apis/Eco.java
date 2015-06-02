package com.codebeasts.minigamecore.apis;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.entity.Player;

public class Eco {
	
	private Economy eco = Vault.economy;
	
	public Eco() {
		
	}

	public double getBalance(Player p) {
		return eco.getBalance(p);
	}
	
	public void set(Player p, int newBal) {
		eco.withdrawPlayer(p, getBalance(p));
		eco.depositPlayer(p, newBal);
	}
	
	public void give(Player p, int amount) {
		eco.depositPlayer(p, amount);
	}
	
	public void take(Player p, int amount) {
		eco.withdrawPlayer(p, amount);
	}
	
	public void reset(Player p) {
		set(p, 0);
	}
	
}

package com.codebeasts.minigamecore.apis;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.plugin.RegisteredServiceProvider;

import com.codebeasts.minigamecore.MinigameCore;

public class Vault {
	
	public static Economy economy;
	
	private MinigameCore plugin;
	public Vault(MinigameCore plugin) {
		this.plugin = plugin;
	}
	
	public void setup() {
		setupVault();
	}
	
	public boolean setupVault() {
		if (plugin.getServer().getPluginManager().getPlugin("Vault") == null) {
			return false;
	    }
		
        RegisteredServiceProvider<Economy> rsp = plugin.getServer().getServicesManager().getRegistration(Economy.class);
        economy = rsp.getProvider();
        return economy != null;
    }

}

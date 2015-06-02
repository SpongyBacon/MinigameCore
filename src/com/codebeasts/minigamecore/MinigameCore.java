package com.codebeasts.minigamecore;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.codebeasts.minigamecore.apis.EchoPet;
import com.codebeasts.minigamecore.apis.Ping;
import com.codebeasts.minigamecore.apis.ServerList;
import com.codebeasts.minigamecore.apis.Vault;
import com.codebeasts.minigamecore.arena.ArenaManager;
import com.codebeasts.minigamecore.commands.Commands;
import com.codebeasts.minigamecore.configs.ConfigFiles;
import com.codebeasts.minigamecore.configs.CoreConfig;
import com.codebeasts.minigamecore.listeners.Listeners;
import com.codebeasts.minigamecore.utils.CodeUtils;

public class MinigameCore extends JavaPlugin {
	
	private CodeUtils codeUtils;
	@SuppressWarnings("unused")
	private ConfigFiles configFiles;
	private CoreConfig coreConfig;
	
	private ArenaManager arenaManager;
	//private SchedulerManager schedulerManager;
	
	private API api;
	private Vault vault;
	private Ping ping;
	private EchoPet echoPet;
	
	private ServerList serverList;
	
	public Listeners listeners;
	private Commands commands;
	
	private static MinigameCore mgCore;
	
	@Override
	public void onEnable() {
		this.codeUtils = new CodeUtils();
		this.configFiles = new ConfigFiles(this);
		this.coreConfig = new CoreConfig(this);
		
		this.arenaManager = new ArenaManager();
		//this.schedulerManager = new SchedulerManager();
		
		this.api = new API(this, listeners, serverList);
		this.vault = new Vault(this);
		this.ping = new Ping();
		this.echoPet = new EchoPet(this);
		
		this.serverList = new ServerList(ping);
		
		this.listeners = new Listeners(this);
		this.commands = new Commands(this);
		
		coreConfig.checkConfig();
		
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(listeners, this);
		
		commands.register();
		
		vault.setupVault();
		ping.registerPingAPI();
		echoPet.setup();
		
		arenaManager.setupArenas();
		
		mgCore = this;
		
		getLogger().info("Enabled!");
	}
	
	@Override
	public void onDisable() {
		
		
		getLogger().info("Disabled!");
	}
	
	public void checkConfig() {
		
	}
	
	public CodeUtils getCodeUtils() {
		return codeUtils;
	}
	
	public ArenaManager getArenaManager() {
		return arenaManager;
	}
	
	public static MinigameCore getInstance() {
		return mgCore;
	}
	
	public API getAPI() {
		return api;
	}

}
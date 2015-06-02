package com.codebeasts.minigamecore.configs;

import java.util.HashMap;

import org.bukkit.configuration.file.FileConfiguration;

import com.codebeasts.minigamecore.MinigameCore;

public class CoreConfig {
	
	private MinigameCore plugin;
	private FileConfiguration config;
	
	public CoreConfig(MinigameCore plugin) {
		this.plugin = plugin;
		this.config = plugin.getConfig();
	}
	
	public enum CoreSetting {
		USE_BUNGEECORD, USE_ECHOPET;
	}
	
	public HashMap<CoreSetting, Boolean> settings = new HashMap<CoreSetting, Boolean>();
	
	public boolean getSetting(CoreSetting s) {
		try { return settings.get(s); }
		catch (Exception e) { e.printStackTrace(); }
		
		return false;
	}
	
	public void checkConfig() {
		int saved = 0;
		
		if (config.get("use_bungeecord") == null)
			config.set("use_bungeecord", false); saved++;
		
		if (config.get("use_echopet") == null)
			config.set("use_echopet", false); saved++;
		
		if (saved > 0) {
			plugin.saveConfig();
			plugin.getLogger().info("Saved " + saved + " settings to the main MinigameCore config.");
		}
		
		for (String s : config.getConfigurationSection("").getKeys(false)) {
			for (CoreSetting e : CoreSetting.values()) {
				if (s.equalsIgnoreCase(e.name())) {
					settings.put(e, config.getBoolean(s));
					plugin.getLogger().info("Using " + e.name().toLowerCase() + ": " + config.getBoolean(s));
				}
			}
			
			plugin.getLogger().info("Unknown setting '" + s + "' found in the main MinigameCore config. Setting is not part of the CoreSetting enum!");
		}
	}

}

package com.codebeasts.minigamecore.configs;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.codebeasts.minigamecore.MinigameCore;

public class ConfigFiles {
	
	private MinigameCore plugin;
	private static ConfigFiles cfFiles;
	
	public ConfigFiles(MinigameCore plugin) {
		this.plugin = plugin;
		cfFiles = this;
	}
	
	public File getFile(String name) {
		File f = new File(plugin.getDataFolder(), name + ".yml");
		
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f;
	}
	
	public FileConfiguration getFileConfiguration(File file) {
		return YamlConfiguration.loadConfiguration(file);
	}
	
	public FileConfiguration getConfig(String name) {
		return YamlConfiguration.loadConfiguration(getFile(name));
	}
	
	public void saveCustomYml(FileConfiguration ymlConfig, File ymlFile) {
		try {
			ymlConfig.save(ymlFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void saveFile(String name) {
		saveCustomYml(getConfig(name), getFile(name));
	}
	
	public static ConfigFiles getInstance() {
		return cfFiles;
	}

}

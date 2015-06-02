package com.codebeasts.minigamecore.configs;

import java.util.Random;

import org.bukkit.configuration.file.FileConfiguration;

public class Errors {
	
	private ConfigFiles configs;
	
	public Errors(ConfigFiles configs) {
		this.configs = configs;
	}
	
	private FileConfiguration getConfig() {
		return configs.getConfig("errors");
	}
	
	private int generateId() {
		Random r = new Random();
		
		int id = r.nextInt();
		while (getConfig().get("" + id) != null) {
			id = r.nextInt();
		}
		
		return id;
	}
	
	public void report(Exception e) {
		int id = generateId();
		System.out.println("An error occured with MinigameCore. Logging as " + id + "...");
		
		int i = 1;
		for (StackTraceElement s : e.getStackTrace()) {
			log(s, id + i);
			i++;
		}
		
		System.out.println("Error logged as " + id + ".");
	}
	
	private void log(StackTraceElement s, int id) {
		getConfig().set(id + "", s.toString());
		configs.saveFile("errors");
	}
	
	public static Errors getInstance() {
		return new Errors(ConfigFiles.getInstance());
	}

}

package com.codebeasts.minigamecore.commands;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.codebeasts.minigamecore.MinigameCore;

public class Commands implements CommandExecutor {
	
	private MinigameCore plugin;
	private CoreCommand coreCommand;
	
	public Commands(MinigameCore plugin) {
		this.plugin = plugin;
		
		this.coreCommand = new CoreCommand(plugin);
	}
	
	private ArrayList<String> commands = new ArrayList<String>();
	
	public void register() {
		System.out.println("reg 1");
		/* CoreCommand */ commands.add("minigamecore"); commands.add("core");
		System.out.println("1");
		
		for (String s : commands) {
			System.out.println("reg 3 " + s);
			plugin.getCommand(s).setExecutor(this);
			System.out.println("reg 4");
		}
		System.out.println("reg 5");
	}
	
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		System.out.println("cmd 1");
		if (cmd.getName().equalsIgnoreCase("minigamecore") || cmd.getName().equalsIgnoreCase("core")) {
			System.out.println("cmd 2" + cmd.getName());
			coreCommand.execute(s, args);
			System.out.println("cmd 3");
			
			return true;
		}
		System.out.println("cmd 4");
		
		return false;
	}

}

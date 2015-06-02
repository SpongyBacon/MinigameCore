package com.codebeasts.minigamecore.commands;

import org.bukkit.command.CommandSender;

import com.codebeasts.minigamecore.MinigameCore;
import com.codebeasts.minigamecore.utils.Msg;

public class CoreCommand {
	
	private MinigameCore plugin;
	public CoreCommand(MinigameCore plugin) {
		System.out.println("cc constr 1");
		this.plugin = plugin;
		System.out.println("cc constr 2");
	}
	
	public void execute(CommandSender s, String[] args) {
		System.out.println("cc 1");
		Msg.getInstance().msg(s,
				"Running MinigameCore version " + plugin.getDescription().getVersion() + " by SpongyBacon of http://codebeasts.com"	
		);
		System.out.println("cc2");
	}

}

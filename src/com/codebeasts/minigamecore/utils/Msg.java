package com.codebeasts.minigamecore.utils;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.codebeasts.minigamecore.configs.Errors;

public class Msg {
	
	public enum Common {
		INVALID_ARGUMENTS;
	}
	
	public enum MsgType {
		GOOD, OK, BAD;
	}
	
	public String goodPrefix = ChatColor.DARK_GREEN + "[MinigameCore]";
	public String okPrefix = ChatColor.GRAY + "[MinigameCore]";
	public String badPrefix = ChatColor.DARK_RED + "[MinigameCore]";
	
	public String getMsg(Common c) {
		if (c == Common.INVALID_ARGUMENTS) {
			return "Invalid command arguments. Use /mgcore help";
		} else return null;
	}
	
	public MsgType getType(Common c) {
		if (c == Common.INVALID_ARGUMENTS) return MsgType.BAD;
		else return MsgType.OK;
	}
	
	public String getPrefix(MsgType t) {
		if (t == MsgType.GOOD) return goodPrefix;
		else if (t == MsgType.OK) return okPrefix;
		else if (t == MsgType.BAD) return badPrefix;
		else return okPrefix;
	}
	
	public ChatColor getColor(MsgType t) {
		if (t == MsgType.GOOD) return ChatColor.GREEN;
		else if (t == MsgType.OK) return ChatColor.WHITE;
		else if (t == MsgType.BAD) return ChatColor.RED;
		else return ChatColor.WHITE;
	}
	
	public void msg(Player p, Common c) {
		try {
			MsgType type = getType(c);
			
			p.sendMessage(getPrefix(type) + ChatColor.RESET + " " 
			+ getColor(type) + "" + getMsg(c));
		} catch (Exception e) {
			Errors.getInstance().report(e);
		}
	}
	
	public void msg(CommandSender s, Common c) {
		try {
			MsgType type = getType(c);
			
			s.sendMessage(getPrefix(type) + ChatColor.RESET + " " 
			+ getColor(type) + "" + getMsg(c));
		} catch (Exception e) {
			Errors.getInstance().report(e);
		}
	}
	
	public void msg(Player p, String msg) {
		try {
			p.sendMessage(getPrefix(null) + ChatColor.RESET + " " + msg);
		} catch (Exception e) {
			Errors.getInstance().report(e);
		}
	}
	
	public void msg(CommandSender s, String msg) {
		try {
			s.sendMessage(getPrefix(null) + ChatColor.RESET + " " + msg);
		} catch (Exception e) {
			Errors.getInstance().report(e);
		}
	}
	
	public static Msg getInstance() {
		return new Msg();
	}

}

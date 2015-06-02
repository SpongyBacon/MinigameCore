package com.codebeasts.minigamecore.apis;

import org.bukkit.util.CachedServerIcon;

import com.skionz.pingapi.PingReply;

public class ServerList {
	
	//private MinigameCore plugin;
	private Ping ping;
	
	private String motd, stringPlayerCount;
	private int integerPlayerCount, maxPlayerCount;
	private CachedServerIcon icon;
	
	public ServerList(/*MinigameCore plugin, */Ping ping) {
		//this.plugin = plugin;
		this.ping = ping;
	}
	
	private void update() {
		ping.setRunnable(new Runnable() {
			public void run() {
				PingReply reply = ping.getPingEvent().getReply();
				
				if (motd != null) reply.setMOTD(motd);
				
				if (maxPlayerCount != -1) reply.setMaxPlayers(maxPlayerCount);
				if (integerPlayerCount != -1) reply.setOnlinePlayers(integerPlayerCount);
				
				if (stringPlayerCount != null) {
					reply.setProtocolVersion(-1);
			        reply.setProtocolName(stringPlayerCount);
				}
				
				if (icon != null) reply.setIcon(icon);
			}
		});
	}
	
	public String getMotd() {
		this.motd = ping.getPingEvent().getReply().getMOTD();
		return motd;
	}
	
	public void setMotd(String motd) {
		this.motd = motd;
		update();
	}
	
	public int getPlayerCount() {
		try {
			this.integerPlayerCount = ping.getPingEvent().getReply().getOnlinePlayers();
			return integerPlayerCount;
		} catch (Exception e) { return -1; }
	}
	
	public void setPlayerCount(int i) {
		this.integerPlayerCount = i;
		this.stringPlayerCount = null;
		update();
	}

	public void setPlayerCount(String s) {
		this.stringPlayerCount = s;
		this.integerPlayerCount = -1;
		update();
	}
	
	public int getMaxPlayerCount() {
		this.maxPlayerCount = ping.getPingEvent().getReply().getOnlinePlayers();
		return maxPlayerCount;
	}
	
	public void setMaxPlayerCount(int i) {
		this.maxPlayerCount = i;
		update();
	}
	
	public CachedServerIcon getIcon() {
		this.icon = ping.getPingEvent().getReply().getIcon();
		return icon;
	}
	
	public void setIcon(CachedServerIcon icon) {
		this.icon = icon;
		update();
	}
	
	// TODO animations.
	
}

package com.codebeasts.minigamecore.utils;

import com.codebeasts.minigamecore.MinigameCore;

public class Scheduler {
	
	/*
	
	String id = 0;
	SchedType type = SchedType.<>;
	long singleDelay = 0;
	long delayA = 0;
	long delayB = 0;
	long startingTime = System.currentTimeMillis();
	
	Scheduler s = new Scheduler(plugin, id, type, singleDelay, delayA, delayB, startingTime);
	
	 */
	
	// plugin, id, SchedType, Runnable, singleDelay, delayA, delayB, startingTime
	
	private MinigameCore plugin;
	
	private int id;
	private SchedType t;
	private Runnable r;
	
	private long singleDelay, delayA, delayB, startingTime, currentTime;
	
	public Scheduler(MinigameCore plugin, int id, SchedType t, Runnable r, long singleDelay, long delayA, long delayB, long startingTime) {
		this.plugin = plugin;
		
		this.id = id;		
		this.t = t;
		this.r = r;
		
		this.singleDelay = singleDelay;
		this.delayA = delayA;
		this.delayB = delayB;
		this.startingTime = startingTime;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int newId) {
		this.id = newId;
	}
	
	public SchedType getType() {
		return t;
	}
	
	public void setType(SchedType newType) {
		this.t = newType;
	}
	
	public Runnable getRunnable() {
		return r;
	}
	
	public void setRunnable(Runnable run) {
		this.r = run;
	}
	
	public long getSingleDelay() {
		return singleDelay;
	}
	
	public void setSingleDelay(long newSingleDelay) {
		this.singleDelay = newSingleDelay;
	}
	
	public long getDelayA() {
		return delayA;
	}
	
	public void setDelayA(long newDelayA) {
		this.delayA = newDelayA;
	}
	
	public long getDelayB() {
		return delayB;
	}
	
	public void setDelayB(long newDelayB) {
		this.delayB = newDelayB;
	}
	
	public long getStartingTime() {
		return startingTime;
	}
	
	public void setStartingTime(long newStartingTime) {
		this.startingTime = newStartingTime;
	}
	
	public long getCurrentTime() {
		return currentTime;
	}
	
	public void setCurrentTime(long newCurrentTime) {
		this.currentTime = newCurrentTime;
	}
	
	public void start() {
		if (t == SchedType.SINGLE) {
			id = plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, r, singleDelay);
		}
		
		if (t == SchedType.REPEATING) {
			id = plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, r, delayA, delayB);
		}
		
		if (t == SchedType.COUNTDOWN) {
			long delay1 = 1;
			long delay2 = 1;
			
			if (delayA != 1) { delay1 = delayA; }
			if (delayB != 1) { delay2 = delayB; }
			
			id = plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
				public void run() {
					currentTime = System.currentTimeMillis() - startingTime;
					r.run();
				}
			}, delay1, delay2);
		}
	}
	
	public void stop() {
		plugin.getServer().getScheduler().cancelTask(id);
	}

}

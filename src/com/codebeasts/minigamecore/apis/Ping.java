package com.codebeasts.minigamecore.apis;

import com.skionz.pingapi.PingAPI;
import com.skionz.pingapi.PingEvent;
import com.skionz.pingapi.PingListener;

public class Ping implements PingListener {
	
	public Ping() {
		
	}
	
	public void setup() {
		// TODO
	}
	
	private PingEvent pingEvent;
	private Runnable r;
	
	public PingEvent getPingEvent() {
		return this.pingEvent;
	}
	
	public void setPingEvent(PingEvent event) {
		this.pingEvent = event;
	}
	
	public Runnable getRunnable() {
		return this.r;
	}
	
	public void setRunnable(Runnable runnable) {
		this.r = runnable;
	}
	
	public void registerPingAPI() {
		PingAPI.registerListener(this);
	}
	
	@Override
	public void onPing(final PingEvent e) {
		setPingEvent(e);
		r.run();
	}

}

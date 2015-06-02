package com.codebeasts.minigamecore.settings;

import com.codebeasts.minigamecore.configs.CoreConfig;
import com.codebeasts.minigamecore.configs.CoreConfig.CoreSetting;

public class SettingsManager {
	
	private CoreConfig config;
	
	private static SettingsManager sm;
	
	public SettingsManager(CoreConfig config) {
		this.config = config;
		
		sm = this;
	}
	
	public boolean getSetting(CoreSetting s) {
		return config.getSetting(s);
	}
	
	public static SettingsManager getInstance() {
		return sm;
	}

}

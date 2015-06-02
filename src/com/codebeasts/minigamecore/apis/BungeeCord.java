package com.codebeasts.minigamecore.apis;

import com.codebeasts.minigamecore.configs.CoreConfig.CoreSetting;
import com.codebeasts.minigamecore.settings.SettingsManager;

public class BungeeCord {
	
	public BungeeCord() {
		// if not using BungeeCord, return
		if (!(SettingsManager.getInstance().getSetting(CoreSetting.USE_BUNGEECORD))) {
			System.out.println("The MinigameCore BungeeCord API constructor was called, yet bungeecord is disabled in the main MinigameCore config!");
			return;
		}
	}

}

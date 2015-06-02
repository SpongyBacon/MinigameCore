package com.codebeasts.minigamecore.apis;

import com.codebeasts.minigamecore.MinigameCore;
import com.codebeasts.minigamecore.configs.CoreConfig.CoreSetting;
import com.codebeasts.minigamecore.settings.SettingsManager;
import com.dsh105.echopet.api.EchoPetAPI;

public class EchoPet {
	
	public static EchoPetAPI pets;
	
	private MinigameCore plugin;
	public EchoPet(MinigameCore plugin) {
		// if not using EchoPet, return
		/*if (!(SettingsManager.getInstance().getSetting(CoreSetting.USE_ECHOPET))) {
			System.out.println("The MinigameCore EchoPet API constructor was called, yet echopet is disabled in the main MinigameCore config!");
			return;
		}*/
		
		this.plugin = plugin;
	}
	
	public boolean setup() {
		if (plugin.getServer().getPluginManager().getPlugin("EchoPet") == null) {
			return false;
		}
		
		pets = EchoPetAPI.getAPI();
		
		return pets != null;
	}

}

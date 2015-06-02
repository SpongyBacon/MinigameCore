package com.codebeasts.minigamecore.apis;

import org.bukkit.entity.Player;

import com.codebeasts.minigamecore.configs.CoreConfig.CoreSetting;
import com.codebeasts.minigamecore.settings.SettingsManager;
import com.dsh105.echopet.api.EchoPetAPI;
import com.dsh105.echopet.compat.api.entity.IPet;
import com.dsh105.echopet.compat.api.entity.PetType;

public class Pets {
	
	private EchoPetAPI pets = EchoPet.pets;
	
	public Pets() {
		// if not using EchoPet, return
		/*if (!(SettingsManager.getInstance().getSetting(CoreSetting.USE_ECHOPET))) {
			System.out.println("The MinigameCore Pet API constructor was called, yet echopet is disabled in the main MinigameCore config!");
			return;
		}*/
	}
	
	// TODO bungeecord?
	
	public enum CorePetType {
		COW;
	}
	
	public IPet getPet(Player p) {
		return pets.getPet(p);
	}
	
	public void setPet(Player p, CorePetType type) {
		PetType eType = null;
		if (type == CorePetType.COW) eType = PetType.COW;
		
		pets.givePet(p, eType, false).setPetName(p.getName() + "'s pet " + eType.name().toLowerCase());
		// I think false means don't send message
	}
	
	public void removePet(Player p) {
		pets.removePet(p, false, true);
		// 2nd arg = send message. 3rd arg = save.
	}

}

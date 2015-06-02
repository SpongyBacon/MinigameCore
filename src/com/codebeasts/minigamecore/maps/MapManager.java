package com.codebeasts.minigamecore.maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import com.codebeasts.minigamecore.arena.Arena;

public class MapManager {
	
	public MapManager() {
		
	}
	
	private HashMap<Map, Arena> arenaMaps = new HashMap<Map, Arena>();
	private	HashMap<Arena, Map> lastMap = new HashMap<Arena, Map>();
	
	private ArrayList<Map> maps = new ArrayList<Map>();
	
	public Map getMap(String id) {
		for (Map m : maps) {
			if (id.equalsIgnoreCase(m.getId())) {
				return m;
			}
		}
		
		return null;
	}
	
	public void addMap(Map m) {
		arenaMaps.put(m, m.getAssignedArena());
		maps.add(m);
	}
	
	public void addLastMap(Arena a, Map m) {
		if (lastMap.containsKey(a)) {
			lastMap.remove(a);
		}
		
		lastMap.put(a, m);
	}
	
	public Map findMap(Arena a) {
		Random r = new Random();
		boolean rb = r.nextBoolean();
		int ri = r.nextInt(arenaMaps.size());
		
		for (Map m : arenaMaps.keySet()) {
			if (m.getAssignedArena() == a) {
				if (!(lastMap.containsValue(m))) {
					if (rb) {
						return m;
					}
				}
			}
		}
		
		for (Map m : maps) {
			if (m.getAssignedArena() == a) {
				if (m == maps.get(ri)) {
					return m;
				}
			}
		}
		
		for (Map m : arenaMaps.keySet()) {
			if (m.getId().equalsIgnoreCase(a.getId())) {
				return m;
			}
		}
		
		return null;
	}

}

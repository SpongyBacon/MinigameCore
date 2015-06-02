package com.codebeasts.minigamecore.arena.types;

public enum ArenaType {
	
	// PRIMARY
	ROTATION, ROUND_BY_ROUND, SINGLE,
	
	/*
	 * ROTATION     |  ROUND_BY_ROUND  | Single      |
	 * -----------------------------------------------
	 * Map rotates  | Game stats are   | Game stops  |
	 * every x      | carried forward  | after one   |
	 * rounds.      | each round.      | round.      |
	 */
	
	// SECONDARY
	TDM, FFA, CTF, CTO, KOTH, DTO;
	
	/*
	 * TDM = Team Death Match
	 * FFA = Free For All
	 * CTF = Capture The Flag
	 * CTO = Capture THe Objective
	 * KOTH = King Of The Hill
	 * DTO = Destroy The Objective
	 */

}

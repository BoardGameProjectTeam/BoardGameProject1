package com.boardgame.game.PlayerClasses;

import com.boardgame.game.BoardClasses.BoardSpace;

public class Ranger extends Character {

	public Ranger(String name, BoardSpace spaceOn) {
		super(name, spaceOn);
		stats = new CharacterStats(20, 15, 2, 1);
		//use archer sprite?

	}

}

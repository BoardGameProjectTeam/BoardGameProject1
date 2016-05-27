package com.boardgame.game.PlayerClasses;

import com.boardgame.game.BoardClasses.BoardSpace;
import com.boardgame.game.sprites.PlayerSprite;

public class Ranger extends Character {

	public Ranger(String name, BoardSpace spaceOn) {
		super(name, spaceOn);
		stats = new CharacterStats(20, 15, 2, 1,3);
		//use archer sprite?
		player = new PlayerSprite(3);
	}

}

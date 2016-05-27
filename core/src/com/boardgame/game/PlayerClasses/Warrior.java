package com.boardgame.game.PlayerClasses;

import com.boardgame.game.BoardClasses.BoardSpace;
import com.boardgame.game.sprites.PlayerSprite;

public class Warrior extends Character {

	public Warrior(String name, BoardSpace spaceOn) {
		super(name, spaceOn);
		stats = new CharacterStats(30, 5, 3, 2,4);
		playerSprite = new PlayerSprite();
	}

}

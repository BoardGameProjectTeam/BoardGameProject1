package com.boardgame.game.PlayerClasses;

import com.boardgame.game.BoardClasses.BoardSpace;
import com.boardgame.game.sprites.PlayerSprite;

public class Mage extends Character {

	public Mage(String name, BoardSpace spaceOn) {
		super(name, spaceOn);
		stats = new CharacterStats(10, 30, 3, 0, 3);
		playerSprite = new PlayerSprite(2);
	}



}

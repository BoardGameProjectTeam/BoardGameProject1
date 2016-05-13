package com.boardgame.game.CardClasses;

import com.boardgame.game.sprites.CardSprite;
import com.boardgame.game.sprites.SlashCardSprite;

public class Card {


	private String name;
	private CardSprite cardSprite;

	public Card(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Card dupe(){
		Card c = new Card(name);
		return c;
	}

}

package com.boardgame.game.CardClasses;

public class Card {


	private String name;
	
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

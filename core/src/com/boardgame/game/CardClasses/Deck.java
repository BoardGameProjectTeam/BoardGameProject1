package com.boardgame.game.CardClasses;

import java.util.ArrayList;

public class Deck {

	ArrayList<com.boardgame.game.CardClasses.Card> cards = new ArrayList<com.boardgame.game.CardClasses.Card>();
	
	public Deck(){
		
	}
	public void addCard(com.boardgame.game.CardClasses.Card c){
		cards.add(c);
	}
	public Deck(ArrayList<com.boardgame.game.CardClasses.Card> card){
		cards = card;
	}
	
	public com.boardgame.game.CardClasses.Card draw(){
		com.boardgame.game.CardClasses.Card c = cards.get(0).dupe();
		cards.remove(0);
		return c;
	}
	public void shuffle(){
		//need to do
	}
	public com.boardgame.game.CardClasses.Card selectCard(int i){
		if(i < cards.size())
		{
			return cards.get(i);
		}
		return null;
	}
	public void printdeck(){
		for(int i =0; i < cards.size();i++){
			System.out.println(cards.get(i).getName());
		}
	}
}

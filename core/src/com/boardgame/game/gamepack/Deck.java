package com.boardgame.game.gamepack;

import java.util.ArrayList;

public class Deck {

	ArrayList<Card> cards = new ArrayList<Card>();
	
	public Deck(){
		
	}
	public void addCard(Card c){
		cards.add(c);
	}
	public Deck(ArrayList<Card> card){
		cards = card;
	}
	
	public Card draw(){
		Card c = cards.get(0).dupe();
		cards.remove(0);
		return c;
	}
	public void shuffle(){
		//need to do
	}
	public Card selectCard(int i){
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

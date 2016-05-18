package com.boardgame.game.CardClasses;

import java.util.ArrayList;

/**
 * This class represents the players hand of cards, or array of cards.
 *
 * Created by Cliff on 5/11/2016.
 */
public class CardHand {
    private ArrayList<Card> cards;
    public CardHand(){
        cards = new ArrayList<Card>();
    }
    public CardHand(ArrayList<Card> cards){
        this.cards = cards;
    }
    public void addCard(Card card){
        cards.add(card);
    }
    public void removeCard(Card card){
        cards.remove(card);
    }
    public Card getCard(int i){
        return cards.get(i);
    }
    public int findCard(Card card){
        return cards.indexOf(card);
    }
    public int handSize(){
        return cards.size();
    }
    public ArrayList<Card> getCards(){
        return cards;
    }

}

package com.boardgame.game.PlayerClasses;

import com.boardgame.game.CardClasses.Card;
import com.boardgame.game.CardClasses.CardHand;
import com.boardgame.game.CardClasses.Deck;

import java.util.ArrayList;

/**
 * This class represents the actual player who makes decisions for all the characters they control
 *
 * Created by Cliff on 5/11/2016.
 */
public class MainPlayer {
    private ArrayList<Character> characters;
    private CardHand hand;
    private Deck deck;
    private Deck discardPile;
    public MainPlayer(){
        deck = new Deck();
        discardPile = new Deck();
        hand = new CardHand();
        characters = new ArrayList<Character>();
    }
    public MainPlayer(ArrayList<Card> cards, ArrayList<Character> characters){
        hand = new CardHand(cards);
        this.characters = characters;
        deck = new Deck();
    }
    public void drawCard(int position){
        try {
            hand.addCard(deck.draw(position));
        }catch (Exception e){
            System.out.println("No more cards");
        }
    }
    public CardHand getHand(){
        return hand;
    }
    public Deck getDeck(){
        return deck;
    }
    public void UseCard(Card card){

    }





}

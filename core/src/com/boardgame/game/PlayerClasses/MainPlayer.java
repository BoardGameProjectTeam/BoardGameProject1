package com.boardgame.game.PlayerClasses;

import com.boardgame.game.CardClasses.Card;
import com.boardgame.game.CardClasses.CardHand;

import java.util.ArrayList;

/**
 * This class represents the actual player who makes decisions for all the characters they control
 *
 * Created by Cliff on 5/11/2016.
 */
public class MainPlayer {
    private ArrayList<Character> characters;
    private CardHand hand;

    public MainPlayer(){
        hand = new CardHand();
        characters = new ArrayList<Character>();
    }
    public MainPlayer(ArrayList<Card> cards, ArrayList<Character> characters){
        hand = new CardHand(cards);
    }
    public CardHand getHand(){
        return hand;
    }




}
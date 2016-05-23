package com.boardgame.game.ModelClasses;

import com.boardgame.game.BoardClasses.MainBoard;
import com.boardgame.game.CardClasses.SlashCard;
import com.boardgame.game.Controllers.PlayController;
import com.boardgame.game.PlayerClasses.Character;
import com.boardgame.game.PlayerClasses.Mage;
import com.boardgame.game.PlayerClasses.MainPlayer;
import com.boardgame.game.states.PlayScreen;

import java.util.ArrayList;

/**
 * Created by Cliff on 5/23/2016.
 */
public class PlayModel {
    private PlayScreen playScreen;
    private PlayController playController;

    private MainBoard mainBoard;
    private MainPlayer p1;
    private MainPlayer p2;
    private MainPlayer activePlayer;

    //    private PlayerSprite player;
    private Character activeChar;
    //    private Character passiveChar; //testing
    private ArrayList<Character> characters;

    private int boardOffsetX;
    private int boardOffsetY;

    private int numberOfCards = 20; //this is used for testing , its used for how many cards that are generated.
    private int panelSize= 35;
    private int handY = 300;

    public PlayModel(PlayScreen playScreen) {
        this.playScreen=playScreen;


        mainBoard = new MainBoard(7,7);
        p1 = new MainPlayer();
        p2 = new MainPlayer();
        activePlayer = p1;

        //setup player 1
        for(int i = 0; i<numberOfCards;i++) {
            p1.getDeck().addCard(new SlashCard(i*35,handY));
        }
        p1.drawCard(0);
        p1.drawCard(1);


        characters = new ArrayList<Character>();
        characters.add(new Mage("Mage", mainBoard.getSpaceAt(0,0)));   //uses mage stats
        characters.add(new Character(mainBoard.getSpaceAt(1,1),2));
        characters.add(new Character(mainBoard.getSpaceAt(1,2),3));

        activeChar = characters.get(0);

        for(int i = 0; i < characters.size();i++){
            mainBoard.addPlayer(characters.get(i));
        }
    }
    public MainBoard getMainBoard(){
        return mainBoard;
    }
    public int getBoardOffsetX(){
        return boardOffsetX;
    }
    public int getBoardOffsetY(){
        return boardOffsetY;
    }
    public int getHandY(){return handY;}
    public MainPlayer getActivePlayer(){
        return activePlayer;
    }
    public Character getActiveChar(){
        return activeChar;
    }
    public void switchChar(){
        int index;
        index = characters.indexOf(activeChar);
        index ++;
        if(index>=characters.size()){
            index = 0;
        }
        activeChar = characters.get(index);
    }
    public void draw(){
        p1.drawCard(p1.getHand().getCards().size());
    }

    public ArrayList getCharacters(){
        return characters;
    }
    public void switchActiveChar(Character character){
        activeChar = character;
    }









}


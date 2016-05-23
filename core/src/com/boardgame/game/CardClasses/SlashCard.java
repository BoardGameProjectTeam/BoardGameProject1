package com.boardgame.game.CardClasses;

import com.boardgame.game.Attacks.Attack;
import com.boardgame.game.Attacks.Slash;
import com.boardgame.game.BoardClasses.BoardSpace;
import com.boardgame.game.BoardClasses.MainBoard;
import com.boardgame.game.PlayerClasses.Character;

import java.util.ArrayList;

/**
 * Created by Cliff on 5/12/2016.
 */
public class SlashCard extends Card {

    public SlashCard(int x, int y) {
        super("slashCard_Small.png", x, y);
    }

    public Attack attack(MainBoard mainBoard, Character user, Character target, BoardSpace targetSpace, ArrayList<BoardSpace> targetSpaces, char direction){
        attack=new Slash(user,targetSpace);
        return attack;
    }


}

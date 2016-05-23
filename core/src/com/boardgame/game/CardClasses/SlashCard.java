package com.boardgame.game.CardClasses;

import com.boardgame.game.Attacks.Attack;
import com.boardgame.game.Attacks.SingleAreaAttack;
import com.boardgame.game.Attacks.Slash;
import com.boardgame.game.BoardClasses.BoardSpace;
import com.boardgame.game.BoardClasses.MainBoard;
import com.boardgame.game.PlayerClasses.Character;

import java.util.ArrayList;

/**
 * Created by Cliff on 5/12/2016.
 */
public class SlashCard extends SingleAreaCard {

    public SlashCard(int x, int y) {
        super("slashCard_Small.png", x, y);
        setName("Slash");
        cardType = 0;
        attackType = 1;

    }

    //get attac

    public SingleAreaAttack attack(Character user, BoardSpace targetSpace){
        return new Slash(user,targetSpace);
    }


}

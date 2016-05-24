package com.boardgame.game.Attacks;

import com.boardgame.game.BoardClasses.BoardSpace;
import com.boardgame.game.PlayerClasses.Character;
import com.boardgame.game.states.PlayScreen;

/**
 * These attacks are for when the attack covers an area
 * Created by Cliff on 5/23/2016.
 */
public  class SingleAreaAttack extends Attack{
    protected Character user;
    protected BoardSpace targetSpace;
    public SingleAreaAttack(Character user, BoardSpace targetSpace){
        this.user = user;
        this.targetSpace = targetSpace;
    }
    public void performAction(PlayScreen playScreen){
        System.out.println("got to action");


    }

}

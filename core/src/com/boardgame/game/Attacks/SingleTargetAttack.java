package com.boardgame.game.Attacks;

import com.boardgame.game.PlayerClasses.Character;
import com.boardgame.game.states.PlayScreen;

/**
 * These are for attacks that specify a single character as its target
 * Created by Cliff on 5/23/2016.
 */
public class SingleTargetAttack extends Attack{

    protected Character target;
    public SingleTargetAttack(Character user, Character target){
        this.user = user;
        this.target = target;
    }
    public void performAction(PlayScreen playScreen){

    }

}

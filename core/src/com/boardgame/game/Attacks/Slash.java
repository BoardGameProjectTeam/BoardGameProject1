package com.boardgame.game.Attacks;

import com.boardgame.game.BoardClasses.BoardObject;
import com.boardgame.game.BoardClasses.BoardSpace;
import com.boardgame.game.BoardClasses.MainBoard;
import com.boardgame.game.PlayerClasses.Character;

/**
 * Basic slash attack, Melee covers one space in front
 * Created by Cliff on 5/16/2016.
 */
public class Slash extends Attack {

    public Slash(Character user, BoardSpace targetSpace) {
        super(user, targetSpace);
        power = 5;
    }
    public void performAction(){
        try {
            if(targetSpace.hasObject()){
                BoardObject theTarget = targetSpace.getObject();
                theTarget.takeDamage(power);
            }
            //need to finish
        }catch (Exception e){
            System.out.println("target error");
        }
    }
}

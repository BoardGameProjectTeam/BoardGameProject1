package com.boardgame.game.Attacks;

import com.boardgame.game.Animations.SlashAnimation;
import com.boardgame.game.BoardClasses.BoardObject;
import com.boardgame.game.BoardClasses.BoardSpace;
import com.boardgame.game.BoardClasses.MainBoard;
import com.boardgame.game.PlayerClasses.Character;
import com.boardgame.game.states.PlayScreen;

/**
 * Basic slash attack, Melee covers one space in front
 * Created by Cliff on 5/16/2016.
 */
public class Slash extends SingleAreaAttack {

    public Slash(Character user, BoardSpace targetSpace) {
        super(user, targetSpace);
        setPower(5);
    }
    public void performAction(PlayScreen playScreen){
        try {
            if(targetSpace.hasObject()){
                BoardObject theTarget = targetSpace.getObject();
                theTarget.takeDamage(power);
            }
            playScreen.addAnimation(new SlashAnimation(targetSpace.getX(),targetSpace.getY()));
            System.out.println("used slash");
            //need to finish
        }catch (Exception e){
            System.out.println("target error");
        }
    }
}

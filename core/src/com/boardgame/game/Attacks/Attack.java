package com.boardgame.game.Attacks;

import com.boardgame.game.BoardClasses.BoardObject;
import com.boardgame.game.BoardClasses.BoardSpace;
import com.boardgame.game.BoardClasses.MainBoard;
import com.boardgame.game.PlayerClasses.Character;
import com.boardgame.game.states.PlayScreen;

import java.util.ArrayList;

/**
 * Created by Cliff on 5/16/2016.
 */
public abstract class Attack {
    protected MainBoard mainBoard;
    protected Character user;
    protected Character singleTarget;
    protected BoardSpace targetSpace;
    protected ArrayList<BoardSpace> targetSpaces;
    protected ArrayList<Character> targets;
    protected char direction;
    protected int power;

    public Attack(){

    }

    //single target
    public Attack(Character user,Character target){
        this.user = user;
        singleTarget = target;
    }
    // for targeting multiple players
    public Attack(Character user, ArrayList<Character> targets){
        this.user = user;
        this.targets = targets;
    }
    //for targeting an area, Direction uses N S E W for directions, or U D L R
    public Attack(MainBoard mainBoard, Character user,char direction){
        this.mainBoard = mainBoard;
        this.user = user;
        this.direction = direction;
    }
    //for targeting one space
    public Attack(Character user, BoardSpace targetSpace){
        this.user = user;
        this.targetSpace = targetSpace;
    }

    public void setPower(int i){
        power = i;
    }

    public abstract void performAction(PlayScreen playScreen);


}

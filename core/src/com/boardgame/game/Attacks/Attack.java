package com.boardgame.game.Attacks;

import com.boardgame.game.BoardClasses.MainBoard;
import com.boardgame.game.PlayerClasses.Character;

import java.util.ArrayList;

/**
 * Created by Cliff on 5/16/2016.
 */
public abstract class Attack {
    private MainBoard mainBoard;
    private Character user;
    private Character singleTarget;
    private ArrayList<Character> targets;

    public Attack(MainBoard mainBoard,Character user,Character target){
        this.mainBoard = mainBoard;
        this.user = user;
        singleTarget = target;
    }
    public Attack(MainBoard mainBoard, Character user, ArrayList<Character> targets){
        this.mainBoard = mainBoard;
        this.user = user;
        this.targets = targets;
    }

}

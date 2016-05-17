package com.boardgame.game.Attacks;

import com.boardgame.game.BoardClasses.MainBoard;
import com.boardgame.game.PlayerClasses.Character;

/**
 * Basic slash attack, Melee covers one space in front
 * Created by Cliff on 5/16/2016.
 */
public class Slash extends Attack {

    public Slash(MainBoard mainBoard, Character user, Character target) {
        super(mainBoard, user, target);
    }
}

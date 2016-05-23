package com.boardgame.game.CardClasses;

import com.boardgame.game.Attacks.Attack;
import com.boardgame.game.BoardClasses.BoardSpace;
import com.boardgame.game.PlayerClasses.Character;

/**
 * Created by Cliff on 5/23/2016.
 */
public abstract class SingleAreaCard extends Card{
    public SingleAreaCard(String fileName,int x, int y){
        super(fileName,x,y);
    }
    public abstract Attack attack(Character user, BoardSpace boardSpace);
}

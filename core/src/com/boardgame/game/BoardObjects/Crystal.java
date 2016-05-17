package com.boardgame.game.BoardObjects;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Cliff on 5/17/2016.
 */
public class Crystal {
    private Texture crystal;
    private int x;
    private int y;
    public Crystal(int x, int y){
        this.x = x;
        this.y = y;
        crystal = new Texture("crystal.jpg");
    }
    public void dispose(){
        crystal.dispose();
    }

}

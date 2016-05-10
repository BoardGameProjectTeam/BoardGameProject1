package com.boardgame.game.sprites;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Cliff on 5/8/2016.
 */

public class SingleTile {
    private Texture tile;
    private int type;
    public SingleTile(int type){
        this.type = type;
        switch(type){
            case 0:
                //normal tile
                tile = new Texture("normal.png");
                this.type = type;
                break;
            default:
                //not imported tile, so use default normal.
                tile = new Texture("normal.png");

                break;
        }
    }
    public Texture getTile(){
        return tile;
    }
    public int getType(){
        return type;
    }

}

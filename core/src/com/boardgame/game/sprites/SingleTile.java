package com.boardgame.game.sprites;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Cliff on 5/8/2016.
 */

public class SingleTile {
    private Texture tile;
    private int type;
    private int width;
    private int height;

    public SingleTile(int type){
        this.type = type;
        switch(type){
            case 0:
                //normal tile
//                tile = new Texture("normal_small.png");
                tile = new Texture("first_tile-30x30.png");
                this.type = type;
                width = tile.getWidth();
                height = tile.getHeight();
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
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }

}

package com.boardgame.game.sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Cliff on 5/8/2016.
 */
public class Tile {
    private TextureRegion tile;
    private TileMap map;
    private int type;
    public Tile(int type){
        map = new TileMap();
        this.type = type;
        switch(type){
//            case 0:
                //normal tile
//                break;
            default:
                //un imported tile
                tile = new TextureRegion(map.getTile(9,0));
                break;
        }
    }
    public TextureRegion getTile(){
        return tile;
    }


}

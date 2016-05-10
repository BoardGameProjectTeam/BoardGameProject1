package com.boardgame.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * This class is only useful for the sprite sheet used in the class currently
 * in order to get a single tile off the sheet, use getTile().
 * Created by Cliff on 5/7/2016.
 */
public class TileMap extends SpriteSheet{
    private Texture map;
    private int mapH;
    private int mapW;

    public TileMap(){
        map = new Texture("tiles_spritesheet.png");
        mapH = 72;
        mapW =72; //for tile sprite sheet
    }
    public TextureRegion getTile(int x,int y){
        return new TextureRegion(map,x*mapW,y*mapH,mapW,mapH);
    }



}

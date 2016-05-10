package com.boardgame.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Cliff on 5/8/2016.
 */
public abstract class SpriteSheet {
    private Texture map;
    private int mapH;
    private int mapW;

    public SpriteSheet(String filename,int width, int height){
        map = new Texture(filename);
        mapH =width;
        mapW =height; //for tile sprite sheet
    }
    public SpriteSheet(String filename, int size, boolean widthOnly){
        map = new Texture(filename);
        if(widthOnly){
            mapW =size;
        }else
        {
            mapH = size;
        }
    }
    public SpriteSheet(){

    }

    public TextureRegion getTile(int x, int y){

        return new TextureRegion(map,x*mapW,y*mapH,mapW,mapH);
    }
}

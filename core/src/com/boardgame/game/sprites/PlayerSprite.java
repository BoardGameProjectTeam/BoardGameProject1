package com.boardgame.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Cliff on 5/8/2016.
 */
public class PlayerSprite {

    private Texture spriteSheet;
    private TextureRegion tile;
    int width;
    int height;

    public PlayerSprite(){
        spriteSheet = new Texture("Samurai.png");
                tile = new TextureRegion(spriteSheet);
        width = 42;
        height = 31;
        }
    public TextureRegion getTile(){
            return tile;
        }



}

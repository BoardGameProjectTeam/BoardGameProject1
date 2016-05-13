package com.boardgame.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Cliff on 5/8/2016.
 */
public class PlayerSprite {

    private Texture spriteSheet;
    private TextureRegion tile;
    private String filename;
    int x;
    int y;
    int width;
    int height;

    public PlayerSprite(){
        spriteSheet = new Texture("Samurai.png");
        x = 1;
        y = 1;
        width = 40;
        height = 29;
        tile = new TextureRegion(spriteSheet, x, y, width, height);
        }

    //testing multiple sprite sheets
    public PlayerSprite(int numChar)
    {
            switch (numChar) {
                case 1:
                    filename = "Samurai.png";
                    break;
                case 2:
                    filename = "Ninja.png";
                    break;
                case 3:
                    filename = "Archer.png";
                    break;
            }
            spriteSheet = new Texture(filename);
            x = 1;
            y = 1;
            width = 40;
            height = 29;
            tile = new TextureRegion(spriteSheet, x, y, width, height);
    }
    public TextureRegion getTile(){
            return tile;
        }



}

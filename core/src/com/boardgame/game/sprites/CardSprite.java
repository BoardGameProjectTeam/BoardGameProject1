package com.boardgame.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by Cliff on 5/12/2016.
 */
public abstract class CardSprite {
    private Texture card;
    private Sprite sprite;
    private int width;
    private int height;

    public CardSprite(String filename,int width, int height) {
        card = new Texture(filename);
        sprite = new Sprite(card);
        this.width = width;
        this.height = height;
    }
    public Sprite getSprite(){
        return sprite;
    }
    public Texture getCardTexture(){
        return card;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

}

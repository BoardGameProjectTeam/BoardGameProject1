package com.boardgame.game.sprites;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Cliff on 5/12/2016.
 */
public abstract class CardSprite {
    private Texture card;

    private int width;
    private int height;

    public CardSprite(String filename,int width, int height) {
        card = new Texture(filename);
        this.width = width;
        this.height = height;
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

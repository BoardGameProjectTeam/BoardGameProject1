package com.boardgame.game.CardClasses;

import com.badlogic.gdx.graphics.Texture;
import com.boardgame.game.CardClasses.Card;
import com.boardgame.game.sprites.CardSprite;
import com.boardgame.game.sprites.SlashCardSprite;

/**
 * Created by Cliff on 5/12/2016.
 */
public class SlashCard extends Card {

    private SlashCardSprite cardSprite;
    public SlashCard() {
        super("Slash");
        setCardSprite("slashCard.png",70,90);
    }
    public void setCardSprite(String filename,int width, int height){
        cardSprite = new SlashCardSprite(filename,width,height);
    }
    public Texture getCardSprite(){
        return cardSprite.getCardTexture();
    }
}

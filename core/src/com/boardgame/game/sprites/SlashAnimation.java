package com.boardgame.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.boardgame.game.Attacks.Slash;
import com.boardgame.game.BoardClasses.BoardObject;

/**
 * Created by Cliff on 5/16/2016.
 */
public class SlashAnimation {
    private Animation slashAnimation;
//    int width = 480;
//    int height = 192;
    private Texture slash;
    private Boolean removeMe;
    public SlashAnimation(){
        slash = new Texture("slash_small.png");
        slashAnimation = new Animation(new TextureRegion(slash),5,5,.5f);
        removeMe = false;
    }
    public void update(float dt){
        slashAnimation.update(dt);
        if(slashAnimation.getCurrentFrame()>5){
            dispose();
            removeMe = true;
        }

    }
    public void dispose(){
        slash.dispose();
    }
    public boolean removeme(){
        return removeMe;
    }
}

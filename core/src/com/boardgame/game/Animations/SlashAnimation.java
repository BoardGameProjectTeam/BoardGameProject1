package com.boardgame.game.Animations;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.boardgame.game.sprites.Animation;

/**
 * Created by Cliff on 5/16/2016.
 */
public class SlashAnimation extends AttackAnimation{
    private Animation slashAnimation;
    private int width = 192;
    private int height = 192;
    private Texture slash;
    private Boolean removeMe;
    public SlashAnimation(int x, int y){
        panelSize = 35;
        slash = new Texture("slash_small.png");
        slashAnimation = new Animation(new TextureRegion(slash),5,2,.1f);
        removeMe = false;
        this.x = x* panelSize;
        this.y = y* panelSize;
    }
    public void update(float dt){

        if(slashAnimation.getCurrentFrame()>=9){
            dispose();
            removeMe = true;
        }else{
            slashAnimation.update(dt);
        }


    }

    public TextureRegion getTexture(){
        return slashAnimation.getFrame();
    }
    public void dispose(){
        slash.dispose();
    }
    public boolean removeMe(){
        return removeMe;
    }
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
    public int getPanelSize(){
        return panelSize;
    }
}
package com.boardgame.game.Animations;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.boardgame.game.sprites.MyAnimation;
import com.boardgame.game.sprites.SingleTile;

/**
 * Created by Cliff on 5/16/2016.
 */
public class SlashAnimation extends AttackAnimation{
    private MyAnimation slashAnimation;
    private int width;
    private int height;
    private Texture slash;
    private Boolean removeMe;
    public SlashAnimation(int x, int y){
        panelSize = SingleTile.PANEL_SIZE;
        slash = new Texture("Slash_small.png");
        slashAnimation = new MyAnimation(new TextureRegion(slash),5,2,.1f);
        width = slash.getWidth();
        height = slash.getHeight();
        removeMe = false;
        this.x = x* panelSize;
        this.y = y* panelSize;
    }
    public void update(float dt){

        if(slashAnimation.getCurrentFrame()>=90){
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

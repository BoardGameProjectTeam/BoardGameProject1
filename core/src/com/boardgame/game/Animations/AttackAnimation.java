package com.boardgame.game.Animations;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Cliff on 5/17/2016.
 */
public abstract class AttackAnimation {

    protected int width;
    protected int height;
    protected int panelSize;
    protected int x;
    protected int y;

    protected boolean removeMe;

    public abstract void update(float dt);
    public abstract TextureRegion getTexture();
    public abstract void dispose();
    public abstract boolean removeMe();
    public abstract int getX();
    public abstract int getY();
    public abstract int getPanelSize();


}

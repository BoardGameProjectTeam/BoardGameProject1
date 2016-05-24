package com.boardgame.game.Attacks;

import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Cliff on 5/23/2016.
 */
public abstract class Projectile {

    protected int lifeSpan;//frames on how long this will be alive
    protected int xMovement;
    protected int yMovement;


    protected Boolean removeMe;//when true, the updater should call appropriate functions to remove it and dispose()


    //this box is used mainly on checking each space it will overlap, then check if there are objects.
    protected Rectangle hitBox;//this is used when checking if any object is present within this box, if so register a hit.

    protected float currentFrameTime;
    protected float maxFrameTime;

    public Projectile(int lifeSpan, int xMovement, int yMovement){
        this.lifeSpan=lifeSpan;
        this.xMovement=xMovement;
        this.yMovement = yMovement;
        currentFrameTime = 0;
        maxFrameTime = 1;
    }
    public void update(float dt){
        currentFrameTime += dt;
        if(currentFrameTime>maxFrameTime){
            lifeSpan--;
            currentFrameTime = 0;
        }

    }


}

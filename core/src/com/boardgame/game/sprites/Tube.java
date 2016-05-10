package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by Cliff on 5/3/2016.
 */
public class Tube {

    public static final int TUBE_WIDTH = 52;
    private Rectangle boundsTop, boundsBot;
    private Texture topTube,bottomTube;
    private Vector2 posTopTube, posBottomTube;
    private Random rand;

    public Tube (float x){
        topTube = new Texture("toptube.png");
        bottomTube = new Texture("bottomtube.png");
        rand = new Random();
        posTopTube = new Vector2(x,rand.nextInt(FLUCTUATION)+TUBEGAP + LOWEST_OPENING);
        posBottomTube = new Vector2(x,posTopTube.y - TUBEGAP - bottomTube.getHeight());
        boundsTop = new Rectangle(posTopTube.x, posTopTube.y, topTube.getWidth(),topTube.getHeight());
        boundsBot= new Rectangle(posBottomTube.x, posBottomTube.y,bottomTube.getWidth(),bottomTube.getHeight());
    }
    public Texture getTopTube() {
        return topTube;
    }

    public Texture getBottomTube() {
        return bottomTube;
    }

    public Vector2 getPosTopTube() {
        return posTopTube;
    }

    public Vector2 getPosBottomTube() {
        return posBottomTube;
    }

    private static final int TUBEGAP = 100;
    private static final int FLUCTUATION = 130;
    private static final int LOWEST_OPENING = 120;

    public void reposition(float x){
        posTopTube.set(x,rand.nextInt(FLUCTUATION)+TUBEGAP + LOWEST_OPENING);
        posBottomTube.set(x, posTopTube.y - TUBEGAP - bottomTube.getHeight());
        boundsTop.setPosition(posTopTube.x,posTopTube.y);
        boundsBot.setPosition(posBottomTube.x,posBottomTube.y);
    }
    public boolean collides(Rectangle player){
        return player.overlaps(boundsTop)||player.overlaps(boundsBot);
    }
    public void dispose(){
        topTube.dispose();
        bottomTube.dispose();
    }
}

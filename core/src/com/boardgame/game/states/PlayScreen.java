package com.boardgame.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.boardgame.game.BoardClasses.BoardSpace;
import com.boardgame.game.BoardClasses.MainBoard;
import com.boardgame.game.MyGdxGame;
import com.boardgame.game.sprites.TileMap;
import com.boardgame.game.states.GameStateManager;
import com.boardgame.game.states.State;

import java.util.ArrayList;

/**
 * Created by Cliff on 5/6/2016.
 */
public class PlayScreen extends State {
    private int boardOffsetX;
    private int boardOffsetY;
    private MainBoard mb;
    private ArrayList<BoardSpace> bs;
    int x=0;
    int y=0;
    public PlayScreen(GameStateManager gsm){
        super(gsm);
        bs = new ArrayList<BoardSpace>();
        mb = new MainBoard(50, 50);
        cam.setToOrtho(false, MyGdxGame.WIDTH*2-150, MyGdxGame.HEIGHT*2-150);
        boardOffsetX = 40;
        boardOffsetY = 700;
    }
    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            bs.add(new BoardSpace(x,y,mb));
            x++;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) {
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
                boardOffsetX -= 10;

            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
                boardOffsetX += 10;

            if (Gdx.input.isKeyPressed(Input.Keys.UP))
                boardOffsetY += 10;


            if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
                boardOffsetY -= 10;
            }
            System.out.println(boardOffsetX + " = X");
            System.out.println(boardOffsetY + " = Y");
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {

        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        //for loop for main board tiles

        for(int i = 0; i < mb.getXSize(); i ++){
            for(int j = 0; j < mb.getYSize(); j++){

                sb.draw(mb.getSpaceAt(i,j).getTextures() ,(i*74)+boardOffsetX,(j*74)+boardOffsetY);

            }
        }
//        if(bs.size()>0) {
        for(int i = 0; i < bs.size();i++){
            sb.draw(bs.get(i).getTextures(), i*74,0);
        }
        sb.end();
        cam.update();
    }

    @Override
    public void dispose() {

    }
}
package com.boardgame.game.Controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;
import com.boardgame.game.MyGdxGame;
import com.boardgame.game.states.PlayScreen;

/**
 * Created by Cliff on 5/13/2016.
 */
public class PlayController implements InputProcessor{
        PlayScreen ps;
    public PlayController(PlayScreen ps){
        this.ps = ps;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)) {
            if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
                ps.getMainBoard().moveObject(ps.getActiveChar(),'l');
            }

            if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
                ps.getMainBoard().moveObject(ps.getActiveChar(),'r');
            }

            if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
                ps.getMainBoard().moveObject(ps.getActiveChar(),'u');
            }

            if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
                ps.getMainBoard().moveObject(ps.getActiveChar(),'d');
            }

            if (Gdx.input.isKeyJustPressed(Input.Keys.Z)) {
                ps.switchChar();
            }
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        screenY = MyGdxGame.HEIGHT-screenY;
        try {
            System.out.println(
                    ps.getMainBoard().getSpaceAt((screenX+ps.getBoardOffsetX())/70,(screenY/70+ps.getBoardOffsetY())).getX()+
                    " "+
                    ps.getMainBoard().getSpaceAt((screenX+ps.getBoardOffsetX())/70,(screenY/70+ps.getBoardOffsetY())).getY()+
                    " "+
                    screenX+
                    " "+
                    screenY);

        }catch (Exception e){
            System.out.println("Can't find space at " + screenX+" "+screenY);
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}

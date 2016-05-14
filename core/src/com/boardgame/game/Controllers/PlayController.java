package com.boardgame.game.Controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
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
//                System.out.println(activeChar.getX()+" "+activeChar.getY());
            if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
//                    spriteOffsetX -= 36;
//                    if(spriteOffsetX < 22)
//                        spriteOffsetX += 36;
                ps.getMainBoard().moveObject(ps.getActiveChar(),'l');
            }

            if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
                //boardOffsetX += 10;
//                    spriteOffsetX += 36;
//                    if(spriteOffsetX > 346)
//                        spriteOffsetX -= 36;
                ps.getMainBoard().moveObject(ps.getActiveChar(),'r');
            }

            if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
                //boardOffsetY += 10;
//                    spriteOffsetY += 28;
//                    if(spriteOffsetY > 520)
//                        spriteOffsetY -= 28;
                ps.getMainBoard().moveObject(ps.getActiveChar(),'u');
            }

            if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
                //boardOffsetY -= 10;
//                    spriteOffsetY -= 28;
//                    if(spriteOffsetY < 268)
//                        spriteOffsetY += 28;
                ps.getMainBoard().moveObject(ps.getActiveChar(),'d');
            }

            if (Gdx.input.isKeyJustPressed(Input.Keys.Z))
            {
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

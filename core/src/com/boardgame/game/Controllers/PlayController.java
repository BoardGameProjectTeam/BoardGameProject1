package com.boardgame.game.Controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;
import com.boardgame.game.BoardClasses.BoardSpace;
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
            int xx = screenX+ps.getBoardOffsetX();
            int yy = screenY-ps.getBoardOffsetY();
//            System.out.println(screenX+ps.getBoardOffsetX()+" this is x");
//            System.out.println(screenY+ps.getBoardOffsetY()+" this is ");

//            System.out.println(
//                    ps.getMainBoard().getSpaceAt(xx/70,yy/70).getX()+
//                    " "+
//                    ps.getMainBoard().getSpaceAt(xx/70,yy/70).getY()+
//                    " "+
//                    screenX+
//                    " "+
//                    screenY);
            BoardSpace boardSpace = ps.getMainBoard().getSpaceAt(xx/70,yy/70);

            if(boardSpace.hasObject()){
               if(boardSpace.getObject().isCharacter()){
                   ps.switchActiveChar(boardSpace.getCharacter());
               }
            }else {
                ps.getMainBoard().teleportObject(ps.getActiveChar(), xx / 70, yy / 70);
            }
        }catch (NullPointerException n){
            System.out.println("null pointer exception");
        }
        catch (Exception e){
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

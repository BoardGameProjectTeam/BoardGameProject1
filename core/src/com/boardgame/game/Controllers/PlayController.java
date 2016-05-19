package com.boardgame.game.Controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;
import com.boardgame.game.Animations.SlashAnimation;
import com.boardgame.game.BoardClasses.BoardSpace;
import com.boardgame.game.CardClasses.Card;
import com.boardgame.game.CardClasses.CardHand;
import com.boardgame.game.states.PlayScreen;

/**
 * Created by Cliff on 5/13/2016.
 */
public class PlayController implements InputProcessor{
        PlayScreen ps;
        int panelSize= 35;
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
//        screenY = MyGdxGame.HEIGHT-screenY;
        Vector3 v3 = new Vector3(screenX+ps.getBoardOffsetX(),screenY+ps.getBoardOffsetY(),0);
        ps.getcam().unproject(v3);
        int xx = (int) v3.x;
        int yy = (int) v3.y;

        if(v3.y<245) {
            //playermovement
    try {

//                its set to 480, but i changed it again to 720

                System.out.println(xx + " this is x");
                System.out.println(yy + " this is y");

                xx /=panelSize;
                yy /=panelSize;
                BoardSpace boardSpace = ps.getMainBoard().getSpaceAt(xx, yy);

                if (boardSpace.hasObject()) {
                    if (boardSpace.getObject().isCharacter()) {
                        ps.switchActiveChar(boardSpace.getCharacter());
                    }
                } else {
                    ps.getMainBoard().teleportObject(ps.getActiveChar(), xx, yy);
                    ps.addAnimation(new SlashAnimation(xx,yy));
                }
            } catch (NullPointerException n) {
                System.out.println("null pointer exception");
            } catch (Exception e) {
                System.out.println("Can't find space at " + screenX + " " + screenY);
            }
        }else{
            //touching outside board
//            for (ps.:
//                 ) {
//
//            }
//            for(Card card:ps.getActivePlayer().getHand().getCards()){
                for(int i = 0; i < ps.getActivePlayer().getHand().getCards().size();i++){
                    Card card = ps.getActivePlayer().getHand().getCard(i);
                if(card.checkBounds(xx,yy)){
                    CardHand hand = ps.getActivePlayer().getHand();
                    int position = hand.getCards().indexOf(card);
                    hand.removeCard(card);
                    for(int j = position;
                        j< hand.getCards().size();
                            j++){
                        hand.getCard(j).setLocation(j*35,ps.getHandY());
                    }

                }
            }


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

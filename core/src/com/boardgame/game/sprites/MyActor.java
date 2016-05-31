package com.boardgame.game.sprites;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.sun.org.apache.xalan.internal.xsltc.runtime.output.TransletOutputHandlerFactory;

/**
 * Created by Cliff on 5/30/2016.
 */
public class MyActor extends Actor {
    private Sprite sprite;
    public MyActor(Texture texture, Boolean touchable){
        sprite = new Sprite(texture);
        setBounds(sprite.getX(),sprite.getY(),sprite.getWidth(),sprite.getHeight());
        if(touchable){
            setTouchable(Touchable.enabled);
        }

        addListener(new InputListener(){
            public boolean keyDown(InputEvent event, int keycode){
                if(keycode ==Input.Keys.RIGHT){
                    MoveByAction mba = new MoveByAction();
                    mba.setAmount(100f,0f);
                    mba.setDuration(5f);

                    MyActor.this.addAction(mba);
                }
                return true;
            }
        });
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        sprite.draw(batch);
//        super.draw(batch, parentAlpha);
    }

    @Override
    protected void positionChanged() {
        sprite.setPosition(getX(),getY());
        super.positionChanged();
    }
}

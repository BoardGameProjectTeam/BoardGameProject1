package com.boardgame.game.states;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

/**
 * Created by Romeo on 5/23/2016.
 */
public class TestUI extends ApplicationAdapter implements InputProcessor {
    private Skin skin;
    private Stage stage;

    private Table table;
    private TextButton startButton;
    private TextButton quitButton;

    private SpriteBatch batch;
    private Sprite sprite;

    @Override
    public void create () {
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        stage = new Stage(new ScreenViewport());
        table = new Table();
        table.setWidth(stage.getWidth());
        table.align(Align.center | Align.bottom);

        table.setPosition(0,0);
        startButton = new TextButton("New Game",skin);
        quitButton = new TextButton("Quit Game",skin);

        startButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("Clicked button","Yep, you did");
                event.stop();
            }
        });

//        table.padTop(30);

        table.add(startButton).padBottom(20);

        table.row();
        table.add(quitButton).padBottom(30);

        stage.addActor(table);



        batch = new SpriteBatch();
        sprite = new Sprite(new Texture("Samurai.png"));    //background picture
        sprite.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                sprite.setFlip(false,!sprite.isFlipY());
            }
        },10,10,10000);


        // ORDER IS IMPORTANT!
        InputMultiplexer im = new InputMultiplexer(stage,this);
        Gdx.input.setInputProcessor(im);
    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        sprite.draw(batch);
        batch.end();

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }


    @Override
    public boolean keyDown(int keycode) {
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
        sprite.setFlip(!sprite.isFlipX(),sprite.isFlipY());
        return true;
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

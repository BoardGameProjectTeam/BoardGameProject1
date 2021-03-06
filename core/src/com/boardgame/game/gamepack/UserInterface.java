package com.boardgame.game.gamepack;

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
import com.boardgame.game.BoardClasses.BoardSpace;
import com.boardgame.game.BoardClasses.MainBoard;
import com.boardgame.game.ModelClasses.PlayModel;
import com.boardgame.game.PlayerClasses.Character;
import com.boardgame.game.PlayerClasses.Mage;
import com.boardgame.game.PlayerClasses.Ranger;
import com.boardgame.game.PlayerClasses.Warrior;
import com.boardgame.game.states.PlayScreen;

/**
 * Created by Romeo on 5/24/2016.
 */
public class UserInterface extends ApplicationAdapter implements InputProcessor {
    private Stage stage;
    private Skin skin;
    private Table hpTable;
    private TextButton hpDisplay;

    private Character activechar;
    private SpriteBatch batch;
    private Sprite sprite;

    private PlayModel playModel;

    public UserInterface(int x, int y, PlayModel playmodel) {
        activechar = playmodel.getActiveChar();
        this.playModel = playmodel;
        create(x, y);
    }

//    @Override
    public void create(int x, int y) {
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        stage = new Stage(new ScreenViewport());
        hpTable = new Table();
        hpTable.setWidth(70);   //tile width
        hpTable.align(Align.center);
        hpTable.setPosition(x, y);
        hpDisplay = new TextButton("HP: " + activechar.getStats().getHP(), skin);
//        System.out.println(activechar.getStats().getHP());
        hpTable.add(hpDisplay).padBottom(10);
        stage.addActor(hpTable);
//        Gdx.input.setInputProcessor(stage);   //can only have one input processor
    }

    @Override
    public void render() {
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }
    public void setSpot(int x, int y){
        hpTable.setPosition(x, y);
    }
    public void resetActiveChar(){
        activechar = playModel.getActiveChar();
        hpDisplay.setText("HP: "+activechar.getStats().getHP());
        render();
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


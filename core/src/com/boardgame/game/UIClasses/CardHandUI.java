package com.boardgame.game.UIClasses;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.boardgame.game.CardClasses.Card;
import com.boardgame.game.CardClasses.CardHand;
import com.boardgame.game.MyGdxGame;

import javafx.stage.Screen;

/**
 * Created by Cliff on 5/28/2016.
 */
public class CardHandUI {
    public Stage stage;
    public Viewport viewport;

    public CardHandUI(SpriteBatch sb){
        viewport = new FitViewport(MyGdxGame.WIDTH, MyGdxGame.HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb);
    }

}

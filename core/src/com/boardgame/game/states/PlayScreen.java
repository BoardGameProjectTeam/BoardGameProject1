package com.boardgame.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.boardgame.game.BoardClasses.BoardSpace;
import com.boardgame.game.BoardClasses.MainBoard;
import com.boardgame.game.CardClasses.SlashCard;
import com.boardgame.game.Controllers.PlayController;
import com.boardgame.game.MyGdxGame;
import com.boardgame.game.PlayerClasses.Character;
import com.boardgame.game.PlayerClasses.MainPlayer;
import com.boardgame.game.sprites.PlayerSprite;
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
//    private PlayerSprite player;
    private Character activeChar;
    private Character passiveChar; //testing
    private Character temp;

    private MainPlayer p1;
    private MainPlayer p2;

    private PlayController playController;

    public PlayScreen(GameStateManager gsm){
        super(gsm);
        playController = new PlayController(this);
        Gdx.input.setInputProcessor(playController);
        p1 = new MainPlayer();
        p2 = new MainPlayer();

        //setup player 1
        p1.getHand().addCard(new SlashCard());
        p1.getHand().addCard(new SlashCard());
        p1.getHand().addCard(new SlashCard());
        p1.getHand().addCard(new SlashCard());


        bs = new ArrayList<BoardSpace>();
        mb = new MainBoard(7, 7);
//        player = new PlayerSprite();

        //creating the active player (only one for now)
        activeChar = new Character(mb.getSpaceAt(0,0));

        //testing...
        passiveChar = new Character(mb.getSpaceAt(1,1), 2);

        mb.addPlayer(activeChar);
        mb.addPlayer(passiveChar); //testing

//        passiveChar = new Character(mb.getSpaceAt(2,2),3);
//        passiveChar.setPos(2,2);
//        mb.addPlayer(passiveChar);

        cam.setToOrtho(false, MyGdxGame.WIDTH/2, MyGdxGame.HEIGHT/2);
        spriteCam.setToOrtho(false, MyGdxGame.WIDTH/2, MyGdxGame.HEIGHT/2);
        boardOffsetX = 0;
        boardOffsetY = 30;

    }
    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            System.out.println("player stats: "+activeChar.getSpaceon().getX()+" "+activeChar.getSpaceon().getY());
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
                int width = mb.getSpaceAt(i,j).getTile().getWidth(); //panels width
                int height = mb.getSpaceAt(i,j).getTile().getHeight(); // panels height
                sb.draw(mb.getSpaceAt(i,j).getTextures() ,(i*width)+boardOffsetX,(j*height)+boardOffsetY);
                sb.draw(activeChar.getTexture(),activeChar.getX()*width+boardOffsetX,activeChar.getY()*height+boardOffsetY);
                sb.draw(passiveChar.getTexture(),passiveChar.getX()*width+boardOffsetX,passiveChar.getY()*height+boardOffsetY); //testing
            }
        }
        for(int i = 0; i<p1.getHand().handSize();i++) {
            sb.draw(p1.getHand().getCard(i).getCardSprite(),i*p1.getHand().getCard(i).getCardSprite().getWidth(), 300);
        }
//        if(bs.size()>0) {
        for(int i = 0; i < bs.size();i++) {
            sb.draw(bs.get(i).getTextures(), i * 74, 0);
        }
        sb.setProjectionMatrix(spriteCam.combined);
//        sb.draw(player.getTile(), spriteOffsetX, spriteOffsetY);
        sb.end();
//        cam.update();
    }

    public MainBoard getMainBoard(){
        return mb;
    }
    public Character getActiveChar(){
        return activeChar;
    }
    public void switchChar(){
        temp = activeChar;
        activeChar = passiveChar;
        passiveChar = temp;
    }
    public int getBoardOffsetX(){
        return boardOffsetX;
    }
    public int getBoardOffsetY(){
        return boardOffsetY;
    }


    @Override
    public void dispose() {

    }
}
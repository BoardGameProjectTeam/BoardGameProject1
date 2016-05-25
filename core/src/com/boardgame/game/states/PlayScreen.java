package com.boardgame.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.boardgame.game.Animations.AttackAnimation;
import com.boardgame.game.Animations.SlashAnimation;
import com.boardgame.game.BoardClasses.BoardSpace;
import com.boardgame.game.BoardClasses.MainBoard;
import com.boardgame.game.Controllers.PlayController;
import com.boardgame.game.MyGdxGame;
import com.boardgame.game.PlayerClasses.Character;
import com.boardgame.game.PlayerClasses.Mage;

import java.util.ArrayList;

import com.boardgame.game.ModelClasses.PlayModel;
import com.boardgame.game.gamepack.UserInterface;

/**
 * Created by Cliff on 5/6/2016.
 */
public class PlayScreen extends State {
    private int boardOffsetX;
    private int boardOffsetY;
    private MainBoard mb;
    private ArrayList<BoardSpace> bs;

    private Character activeChar;
    private ArrayList<Character> characters;
    private Mage temp;

    private PlayController playController;
    private PlayModel playModel;

    private UserInterface hpBar;

    //for testing
    private ArrayList<AttackAnimation> animations;//need to make a general animation object class
    public PlayScreen(GameStateManager gsm){
        super(gsm);







        playModel = new PlayModel(this);
        playController = new PlayController(playModel,this);

        Gdx.input.setInputProcessor(playController);

        animations = new ArrayList<AttackAnimation>();
//        animations.add(new SlashAnimation(0,0));

        mb = playModel.getMainBoard();
        activeChar = playModel.getActiveChar();
        characters = playModel.getCharacters();

        bs = new ArrayList<BoardSpace>();

        cam.setToOrtho(false, MyGdxGame.WIDTH/2, MyGdxGame.HEIGHT/2);
        spriteCam.setToOrtho(false, MyGdxGame.WIDTH/2, MyGdxGame.HEIGHT/2);
        boardOffsetX = 0;
        boardOffsetY = 0;



    }
    @Override
    //for testing only
    public void handleInput() {
        if(Gdx.input.justTouched()){

        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)){


        }


    }

    @Override
    public void update(float dt) {
        handleInput();

        //for each animation in animations, ss = animation.get(i) that's what this means
        for (AttackAnimation ss:animations) {
            ss.update(dt);
        }
    }

    @Override
    public void render(SpriteBatch sb) {

        //display MP to console
//        System.out.println("MP: " + activeChar.getStats().getMP());



        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        //for loop for main board tiles
        for(int i = 0; i < mb.getXSize(); i ++){
            for(int j = 0; j < mb.getYSize(); j++){
                int width = mb.getSpaceAt(i,j).getTile().getWidth(); //panels width
                int height = mb.getSpaceAt(i,j).getTile().getHeight(); // panels height
                sb.draw(mb.getSpaceAt(i,j).getTextures() ,(i*width),(j*height));
                sb.draw(activeChar.getTexture(),activeChar.getX()*width,activeChar.getY()*height);
                for(int k = 0; k < characters.size(); k++){
                    Character c = characters.get(k);
                    sb.draw(c.getTexture(),c.getX()*width,c.getY()*height);
                }
//                sb.draw(passiveChar.getTexture(),passiveChar.getX()*width+boardOffsetX,passiveChar.getY()*height+boardOffsetY); //testing
            }
        }



        for(int i = 0; i<playModel.getActivePlayer().getHand().handSize();i++) {
            //change this acordingly
            Texture texture = playModel.getActivePlayer().getHand().getCard(i).getCardTexture();
            int xx = playModel.getActivePlayer().getHand().getCard(i).getX();
            int handY = 300;
            sb.draw(texture,
                    xx,
                    handY);
        }
//        if(bs.size()>0) {
        for(int i = 0; i < bs.size();i++) {
            sb.draw(bs.get(i).getTextures(), i * 74, 0);
        }


        for(int i = 0; i < animations.size();i++) {
            AttackAnimation s;
            s = animations.get(i);
            if (!s.removeMe()) {
                sb.draw(s.getTexture(), s.getX() - s.getPanelSize(), s.getY() - s.getPanelSize());
            }else
            {
                s.dispose();
                animations.remove(s);
            }
        }

        hpBar = new UserInterface(activeChar.getX()*35, activeChar.getY()*35);
        hpBar.render();
        sb.setProjectionMatrix(spriteCam.combined);
//        sb.draw(player.getTile(), spriteOffsetX, spriteOffsetY);
        sb.end();
//        cam.update();
    }




    public void addAnimation(AttackAnimation animation){
        animations.add(animation);
    }

    @Override
    public void dispose() {

    }
}
package com.boardgame.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.boardgame.game.Animations.AttackAnimation;
import com.boardgame.game.Animations.SlashAnimation;
import com.boardgame.game.BoardClasses.BoardSpace;
import com.boardgame.game.BoardClasses.MainBoard;
import com.boardgame.game.Controllers.PlayController;
import com.boardgame.game.MyGdxGame;
import com.boardgame.game.PlayerClasses.Character;

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
    float ow = 1;
    float oh = 1;
    private Character activeChar;
    private ArrayList<Character> characters;

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
        animations.add(new SlashAnimation(0,0));

        mb = playModel.getMainBoard();
        activeChar = playModel.getActiveChar();
        characters = playModel.getCharacters();

        bs = new ArrayList<BoardSpace>();

        cam.setToOrtho(false, MyGdxGame.WIDTH/2, MyGdxGame.HEIGHT/2);
//        spriteCam.setToOrtho(false, MyGdxGame.WIDTH/2, MyGdxGame.HEIGHT/2);

        hpBar = new UserInterface(activeChar.getX()*70,activeChar.getY()*70, playModel);
    }
    @Override
    //for testing only
    public void handleInput() {
        if(Gdx.input.justTouched()) {

        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)) {

            if(Gdx.input.isKeyPressed(Input.Keys.A)){
//               ow +=48;
//                oh += 80;
                ow-=.05f;
            }
            if(Gdx.input.isKeyPressed(Input.Keys.S)){
//                 ow -=48;
//                oh -= 80;
                ow+= .05f;
            }
            cam.zoom = ow;
//            cam.setToOrtho(false, MyGdxGame.WIDTH+ ow, MyGdxGame.HEIGHT+ oh);
            cam.update();
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

        //boardspaces
        for(int i = 0; i < bs.size();i++) {
            sb.draw(bs.get(i).getTextures(), i * 74, 0);
        }

        //animations
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

        sb.setProjectionMatrix(spriteCam.combined);
        sb.end();

        hpBar.setSpot(playModel.getActiveChar().getX()*70, (playModel.getActiveChar().getY()*70)+50);
        hpBar.resetActiveChar();
        hpBar.render();
//        System.out.println(playModel.getActiveChar().getStats().getHP());
//        cam.update();
    }

    public void addAnimation(AttackAnimation animation){
        animations.add(animation);
    }
    public UserInterface getHpBar(){
        return hpBar;
    }
    @Override
    public void dispose() {

    }
}
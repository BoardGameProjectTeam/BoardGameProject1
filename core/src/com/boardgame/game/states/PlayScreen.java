package com.boardgame.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.boardgame.game.BoardClasses.BoardSpace;
import com.boardgame.game.BoardClasses.MainBoard;
import com.boardgame.game.MyGdxGame;
import com.boardgame.game.PlayerClasses.Character;
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
    private int spriteOffsetX;
    private int spriteOffsetY;
    private MainBoard mb;
    private ArrayList<BoardSpace> bs;
//    private PlayerSprite player;
    private Character activeChar;
    private Character passiveChar; //testing
    private Character temp;

    int x=0;
    int y=0;
    public PlayScreen(GameStateManager gsm){
        super(gsm);
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
        spriteOffsetX = 0;
        spriteOffsetY = 0;
    }
    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
//            bs.add(new BoardSpace(x,y,mb));
//            x++;
            System.out.println("player stats: "+activeChar.getSpaceon().getX()+" "+activeChar.getSpaceon().getY());
        }
            if (Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)) {
//                System.out.println(activeChar.getX()+" "+activeChar.getY());
                if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
//                    spriteOffsetX -= 36;
//                    if(spriteOffsetX < 22)
//                        spriteOffsetX += 36;
                    mb.moveObject(activeChar,'l');
                }

                if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
                    //boardOffsetX += 10;
//                    spriteOffsetX += 36;
//                    if(spriteOffsetX > 346)
//                        spriteOffsetX -= 36;
                    mb.moveObject(activeChar,'r');
                }

                if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
                    //boardOffsetY += 10;
//                    spriteOffsetY += 28;
//                    if(spriteOffsetY > 520)
//                        spriteOffsetY -= 28;
                    mb.moveObject(activeChar,'u');
                }

                if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
                    //boardOffsetY -= 10;
//                    spriteOffsetY -= 28;
//                    if(spriteOffsetY < 268)
//                        spriteOffsetY += 28;
                    mb.moveObject(activeChar,'d');
                }

                if (Gdx.input.isKeyJustPressed(Input.Keys.Z))
                {
                    temp = activeChar;
                    activeChar = passiveChar;
                    passiveChar = temp;
                }
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
//        if(bs.size()>0) {
        for(int i = 0; i < bs.size();i++) {
            sb.draw(bs.get(i).getTextures(), i * 74, 0);
        }
        sb.setProjectionMatrix(spriteCam.combined);
//        sb.draw(player.getTile(), spriteOffsetX, spriteOffsetY);
        sb.end();
//        cam.update();
    }

    @Override
    public void dispose() {

    }
}
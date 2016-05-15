package com.boardgame.game.BoardClasses;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.boardgame.game.PlayerClasses.Character;
import com.boardgame.game.gamepack.Trap;
import com.boardgame.game.sprites.SingleTile;
import com.boardgame.game.sprites.Tile;

import java.util.ArrayList;

/**
 * This class is designed to represent an individual board space panel
 * It needs the mainboard to have references to its parent.
 *
 */
public class BoardSpace {

	//for textures
	private SingleTile tile;

	//objects on space
	private Trap storedTrap;
	private BoardObject storedObj;
	private ArrayList<BoardObject> objs;
	private Character character;

	//location variables
	private int x;
	private int y;
	private MainBoard board;

	//default constructor
	public BoardSpace(int x, int y, MainBoard mainBoard){
		this.setX(x);
		this.setY(y);
		board = mainBoard;
		tile = new SingleTile(0);
		objs = new ArrayList<BoardObject>();
	}

	//constructor for when specifying a type of panel to create
	public BoardSpace(int type, int x, int y, MainBoard mainBoard){
		this.setX(x);
		this.setY(y);
		board = mainBoard;
		tile = new SingleTile(type);
		objs = new ArrayList<BoardObject>();
	}

	//used for placing objects on the space
	public void addObject(BoardObject p){
//			storedObj = p;
			objs.add(p);
			if(p.isCharacter()){
				storeCharacter((Character)p);
			}
	}

	public void removeObject(BoardObject p){
//			storedObj = null;
		objs.remove(p);
	}

	//needs fixing, as this is used to check if a space is occupied...
	public Boolean hasCharacter(){
		return storedObj.isCharacter();
	}
	public Boolean hasObject(){	return objs.size()>0;}

	//location get/set methods
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	//used for finding the object on the space currently
	public BoardObject getObject(){
		return objs.get(0);
	}

	//Trap related functions
	public Trap getTrap() {
		return storedTrap;
	}
	public void setTrap(Trap storedTrap) {
		this.storedTrap = storedTrap;
	}
	public boolean removeTrap(){
		if(hasTrap()){
			storedTrap = null;
			return true;
		}else
			return false;
	}
	public boolean hasTrap() {
		return storedTrap != null;
	}

	//this will be used when trying to copy the space to another, maybe due to a card effect.
	public BoardSpace duplicate(){
		BoardSpace s = new BoardSpace(x, y,board);
		s.addObject(storedObj);
		//s.addTrap(storedTrap);
		return s;
	}
	public void storeCharacter(Character character){
		this.character = character;
	}
	public SingleTile getTile(){
		return tile;
	}
	public Texture getTextures(){
		return tile.getTile();
	}
	public Character getCharacter(){return character;}
	public void printspot(){
		System.out.println(x +" , " + y);
	}

	
	
}

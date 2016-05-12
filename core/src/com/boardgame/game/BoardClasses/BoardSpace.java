package com.boardgame.game.BoardClasses;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.boardgame.game.gamepack.Trap;
import com.boardgame.game.sprites.SingleTile;
import com.boardgame.game.sprites.Tile;

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
	}

	//constructor for when specifying a type of panel to create
	public BoardSpace(int type, int x, int y, MainBoard mainBoard){
		this.setX(x);
		this.setY(y);
		board = mainBoard;
		tile = new SingleTile(type);
	}

	//used for placing objects on the space
	public void addObject(BoardObject p){
			storedObj = p;
	}
	public void removeObject(){
			storedObj = null;		
	}

	//needs fixing, as this is used to check if a space is occupied...
	public Boolean hasCharacter(){
		return storedObj.isCharacter();
	}
	public Boolean hasObject(){
		return storedObj != null;
	}

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
		return storedObj;
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
	public SingleTile getTile(){
		return tile;
	}
	public Texture getTextures(){
		return tile.getTile();
	}

	public void printspot(){
		System.out.println(x +" , " + y);
	}

	
	
}

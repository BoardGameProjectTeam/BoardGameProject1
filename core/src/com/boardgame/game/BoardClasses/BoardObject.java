package com.boardgame.game.BoardClasses;

/**
 * an object that can be interacted with on the board.
 */

public abstract class BoardObject implements ABoardObject {

	protected int x;
	protected int y;
	protected BoardSpace spaceon;
	protected String name;
	protected int hp;

	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}

	public BoardSpace getSpaceon() {
		return spaceon;
	}

	public void setSpaceon(BoardSpace spaceon) {
		this.spaceon = spaceon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public boolean isCharacter(){
		return false;
	}

	//used for objects that will block movement onto the space it occupies
	public boolean occupySpace(){
		return false;
	}
	public void takeDamage(int i){
		hp -= i;
		System.out.println(hp);
	}
}

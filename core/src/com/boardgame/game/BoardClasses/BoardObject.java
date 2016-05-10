package com.boardgame.game.BoardClasses;

/**
 * an object that can be interacted with on the board.
 */

public abstract class BoardObject {

	private int xpos;
	private int ypos;
	private BoardSpace spaceon;
	private String name;
	
	public BoardObject(){
		
	}
	
	public int getX(){
		return xpos;
	}
	public int getY(){
		return ypos;
	}
	public void setX(int x){
		xpos = x;
	}
	public void setY(int y){
		ypos = y;
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
	
}

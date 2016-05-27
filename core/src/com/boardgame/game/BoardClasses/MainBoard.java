package com.boardgame.game.BoardClasses;

import com.boardgame.game.PlayerClasses.Character;

import java.util.ArrayList;

/**
 * This class is used to keep track of the board, and all of its spaces
 * you can retrieve space information by findspace and passing the x,y coords
 *
 */
public class MainBoard {

	private ArrayList<BoardSpace> spaces= new ArrayList<BoardSpace>();
	private ArrayList<Character> characters = new ArrayList<Character>();
	int xsize;
	int ysize;
	boolean addon;
	int turn=0;
	private BoardMovement mv;
	public MainBoard(BoardSpace[] spaces, Character[] characters){
		for(int i =0; i<spaces.length;i++)
			this.spaces.add(spaces[i]);
		for(int i = 0; i< characters.length; i++)
			this.characters.add(characters[i]);
		mv = new BoardMovement();
	}
	public MainBoard(int x, int y){
		makeBoard(x,y);
		xsize = x;
		ysize = y;
		mv = new BoardMovement();
	}
	public void teleportObject(BoardObject obj, int x, int y){
		if(obj!=null){
			mv.teleport(this,obj,getSpaceAt(x,y));
		}
	}
	public void teleportObject(BoardObject obj, BoardSpace boardSpace){
		if(obj!= null){
			mv.teleport(this,obj,boardSpace);
		}
	}

	public void moveObject(BoardObject obj, char direction){
		if(obj !=null) {
//			System.out.println(obj.getX()+ " "+ obj.getY());
			switch (direction) {
				case 'u':
					mv.moveUp(this, obj);
					break;
				case 'd':
					mv.moveDown(this, obj);
					break;
				case 'l':
					mv.moveLeft(this, obj);
					break;
				case 'r':
					mv.moveRight(this, obj);
					break;
			}
		}
		else {

		}
	}

	public ArrayList<Character> getCharacters(){
		return characters;
	}
	public int getXSize(){
		return xsize;
	}
	public int getYSize(){
		return ysize;
	}

	public void makeBoard(int x, int y){
		for(int i =0; i < x;i++)
		{
			for(int j =0; j < y;j++)
			{
				BoardSpace sp;
				sp = new BoardSpace(i,j,this);
				spaces.add(sp);
			}
		}
		for(int i =0; i < x;i++)
		{
			for(int j =0; j < y;j++)
			{
				BoardSpace sp;
				sp = getSpaceAt(i,j);
				if(i>0){
					sp.setLeftSpace(getSpaceAt(i-1,j));
				}
				if(i<x){
					sp.setRightSpace(getSpaceAt(i+1,j));
				}
				if(j>0){
					sp.setBelowSpace(getSpaceAt(i,j-1));
				}
				if(j<y){
					sp.setAboveSpace(getSpaceAt(i,j+1));
				}
			}
		}
	}

	public BoardSpace getSpaceAt(int x, int y){
		try{
		for(int i=0;i<spaces.size();i++){
			
			if(spaces.get(i).getX()==x&&spaces.get(i).getY()==y){
				return spaces.get(i);
			}
		}}catch (Exception e){
			System.out.println("Exception error finding space at " +x +y);
		}
		return null;
	}
	public ArrayList<BoardSpace> getBoardSpaces(){
		return spaces;
	}


	//use this when you made a character and want to add it to the main board
	public void addPlayer(Character p){
		BoardSpace s = getSpaceAt(p.getX(),p.getY());

		if(s != null){
			s.addObject(p);
		p.setSpaceon(s);
		characters.add(p);
		}
	}
	public Character getCharacter(int i){
		return characters.get(i);
	}
	public boolean addonspace(){
		return addon;
	}
	public void addedspace(){
		addon = false;
	}
	public void pleaseadd(){
		addon = true;
	}
}

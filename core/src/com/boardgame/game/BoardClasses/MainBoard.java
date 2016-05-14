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
				spaces.add(new BoardSpace(i,j,this));
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

	//use this when making a fresh new character
	public void addPlayer(int x,int y,String name){
		try {
			BoardSpace s = getSpaceAt(x, y);
			Character pp = new Character(name, getSpaceAt(x, y));
			pp.setX(x);
			pp.setY(y);
			s.addObject(pp);
			pp.setSpaceon(s);
			characters.add(pp);
		}catch (Exception e){
			System.out.println("error board space doesn't exit at "+x+y );
		}
			
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

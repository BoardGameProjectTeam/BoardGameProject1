package com.boardgame.game.CardClasses;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.boardgame.game.Attacks.Attack;
import com.boardgame.game.Attacks.SingleAreaAttack;
import com.boardgame.game.BoardClasses.BoardSpace;
import com.boardgame.game.BoardClasses.MainBoard;
import com.boardgame.game.PlayerClasses.Character;

import java.util.ArrayList;

public abstract class Card {


	protected String name;
	protected Texture cardTexture;
	protected Sprite sprite;
	protected Rectangle clickbox;
	protected int width;
	protected int height;
	protected int attackType;// 0 for ...
	protected Attack attack;
	protected int cardType;



	public Card(String fileName,int x, int y){
		cardTexture = new Texture(fileName);
		sprite = new Sprite(cardTexture);
		sprite.setPosition(x,y);
		sprite.setBounds(x,y,sprite.getWidth(),sprite.getHeight());
		attackType = 0;
		this.name = fileName;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLocation(int x,int y){
		sprite.setPosition(x,y);
	}
	public boolean checkBounds(int x, int y){

		if(x > sprite.getX()){
			if(x<sprite.getWidth()+sprite.getX()){
				if(y>sprite.getY()){
					if(y<sprite.getHeight()+sprite.getY()){
						return true;
					}
				}else{
					System.out.println("sprite y is" +sprite.getY()+" : sprite height is: "+sprite.getHeight()+sprite.getY());
					System.out.println("Mouse y ="+y);
				}

			}
		}
		return false;
	}
	public void dispose(){
		cardTexture.dispose();
	}
//	public Card dupe(){
//		Card c = new Card(name,(int)sprite.getX(),(int)sprite.getY());
//		return c;
//	}
	public Texture getCardTexture(){
		return sprite.getTexture();
	}
	public int getX(){
		return (int)sprite.getX();
	}
	public int getY(){
		return (int)sprite.getY();
	}
	public int getCardType(){return cardType;}
	public int getAttackType(){
		return attackType;
	}
	public Attack getAttack(){
		return attack;
	}
	public SingleAreaAttack getSingleAreaAttack(Character user, BoardSpace targetSpace){
		return new SingleAreaAttack(user,targetSpace);
	}

}

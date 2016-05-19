package com.boardgame.game.CardClasses;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class Card {


	protected String name;
	protected Texture cardTexture;
	protected Sprite sprite;
	protected Rectangle clickbox;
	protected int width;
	protected int height;



	public Card(String fileName,int x, int y){
		cardTexture = new Texture(fileName);
		sprite = new Sprite(cardTexture);
		sprite.setPosition(x,y);
		sprite.setBounds(x,y,sprite.getWidth(),sprite.getHeight());

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
			return true;
			}
		}
		return false;
	}
	public void dispose(){
		cardTexture.dispose();
	}
	public Card dupe(){
		Card c = new Card(name,(int)sprite.getX(),(int)sprite.getY());
		return c;
	}
	public Texture getCardTexture(){
		return sprite.getTexture();
	}
	public int getX(){
		return (int)sprite.getX();
	}
	public int getY(){
		return (int)sprite.getY();
	}



}

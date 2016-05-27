package com.boardgame.game.PlayerClasses;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.boardgame.game.BoardClasses.ABoardObject;
import com.boardgame.game.BoardClasses.BoardObject;
import com.boardgame.game.BoardClasses.BoardSpace;
import com.boardgame.game.CardClasses.Card;
import com.boardgame.game.PlayerClasses.CharacterStats;
import com.boardgame.game.SkillClasses.Skill;
import com.boardgame.game.SkillClasses.SkillList;
import com.boardgame.game.gamepack.UserInterface;
import com.boardgame.game.sprites.PlayerSprite;

import java.util.ArrayList;

public abstract class Character extends BoardObject implements ABoardObject{

	private PlayerSprite player;
	private Sprite sprite;
	protected CharacterStats stats;
	private SkillList skills;
	private BoardSpace spaceon; //for tracking purposes
	private char facing; //n,s,e,w or r,l,u,d
	private ArrayList<Card> passivecard= new ArrayList<Card>(); //for any passive cards that affect this character
	private ArrayList<Skill> passiveSkills = new ArrayList<Skill>(); // skills the character has on

	public Character(String name, BoardSpace spaceOn){
		super.setName(name);
		commonConstructor(spaceOn);
	}

	public Character(BoardSpace spaceOn) {
		commonConstructor(spaceOn);
	}

	private void commonConstructor(BoardSpace spaceOn){
		player = new PlayerSprite();
		spaceon = spaceOn;
		setPos(spaceOn.getX(),spaceOn.getY());
		passivecard = new ArrayList<Card>();
		passiveSkills = new ArrayList<Skill>();
		stats = new CharacterStats(0, 0, 0, 0, 1);
		facing = 'r';
	}
	//testing different constructor
	public Character(BoardSpace spaceOn, int charSeq)
	{
		player = new PlayerSprite(charSeq);
		spaceon = spaceOn;
		setPos(spaceOn.getX(),spaceOn.getY());
		passivecard = new ArrayList<Card>();
		passiveSkills = new ArrayList<Skill>();

	}

	public void setPos(int x, int y){
		super.setX(x);
		super.setY(y);

	}
	public BoardSpace getSpaceon(){
		return spaceon;
	}
	public void setSpaceon(BoardSpace spaceon){
		this.spaceon = spaceon;
		setPos(spaceon.getX(),spaceon.getY());
	}

	public CharacterStats getStats() {
		return stats;
	}

	public void setPassivecard(ArrayList<Card> passivecard) {
		this.passivecard = passivecard;
	}
	public ArrayList<Skill> getPassiveSkills() {
		return passiveSkills;
	}
	public void setPassiveSkills(ArrayList<Skill> passiveSkills) {
		this.passiveSkills = passiveSkills;
	}

	//for the boardspace function to check if its object is a player
	public boolean isCharacter(){
		return true;
	}
	public TextureRegion getTexture(){
		return player.getTile();
	}
	public int getHP(){
		return stats.getHP();
	}
	public void takeDamage(int i){
		stats.setHP(stats.getHP()-i);
	}
}


package com.boardgame.game.PlayerClasses;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.boardgame.game.BoardClasses.BoardObject;
import com.boardgame.game.gamepack.Card;
import com.boardgame.game.gamepack.Skill;
import com.boardgame.game.gamepack.SkillList;

import java.util.ArrayList;

public class Player extends BoardObject {

	private TextureRegion player;

	private ArrayList<Card> hand= new ArrayList<Card>();
	private SkillList skills;
	
	//dunno if these belong here? vv
	private ArrayList<Card> passivecard= new ArrayList<Card>();
	private ArrayList<Skill> passiveSkills = new ArrayList<Skill>();
	
	public Player(String name){
		super.setName(name);
	}
	public void setPos(int x, int y){
		super.setX(x);
		super.setY(y);
	}
	public SkillList getSkills() {
		return skills;
	}
	public void setSkills(SkillList skills) {
		this.skills = skills;
	}
	public ArrayList<Card> getHand() {
		return hand;
	}
	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}
	public ArrayList<Card> getPassivecard() {
		return passivecard;
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
	
}


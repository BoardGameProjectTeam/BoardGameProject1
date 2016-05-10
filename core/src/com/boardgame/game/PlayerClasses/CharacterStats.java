package com.boardgame.game.PlayerClasses;

public class CharacterStats {
	private int HP;
	private int MP;
	private int power;
	private int resist;
	
	public CharacterStats(int HP,int MP, int power, int resist){
		setHP(HP);
		setMP(MP);
		setPower(power);
		setResist(resist);
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	public int getMP() {
		return MP;
	}

	public void setMP(int mP) {
		MP = mP;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getResist() {
		return resist;
	}

	public void setResist(int resist) {
		this.resist = resist;
	}

}

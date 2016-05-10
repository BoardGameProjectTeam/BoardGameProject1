package com.boardgame.game.gamepack;

public class Attributes {
private int health;
private int money;
public Attributes(){
	money = 0;
	health = 10;
}
public Attributes(int health, int money)
{
	this.health = health;
	this.money = money;
}
public int getHealth() {
	return health;
}
public void setHealth(int health) {
	this.health = health;
}
public int getMoney() {
	return money;
}
public void setMoney(int money) {
	this.money = money;
}
}

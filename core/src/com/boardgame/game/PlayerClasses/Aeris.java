package com.boardgame.game.PlayerClasses;

import com.boardgame.game.BoardClasses.BoardSpace;

/**
 * Fire based pyro specialist user
 *
 * high hp, low mp, high attack, med def,movment
 *
 * heavy hitter, and able to walk on, through fire tiles.
 *
 * adds the fire attribute to all cards used, in addition to the burn ailment.
 * she can also get a flaming rocket boost when using melee attacks, (she moves one space forward first) if an mobile object is in front, she will charge at them, shoving
 *      them forward.
 *
 * 3x to fire based cards
 *
 *
 * basic attack: fire breathe, shoots fire in front over cauing the panel to be lit a period of turns unless an object/player is present, which then will push them back
 * Created by Cliff on 5/26/2016.
 */
public class Aeris extends Character {
    public Aeris(String name, BoardSpace spaceOn) {
        super(name, spaceOn);
        stats = new CharacterStats(30, 10, 5, 3, 4);

    }
}

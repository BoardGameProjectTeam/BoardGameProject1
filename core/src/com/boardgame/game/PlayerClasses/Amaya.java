package com.boardgame.game.PlayerClasses;

import com.boardgame.game.BoardClasses.BoardSpace;

/**
 * Speedy shady elf girl, has great control over metal objects (like earth benders?)
 * The long range character.
 * low HP, med MP, med att, low def, very high movement
 *
 * specials
 * she turns any metal element card into a projectile
 * she can also use any card, and create a metal wall for defense.
 * 2x power on any metal element cards
 * melee attacks cause full knockback, pushing the character all the way until they hit a wall or boundary
 * .
 *
 * basic attack: needle storm (crafts needles first) then throws them straight ahead, the longer she crafts the more she throws
 *
 * Created by Cliff on 5/26/2016.
 */
public class Amaya extends Character{
    public Amaya(String name, BoardSpace spaceOn) {
        super(name, spaceOn);
        stats = new CharacterStats(10, 20, 3, 1, 7);

    }
}

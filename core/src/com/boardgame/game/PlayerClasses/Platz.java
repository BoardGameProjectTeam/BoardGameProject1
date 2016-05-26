package com.boardgame.game.PlayerClasses;

import com.boardgame.game.BoardClasses.BoardSpace;

/**
 * Water based multi weapon specialist
 *
 * Has the option of adding water effects to cards
 * each effect also adds another bonus effect.
 * for melee, reach is extended by 1
 * projectiles are granted +1 knockback
 * water tiles have no effect on him, and he is also able to walk over water tiles
 *
 * water element cards used will gain the ability to freeze targets instantly
 *
 * 2x bonus to water element cards
 * 2x bonus to any attacks that are based off weapons (bow, sword, spear, etc)
 *
 * med HP, med MP, low att, low resist, med movement.
 * also basic attack changes if a card used a weapon. it will then become that attack.
 *
 * Created by Cliff on 5/26/2016.
 */
public class Platz extends Character{
    public Platz(String name, BoardSpace spaceOn) {
        super(name, spaceOn);
        stats = new CharacterStats(15, 20, 2, 2, 4);
    }
}

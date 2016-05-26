package com.boardgame.game.PlayerClasses;

import com.boardgame.game.BoardClasses.BoardSpace;

/**
 * Slow engineer/chemist, but has very long range of attack, and burst type movement (like shooting off a rocket) always moves 5 spaces in one direction if used
 * High HP, High MP, High Defense, med attack, very low movement
 *
 * Specials
 * craft, any cards she uses, (will after the effect) get placed into a pot, and mix up into a new attack
 * basically recipies, for attacks: the first attack placed in will then get abilities and power of the next card,
 * for terrain swapping: the terrain will place a trap, that triggers the cards effect when someone steps on it (healing too)
 * for healing: creates a super potion that gets power from proceeding cards
 * for Objects: the object gets the ability to use the proceeding card, any cards added after, add to its power and health of the object.
 *
 * basic attack: lobs an vail, based on what cards shes been using.it has the element of the last card used, and attack attribute as well (slash, stab, bash, explosion etc)
 *
 * Created by Cliff on 5/26/2016.
 */
public class Kimiko extends Character {

    public Kimiko(String name, BoardSpace spaceOn) {
        super(name, spaceOn);
        stats = new CharacterStats(50, 50, 3, 5, 1);
    }

}

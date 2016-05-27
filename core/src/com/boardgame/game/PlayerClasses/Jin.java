package com.boardgame.game.PlayerClasses;

import com.boardgame.game.BoardClasses.BoardSpace;

/**
 * Card specialist, Somewhat a luck based character, but helps the playerSprite when it comes to card usage
 * high HP, MP, med power, resist, movement
 *
 * every card used, causes Jin to swap suits (card suits) each with their own traits in this order
 * Hearts = heal damage done, or improved healing from card
 * Spade = grant piercing effect to projectile
 * Clubs = cause stun on impact for attacks, or cure ailments when using a support card
 * Diamond = cause extra crystals to fly when an object is hit (players included)
 *
 * Specials, able to convert players card into his own and use it as an attack., it inherits the
 * elements attached to it, beware that healing cards will heal the target hit, so use on your allies
 * Delay: When activated, any cards Jin uses, will be delayed till next turn, good for stacking combos and freeing up your hand
 *
 * Basic attack: throws a card, which will also cause the suit to swap
 * .
 * Created by Cliff on 5/26/2016.
 */
public class Jin extends Character {
    public Jin(String name, BoardSpace spaceOn) {
        super(name, spaceOn);
        stats = new CharacterStats(20, 30, 3, 3, 3);

    }
}

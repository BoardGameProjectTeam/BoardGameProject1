package com.boardgame.game.PlayerClasses;

import com.boardgame.game.BoardClasses.BoardSpace;

/**
 * mid ranged wind dancer
 * high hp, movement
 * medium everything else
 *
 * Specials:
 * controlled knockback, she can choose where the character will be knocked to instead of the normal knockback.
 *      any card that normally doesnt have knockback will be giving 1 space knockback.
 * projectile attacks boomerang back like yoyo's
 * 2x power to wind element cards
 *
 * basic attack throws her chakrams. forward that curves up on return, the other curves down on return
 *
 * Created by Cliff on 5/26/2016.
 */
public class Rina extends Character{

    public Rina(String name, BoardSpace spaceOn) {
        super(name, spaceOn);
        stats = new CharacterStats(30, 20, 3, 3, 4);
        // TODO Auto-generated constructor stub
    }
}

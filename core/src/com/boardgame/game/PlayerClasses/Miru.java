package com.boardgame.game.PlayerClasses;

import com.boardgame.game.BoardClasses.BoardSpace;

/**
 * Mid ranged spirit user, has two forms, which changes her stats accordingly
 * Wolf = High attack, high movement, High HP, low MP, low defense
 * Fox = Low attack, med movement, med HP, High MP, High Defense
 * Normal = med attack, High movement, med HP, med MP, med Defense
 *
 * Specializes in disjointed melee attacks, basically making melee attacks mid range. (+1 range for melee cards)
 * Boosts any type of slash attack(2x power)
 *
 * basic attack:
 * wolf: claw slash (wide slash) but three hits
 * fox: bind (with tail) also causes target to be stunned
 * normal; spirit shot> small orb that travels one space per turn.
 *
 * Created by Cliff on 5/26/2016.
 */
public class Miru extends Character{
    public Miru(String name, BoardSpace spaceOn) {
        super(name, spaceOn);
        stats = new CharacterStats(20, 30, 3, 3, 3);
    }
}

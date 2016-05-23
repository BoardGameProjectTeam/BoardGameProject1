package com.boardgame.game.Controllers;

import com.boardgame.game.Attacks.Attack;
import com.boardgame.game.BoardClasses.MainBoard;
import com.boardgame.game.CardClasses.Card;
import com.boardgame.game.SkillClasses.Skill;

/**
 * Class to handle doing actions/attacls on the board
 * Created by Cliff on 5/15/2016.
 */
public class ActionPerformer {
    private MainBoard mainBoard;
    private Attack attack;

    public ActionPerformer(MainBoard mainBoard){
        this.mainBoard = mainBoard;
    }
    public void useCard(Card card){
        switch ((card.getCardType())){
            case 0:
                //attack
            case 1:
                //trap
            case 2:
                //special actions
            break;
        }


    }
    public void useSkill(Skill skill){

    }

    public void performAttack(){

    }

}

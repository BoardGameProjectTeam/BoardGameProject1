package com.boardgame.game.Controllers;

import com.boardgame.game.Attacks.Attack;
import com.boardgame.game.Attacks.SingleAreaAttack;
import com.boardgame.game.Attacks.SingleTargetAttack;
import com.boardgame.game.Attacks.Slash;
import com.boardgame.game.BoardClasses.BoardSpace;
import com.boardgame.game.BoardClasses.MainBoard;
import com.boardgame.game.CardClasses.Card;
import com.boardgame.game.ModelClasses.PlayModel;
import com.boardgame.game.PlayerClasses.Character;
import com.boardgame.game.SkillClasses.Skill;
import com.boardgame.game.states.PlayScreen;

import java.util.ArrayList;

/**
 * Class to handle doing actions/attacls on the board
 * Created by Cliff on 5/15/2016.
 */
public class ActionPerformer {
    private PlayModel playModel;
    private PlayScreen playScreen;
    private MainBoard mainBoard;


    public ActionPerformer(PlayModel playModel,PlayScreen playScreen){
        this.playModel = playModel;
        this.mainBoard = playModel.getMainBoard();
        this.playScreen = playScreen;
    }
    public void useCard(Card card){
        switch ((card.getCardType())){
            case 0:
                //attack
                switch (card.getAttackType()){
                    case 0:
                        //single target
                        break;
                    case 1:
                        //single area
                        Character user = playModel.getActiveChar();
                        BoardSpace target =playModel.getActiveChar().getSpaceon();


                        target = target.getRightSpace();
                        SingleAreaAttack atk = card.getSingleAreaAttack(user,target);
                        atk.performAction(playScreen);
                        break;
                }
                //set up attack
                //attack.performAction
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

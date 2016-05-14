package com.boardgame.game.SkillClasses;

public class Skill implements SkillInterface{
    private String skillName;

    @Override
    public String getName() {
        return skillName;
    }
}

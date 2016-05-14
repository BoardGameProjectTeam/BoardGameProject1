package com.boardgame.game.SkillClasses;

import java.util.ArrayList;

public class SkillList {

    private ArrayList<Skill> skills;
    public SkillList(){
        skills = new ArrayList<Skill>();
    }
    public void addSkill(Skill skill){
        skills.add(skill);
    }
    public void removeSkill(Skill skill){
        skills.remove(skill);
    }
    public void removeSkill(int i){
        skills.remove(i);
    }
    public ArrayList<Skill> getSkills(){
        return skills;
    }
}

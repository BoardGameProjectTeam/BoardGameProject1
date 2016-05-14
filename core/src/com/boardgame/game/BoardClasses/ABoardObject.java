package com.boardgame.game.BoardClasses;

/**
 * used so I don't forget what to implement in future board objects
 * Created by Cliff on 5/14/2016.
 */
public interface ABoardObject {
     int getX();
     int getY();
     void setX(int x);
     void setY(int y);
     BoardSpace getSpaceon();
     void setSpaceon(BoardSpace spaceon) ;
     String getName();
     void setName(String name);
     boolean isCharacter();
}

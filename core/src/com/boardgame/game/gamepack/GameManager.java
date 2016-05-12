package com.boardgame.game.gamepack;

import com.boardgame.game.BoardClasses.*;
import com.boardgame.game.PlayerClasses.Character;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameManager {

	public static void main(String[] args) {
		
			   		
		
		//MainBoard mn = new MainBoard(new BoardSpace[8],new Character[4]);
		Boolean exitme = false;
		BoardMovement mv = new BoardMovement();			//var that controls movement
		MainBoard mn = new MainBoard(8,8);		// game board
		BoardPrinter bp = new BoardPrinter(mn);	//used to print board on console
		com.boardgame.game.CardClasses.Deck deck = new com.boardgame.game.CardClasses.Deck();
		//Reads in cards from the file Cards.txt
		Scanner in1 = null;
		try {
		    in1 = new Scanner(new File("Cards.txt"));
		} catch (FileNotFoundException exception) {
		    System.err.println("failed to open Cards.txt");
		    System.exit(1);
		}
		while (in1.hasNextLine()) {
		    String line = in1.nextLine();
		    deck.addCard(new com.boardgame.game.CardClasses.Card(line));
		}
//		deck.printdeck(); //for testing //should be move 1,2,3,4
//		deck.draw();
//		deck.printdeck(); //should then print 2,3,4
		
		int pnum =0; //used to reference the player element in the main boards array list

		
		
		//mn.addPlayer(1, 1, "2");//testing adding a player style 1
		Character p1 = new Character("1");//testng adding a player style 2
		p1.setPos(3,3);
		mn.addPlayer(p1);
		bp.printBoard(mn);
		
		//Plans:
		//turn order starts at 0, aka player 1
		//player x selects card to play
		//if no cards or player x selects end turn, goes to next player
		
		
		
		
		//As of now code below controls movement based on just number input only
		Scanner in = new Scanner(System.in);
		while(!exitme){
			System.out.println("Enter a movement");
			//try 
			int num = in.nextInt();
			
			switch(num){
				case 2:
					mv.moveRight(mn, mn.getCharacters().get(pnum));
					break;
				case 1:
					mv.moveLeft(mn, mn.getCharacters().get(pnum));
					break;

				case 3:
					mv.moveUp(mn, mn.getCharacters().get(pnum));
					break;

				case 4:
					mv.moveDown(mn, mn.getCharacters().get(pnum));
					break;

					default:
						exitme = true;
						break;
						
			}
			
			bp.printBoard();
		}
		in.close();
	}

}

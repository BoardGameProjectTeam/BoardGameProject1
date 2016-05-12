package com.boardgame.game.BoardClasses;

/**
 * This class is used to print out a main board on the console
 * @author Cliff
 *
 */
public class BoardPrinter {

	int xsize;
	int ysize;
	private MainBoard mb;
	
	public BoardPrinter (MainBoard mb){
		this.setMb(mb);
	}
	public BoardPrinter(){
		
	}
	public void addBoard(MainBoard mb){
		this.setMb(mb);
	}
	public void printBoard(MainBoard mb){
		xsize = mb.getXSize();
		ysize = mb.getYSize();
		if(xsize != 0&&ysize != 0)
		{
			for(int i = 0;i<xsize;i++)
			{
				//get space at i,j
				//look at whats in it
				//print it out
				for(int j = 0; j<ysize; j++){
					BoardSpace s = mb.getSpaceAt(j, i);
					System.out.print("[");
					if(s.hasCharacter()){
						System.out.print(s.getObject().getName());
					}
					if(s.hasTrap()){
						System.out.print("T");
					}
					if(!(s.hasTrap() || s.hasCharacter())){
						System.out.print(" ");
					}
					
					System.out.print("]");
					}
				System.out.print("\n");	
			}
		}
	}
	public void printBoard(){
		printBoard(mb);
	}
	public MainBoard getMb() {
		return mb;
	}
	public void setMb(MainBoard mb) {
		this.mb = mb;
	}
}

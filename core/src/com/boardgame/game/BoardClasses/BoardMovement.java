package com.boardgame.game.BoardClasses;

/**
 * This class handles moving any type of Board Object on the given MainBoard
 * @author Cliff
 *
 */
public class BoardMovement {
	private BoardSpace b;
	private BoardSpace b2;
	public void moveRight(MainBoard mainBoard, BoardObject obj){

		b = obj.getSpaceon();							//store old space
		if(mainBoard.getXSize()>obj.getX()+1) {                            //checks to make sure its in bounds
			b2 = mainBoard.getSpaceAt((obj.getX() + 1), obj.getY());                //Set the new location
			if (!b2.hasObject()) {
				b.removeObject();                                        //remove the object from the old space
				b2.addObject(obj);                                        //place object in the new space
				obj.setX(obj.getX() + 1);                                        //change the objects x to reflect the new space
				obj.setSpaceon(b2);                                        //change the stored space to be the new space
			}
		}
		else
			System.out.println("Outside x range");		
		
	}

	public void moveLeft(MainBoard mainBoard, BoardObject obj){

		b = obj.getSpaceon();
		if(0<=(obj.getX()-1)){
		b2= mainBoard.getSpaceAt(obj.getX()-1, obj.getY());
		//check if an object is present
			if(!b2.hasObject()) {
				b.removeObject();
				b2.addObject(obj);
				obj.setX(obj.getX() - 1);
				obj.setSpaceon(b2);
			}
		}
		else
			System.out.println("Outside x range");		
	}
	
	public void moveDown(MainBoard mainBoard, BoardObject obj){
		b = obj.getSpaceon();
		if(0<=(obj.getY()-1)){
		b2= mainBoard.getSpaceAt(obj.getX(), obj.getY()-1);
			if(!b2.hasObject()) {
				b.removeObject();
				b2.addObject(obj);
				obj.setY(obj.getY() - 1);
				obj.setSpaceon(b2);
			}else
			{
				System.out.println("has object");
			}
		}
		else
			System.out.println("Outside y range");	
	}
		
		
	public void moveUp(MainBoard mainBoard, BoardObject obj){
			 b = obj.getSpaceon();
			if(mainBoard.getYSize()>(obj.getY()+1)){
			b2= mainBoard.getSpaceAt(obj.getX(), obj.getY()+1);
				if(!b2.hasObject()) {
					b.removeObject();
					b2.addObject(obj);
					obj.setY(obj.getY() + 1);
					obj.setSpaceon(b2);
				}
			}
			else
					System.out.println("Outside y range");	
			
	}
	
}

package abdn.scnu.cs;

public abstract class AbstractGameGrid {
	/*
	The Coordinate will be
	eg:
	  0 1 2
	0 . . .
	1 . . .
	2 . . .
	*/
	
	public String [][] gameGrid;
	public AbstractBattleShip [] ships;
		
    //populate the grid with "." characters
	public abstract void initializeGrid () ;
	
	//this should place the ship on the grid using "*" symbol
	public abstract void placeShip (AbstractBattleShip ship) ;
	
	//this should generate ships for both player and the opponent 
	public abstract void generateShips (int numberOfShips) ;
	
}
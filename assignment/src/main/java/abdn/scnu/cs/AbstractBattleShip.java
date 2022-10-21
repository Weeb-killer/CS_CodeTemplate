package abdn.scnu.cs;

import java.util.*;

public abstract class AbstractBattleShip {
    
	protected String name;
	
	protected int hits; 
	
	protected String shipOrientation;
	
	protected int[][] shipCoordinates ;
	
	public void setShipOrientation(){
		String[] str={"vertical","horizontal"};
		Random rand=new Random();
		int i;
		i=rand.nextInt(2);
		this.shipOrientation=str[i];
	}
	public abstract boolean checkAttack (int row,int column);
	
	public abstract String getName();

	public abstract int getHits() ;
	
	public abstract String getShipOrientation() ;
	
	public abstract void setHits(int numberOfHits) ;
	
	public abstract int[][] getShipCoordinates() ;
	
	public abstract void setShipCoordinates(int [][] coordinates) ;
	
	
	
	
}

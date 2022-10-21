package abdn.scnu.cs;
import java.util.*;
public class GameGrid extends AbstractGameGrid{
    public int width;
    public int height;
    public int numberOfShips;
    public GameGrid(int width,int height,int numberOfShips) {
        this.width=width;
        this.height=height;
        this.numberOfShips=numberOfShips;
        this.gameGrid=new String[height][width];
        this.ships=new AbstractBattleShip[numberOfShips];
        this.initializeGrid();
        generateShips(numberOfShips);
        for(int i=0;i<numberOfShips;i++){
            placeShip(ships[i]);
        }
        for(int i=0;i<numberOfShips;i++){
            for(int j=0;j<3;j++)gameGrid[ships[i].shipCoordinates[j][0]][ships[i].shipCoordinates[j][1]]="*";
        }
    }


    @Override
    public void initializeGrid() {
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                this.gameGrid[i][j]=".";
            }
        }
    }

    @Override
    public void generateShips(int numberOfShips) {
        BattleShip s=new BattleShip();
        for(int i=1;i<numberOfShips+1;i++){
            s=new BattleShip("Ship "+i);
            ships[i-1]=s;
        }
    }

    @Override
    public void placeShip(AbstractBattleShip ship) {
        Random r=new Random();
        int w=r.nextInt(width-2)+1;
        int h=r.nextInt(height-2)+1;
        ship.shipCoordinates=new int[3][2];
        ship.shipCoordinates[2][0]=h;
        ship.shipCoordinates[2][1]=w;
        if(ship.shipOrientation=="vertical"){
                ship.shipCoordinates[0][0]=h-1;
                ship.shipCoordinates[0][1]=w;
                ship.shipCoordinates[1][0]=h+1;
                ship.shipCoordinates[1][1]=w;
        }
        if(ship.shipOrientation=="horizontal"){
                ship.shipCoordinates[0][0]=h;
                ship.shipCoordinates[0][1]=w-1;
                ship.shipCoordinates[1][0]=h;
                ship.shipCoordinates[1][1]=w+1;
        }
    }
}

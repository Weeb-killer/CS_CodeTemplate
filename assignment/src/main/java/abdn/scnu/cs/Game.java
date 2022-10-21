package abdn.scnu.cs;

import java.util.Random;
import java.util.*;

public class Game implements GameControls{
    private PlayerGameGrid pg;
    private OpponentGameGrid og;
    public Game(int width,int height,int numberOfShips) {
        this.pg=new PlayerGameGrid(width,height,numberOfShips);
        this.og=new OpponentGameGrid(width,height,numberOfShips);
    }
    @Override
    public AbstractGameGrid getPlayersGrid(){
        return pg;
    }

    @Override
    public AbstractGameGrid getOpponentssGrid(){
        return og;
    }

    @Override
    public void playRound(String input) {
        int indexcomma=input.indexOf(",");
        int h1=Integer.parseInt(input.substring(0,indexcomma));
        int w1=Integer.parseInt(input.substring(indexcomma+1));
        exitGame(input);
        boolean yn=true;
        System.out.println("Player is attacking");
//        while(checkVictory()==false)
        for(int i=1;i<og.numberOfShips+1;i++){
            for (int j=0;j<3;j++){
                if (og.ships[i-1].shipCoordinates[j][0]==h1&&og.ships[i-1].shipCoordinates[j][1]==w1){
                    System.out.println("HIT Ship "+i+"!!!");
                    og.gameGrid[h1][w1]="X";
                    og.ships[i-1].checkAttack(h1,w1);
                    yn=false;
                }
                else{
                    if (i==og.numberOfShips&&j==2&&yn){
                        System.out.println("MISS!!!");
                        og.gameGrid[h1][w1]="%";
                    }
                }
            }
        }
        Random rm=new Random();
        int w2= rm.nextInt(pg.width);
        int h2= rm.nextInt(pg.height);
        System.out.println("Opponent is attacking"+"\n"+h2+","+w2);
        yn=true;
        for(int i=1;i<pg.numberOfShips+1;i++){
            for (int j=0;j<3;j++){
                if (pg.ships[i-1].shipCoordinates[j][0]==h2&&pg.ships[i-1].shipCoordinates[j][1]==w2){
                    System.out.println("HIT Ship "+i);
                    pg.ships[i-1].checkAttack(h2,w2);
                    pg.gameGrid[h2][w2]="X";
                    yn=false;
                }
                else{
                    if (i==pg.numberOfShips&&j==2&&yn){
                        System.out.println("MISS!!!");
                        pg.gameGrid[h2][w2]="%";
                    }
                }
            }
        }
        System.out.println("Player's GameGrid");
        pg.printGrid();
        System.out.println("Opponent's GameGrid");
        og.printGrid();
    }

    @Override
    public boolean checkVictory() {
        int pghits=0;
        int oghits=0;
        for(int i=0;i<pg.numberOfShips;i++){
            pghits+=pg.ships[i].hits;
            oghits+=og.ships[i].hits;
        }

        if (pghits==3*pg.numberOfShips&&oghits!=3*pg.numberOfShips){
            System.out.println("You have lost!");
            return true;
        }
        if (oghits==3*pg.numberOfShips&&pghits!=3*pg.numberOfShips){
            System.out.println("You have won!");
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void exitGame(String input) {
        if(input.equals("exit")){
            System.out.println("Exiting game – thank you for playing");
        }
    }
}

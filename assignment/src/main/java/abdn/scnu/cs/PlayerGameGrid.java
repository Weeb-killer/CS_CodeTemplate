package abdn.scnu.cs;

public class PlayerGameGrid extends GameGrid{
//    public String[][] TheGrid;
    public PlayerGameGrid(int width, int height, int numberOfShips) {
        super(width, height, numberOfShips);
//        this.TheGrid=new String[height][width];
//        for(int i=0;i<height;i++){
//            for(int j=0;j<width;j++){
//                TheGrid[i][j]=".";
//            }
//        }
//        for(int i=0;i<numberOfShips;i++){
//            for(int j=0;j<3;j++)gameGrid[ships[i].shipCoordinates[j][0]][ships[i].shipCoordinates[j][1]]="*";
//        }
    }
    public void printGrid(){
//        System.out.println("Player's grid");
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                System.out.print(gameGrid[i][j]);
                if(j==width-1){
                    System.out.println();
                }
            }
        }
    }
}

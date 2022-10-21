package abdn.scnu.cs;

public class OpponentGameGrid extends GameGrid{
//    public String[][] TheGrid;
    public OpponentGameGrid(int width, int height, int numberOfShips) {
        super(width, height, numberOfShips);
//        this.gameGrid=new String[height][width];
//        for(int i=0;i<height;i++){
//            for(int j=0;j<width;j++){
//                gameGrid[i][j]=".";
//            }
//        }
    }
    public void printGrid(){
//        System.out.println("Opponent's grid");
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                if (gameGrid[i][j]=="*"){
                    System.out.print(".");
                }
                else {
                    System.out.print(gameGrid[i][j]);
                }
                if(j==width-1){
                    System.out.println();
                }
            }
        }
//        for(int i=0;i<numberOfShips;i++){
//            for(int j=0;j<3;j++)TheGrid[ships[i].shipCoordinates[j][0]][ships[i].shipCoordinates[j][1]]="*";
//        }
    }

}

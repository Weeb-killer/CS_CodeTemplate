package abdn.scnu.cs;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class RunGame {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        int width = 0;
        int height = 0;
        int numberOfShips=0;
        try {
            System.out.println("Plz input the width of the Grid(it should be >=3)");
            width = sc1.nextInt();
            System.out.println("Plz input the height of the Grid(it should be >=3)");
            height= sc1.nextInt();
            System.out.println("Plz input the number of BattleShips(it should be >0)");
            numberOfShips = sc1.nextInt();
            Game g = new Game(width, height, numberOfShips);
            while (!g.checkVictory()) {
                System.out.println("Where do you want to strike");
                Scanner sc = new Scanner(System.in);
                String str = sc.nextLine();
                if (str.equals("exit")) {
                    g.exitGame(str);
                    break;
                }
                g.playRound(str);

            }
        } catch (Exception InputMismatchException) {
            System.out.println("Incorrect input");
        }



    }

}

import java.util.Scanner;

public class HumanVsGoblinsGame {

    public static void main(String[] args) {
        Land gameMap = new Land();
        boolean play = true;
        Scanner scanner = new Scanner(System.in);

        //todo
        do {
           gameMap.startGame();
            play = gameMap.playGame();
        } while (play);
    }
}


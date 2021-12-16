import java.util.Scanner;
import java.util.Arrays;

public class Land {
    public Human player;
    public Goblins blob;
    private String[][] gameMap;
    boolean dead;
    Scanner in = new Scanner(System.in);
    public Land(){
        gameMap = new String[][]{
                {" ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "},
        };
        player = new Human();
        blob = new Goblins();
//        dead = false;

    }

    public void startGame() {
        gameMap = new String[][]{
                {" ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "},
        };
        player = new Human();
        blob = new Goblins();
//        dead = false;
    }

    public boolean playGame() {

        Scanner input = new Scanner(System.in);
        String play;
        boolean currentMove = false;

        do{
            updateGameMap();
            printGameMap();
            blobMove();
            attack();
            if(!player.isDead(false)){
                currentMove = false;
            }
            while(!currentMove) {
                currentMove = playerMove();
            };
            refreshMove();
        }while(!player.isDead(currentMove));
        System.out.println("Would you like to play Again?");
        play = input.nextLine();
        return play.equals("y");
    }


// goblin position will depend on movement of player.
    void blobMove() {
        if(blob.getPosition()[1] != player.getPosition()[1]) {
            if(blob.getPosition()[1] > player.getPosition()[1]) makeMove(blob, "S");
            else makeMove(blob, "N");
        }
        else if(blob.getPosition()[0] != player.getPosition()[0]) {
            if(blob.getPosition()[0] > player.getPosition()[0]) makeMove(blob,"W");
            else makeMove(blob, "E");
        }
    }

    public void attack(){
        if(Arrays.equals(blob.getPosition(),player.getPosition())){
            System.out.println("Goblin Strength: " + blob.getStrength());
            System.out.println("Health: " + player.getHealth());
            player.setHealth(player.getHealth()-blob.getStrength());
            System.out.println("Looks like you've been attacked!");
            System.out.println("Health after attack: " + player.getHealth());

        }
    }


    boolean playerMove() {
        String nextMove = in.nextLine();
        switch(nextMove.toUpperCase()) {
            case "N":
                if (player.getPosition()[1] == 4) {
                    System.out.println("You can't move North.");
                    return false;
                } else {
                    makeMove(player, "N");
                    return true;
                }

            case "E":
                if (player.getPosition()[0] == 4) {
                    System.out.println("You can't move East.");
                    return false;
                } else {
                    makeMove(player, "E");
                    return true;
                }

            case "S":
                if (player.getPosition()[1] == 0) {
                    System.out.println("You can't move South.");
                    return false;
                } else {
                    makeMove(player, "S");
                    return true;
                }

            case "W":
                if (player.getPosition()[0] == 0) {
                    System.out.println("You can't move West.");
                    return false;
                } else {
                    makeMove(player, "W");
                    return true;
                }

            case "Q":
                    return true;

            default:
                System.out.println("Type letter. No Movement");
                return false;
        }

    }
    private void refreshMove() {
        player.setPosition(new int[]{player.getNextPosition()[0], player.getNextPosition()[1]});
        blob.setPosition(new int[]{blob.getNextPosition()[0], blob.getNextPosition()[1]});
    }

    private void printGameMap() {
        System.out.print(
                String.format("\n" +
                        "+------+------+------+------+------+\n" +
                        "|  %s  |  %s  |  %s  |  %s  |  %s  |\n" +
                        "+------+------+------+------+------+\n" +
                        "|  %s  |  %s  |  %s  |  %s  |  %s  |\n" +
                        "+------+------+------+------+------+\n" +
                        "|  %s  |  %s  |  %s  |  %s  |  %s  |\n" +
                        "+------+------+------+------+------+\n" +
                        "|  %s  |  %s  |  %s  |  %s  |  %s  |\n" +
                        "+------+------+------+------+------+\n" +
                        "|  %s  |  %s  |  %s  |  %s  |  %s  |\n" +
                        "+------+------+------+------+------+\n" +
                        "\n",


                        gameMap[0][4].equals(" ") ? "  " : gameMap[0][4],
                        gameMap[1][4].equals(" ") ? "  " : gameMap[1][4],
                        gameMap[2][4].equals(" ") ? "  " : gameMap[2][4],
                        gameMap[3][4].equals(" ") ? "  " : gameMap[3][4],
                        gameMap[4][4].equals(" ") ? "  " : gameMap[4][4],
                        gameMap[0][3].equals(" ") ? "  " : gameMap[0][3],
                        gameMap[1][3].equals(" ") ? "  " : gameMap[1][3],
                        gameMap[2][3].equals(" ") ? "  " : gameMap[2][3],
                        gameMap[3][3].equals(" ") ? "  " : gameMap[3][3],
                        gameMap[4][3].equals(" ") ? "  " : gameMap[4][3],

                        gameMap[0][2].equals(" ") ? "  " : gameMap[0][2],
                        gameMap[1][2].equals(" ") ? "  " : gameMap[1][2],
                        gameMap[2][2].equals(" ") ? "  " : gameMap[2][2],
                        gameMap[3][2].equals(" ") ? "  " : gameMap[3][2],
                        gameMap[4][2].equals(" ") ? "  " : gameMap[4][2],
                        gameMap[0][1].equals(" ") ? "  " : gameMap[0][1],
                        gameMap[1][1].equals(" ") ? "  " : gameMap[1][1],
                        gameMap[2][1].equals(" ") ? "  " : gameMap[2][1],
                        gameMap[3][1].equals(" ") ? "  " : gameMap[3][1],
                        gameMap[4][1].equals(" ") ? "  " : gameMap[4][1],

                        gameMap[0][0].equals(" ") ? "  " : gameMap[0][0],
                        gameMap[1][0].equals(" ") ? "  " : gameMap[1][0],
                        gameMap[2][0].equals(" ") ? "  " : gameMap[2][0],
                        gameMap[3][0].equals(" ") ? "  " : gameMap[3][0],
                        gameMap[4][0].equals(" ") ? "  " : gameMap[4][0]
                        ));
    }

    private void updateGameMap() {
        for (int x = 0; x < gameMap.length; x++) {
            for (int y = 0; y < gameMap[x].length; y++) {
                String playerIcon = "\uD83D\uDD7A";
                String goblinIcon = "\uD83D\uDC7A";
                if (player.getPosition()[0] == x && player.getPosition()[1] == y) gameMap[x][y] = playerIcon;
                else if(blob.getPosition()[0] == x && blob.getPosition()[1] == y) gameMap[x][y] = goblinIcon;
                else gameMap[x][y] = " ";
            }
        }
    }


    private void makeMove(Players player, String position ){
        switch(position){
            case "N":
                player.getNextPosition()[1] += 1;
                break;

            case "E":
                player.getNextPosition()[0] += 1;
                break;

            case "S":
                player.getNextPosition()[1] -= 1;
                break;

            case "W":
                player.getNextPosition()[0] -= 1;
                break;

            default:
                System.out.println("Can't make that move.");
                break;
        }
    }
}

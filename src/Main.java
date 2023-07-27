import java.util.Random;
import java.util.Scanner;

public class Main {
    private static char[][] arr = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
    private static int moves = 0;
    public static Random rand = new Random();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        char player = 'X';
        int choice;
        while (true) {
            if (player == 'X') {
                do {
                    System.out.println("Your turn (1-9): ");
                    choice = input.nextInt();
                } while (!isValidChoice(choice));
                int row = (choice - 1) / 3;
                int col = (choice - 1) % 3;
                arr[row][col] = player;
                player = 'O';
                moves++;
            } else {
                do {
                    choice = rand.nextInt(9) + 1;
                } while (!isValidChoice(choice));
                int row = (choice - 1) / 3;
                int col = (choice - 1) % 3;
                arr[row][col] = player;
                System.out.println("Computer's turn: " + choice);
                player = 'X';
                moves++;
            }
            display();
            if (checkWin()) {
                System.out.println("Player " + player + " wins!");
                break;
            }
            if (checkTie()) {
                System.out.println("Tie!");
                break;
            }
        }
        }

    public static void display(){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(j !=3 ) {
                    System.out.print(arr[i][j] + "  |");
                }else {System.out.print(arr[i][j]);}
            }
            System.out.println();
            System.out.println("-=-=-=-=-=-=-");
        }
    }
    public static boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (arr[i][0] == arr[i][1] && arr[i][1] == arr[i][2] && arr[i][0] != ' ') {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (arr[0][i] == arr[1][i] && arr[1][i] == arr[2][i] && arr[0][i] != ' ') {
                return true;
            }
        }
        if (arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2] && arr[0][0] != ' ') {
            return true;
        }
        if (arr[0][2] == arr[1][1] && arr[1][1] == arr[2][0] && arr[0][2] != ' ') {
            return true;
        }
        return false;
    }

    private static boolean isValidChoice(int choice) {
        if (choice < 1 || choice > 9) {
            return false;
        }
        int row = (choice - 1) / 3;
        int col = (choice - 1) % 3;
        return arr[row][col] != 'X' && arr[row][col] != 'O';
    }

public static boolean checkTie() {
    if (checkWin()) {
        return false;
    } else if (moves == 9) {
        return true;
    }
    return false;
}
}
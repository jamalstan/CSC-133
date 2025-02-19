package pkgTTTBackend;

import java.util.Scanner;

public class JsTTTBoard {
    private char[][] board;

    public JsTTTBoard() {
        board = new char[3][3];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void printBoard() {
        System.out.println("Current Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        boolean gameEnded = false;

        while (!gameEnded) {
            System.out.println("Enter your move: Row and column (separated by a space), or press 'q' to quit: ");

            if (scanner.hasNext("q")) {
                System.out.println("Game exited. Thanks for playing!");
                break;
            }

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter two numbers separated by a space.");
                scanner.nextLine();
                continue;
            }
            int row = scanner.nextInt();

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter two numbers separated by a space.");
                scanner.nextLine();
                continue;
            }
            int col = scanner.nextInt();
            scanner.nextLine(); // Consume any remaining input

            if (row < 0 || row >= 3 || col < 0 || col >= 3) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            if (board[row][col] != '-') {
                System.out.println("That cell is already marked. Try again.");
                continue;
            }

            board[row][col] = 'P';
            printBoard();

            if (isBoardFull()) {
                System.out.println("All positions have been filled. Game over!");
                gameEnded = true;
            }
        }
        scanner.close();
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}

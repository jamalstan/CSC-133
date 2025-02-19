package pkgAssignment_3Driver;

import static pkgTTTBackend.SlIOManager.*;

public class Driver {
    public static void main(String[] args) {
        pkgTTTBackend.SlTTTBoard my_board = new pkgTTTBackend.JsTTTBoard();

        initPrompt();
        printBoard(my_board);
        my_board.testPlay();
        System.out.println("\nStart interactive play");
        my_board.clearBoard();
        my_board.play();
    }
}  // public class Driver



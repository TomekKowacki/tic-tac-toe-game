package com.tictactoe_game.presentation;


import java.io.IOException;
import java.util.Scanner;

public class Communication {
    private char board[][];
    private Scanner scanner = new Scanner(System.in);

    public Communication(char[][] board) {
        this.board = board;
    }

    public String readName() throws IOException {
        String name = null;
        try {
            name = scanner.nextLine();
        } catch (Exception n) {
            System.out.println("Put your name again");
        }
        return name;
    }

    public void printField(char[][] board) {
        int dim = board.length;
        System.out.print("   ");
        for (int i = 0; i < dim; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int row = 0; row < dim; row++) {
            System.out.print(row + " ");
            System.out.print("|");
            for (int col = 0; col < dim; col++) {
                if(board[row][col] == 0){
                    board[row][col] = ' ';
                }
                System.out.print(board[row][col] + "|");

            }
            System.out.println();
        }
        System.out.println();
    }

    public String chooseSecondPlayer() {
        System.out.println("You want to play against the computer [c] or another player [p]?");
        return scanner.nextLine();

    }

    public String chooseGameVersion() {
        System.out.println("Do you want to play on a traditional [t] or extended board [e]?");
        return scanner.nextLine();

    }
}
package com.example.tictactoe_game.data;

import com.example.tictactoe_game.presentation.Communication;

import java.io.IOException;
import java.util.*;

public class Game extends Communication{

    private Player player1;
    private Player player2;
    private Scanner scanner = new Scanner(System.in);
    private static List emptyBoardChar;
    private int round = 0;
    private int chosenRow;
    private int chosenCol;

    public Game(Player player1, Player player2, char[][] board) {
        super(board);
        this.player1 = player1;
        this.player2 = player2;
    }

    public int getChosenRow() {
        return chosenRow;
    }

    public int getChosenCol() {
        return chosenCol;
    }

    public int nextRound(){
       return round++;
    }

    public Player checkRound(){
        if(round % 2 == 0){
            return player1;
        }else{
            return player2;
        }
    }

    public int readRow(char[][] board){
        System.out.println("Enter the row number");
        boolean isNoException = false;
        while (!isNoException) {
            try {
                chosenRow = scanner.nextInt();
            } catch (InputMismatchException o) {
                System.out.println("wrong data");
            }
            if (chosenRow < 0 || chosenRow >= board.length) {
                System.out.println("Wrong value. Please enter your choose again");
            }
            if((chosenRow >= 0 && chosenRow < board.length)) {
                isNoException = true;
            }
        }
        return chosenRow;
    }

    public int readCol(char[][] board){
        System.out.println("Enter the column number");
        boolean isNoException = false;
        while (!isNoException) {
            try {
                chosenCol = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("wrong data");
            }
            if (chosenCol < 0 || chosenCol >= board.length) {
                System.out.println("Wrong value. Please enter your choose again");
            }
            if((chosenCol >= 0 && chosenCol < board.length)) {
                isNoException = true;
            }
        }
        return chosenCol;
    }
    public void computerMove ( char[][] board) {
        int dim = board.length;
        boolean goodMove = false;

        Random random = new Random();
        int row = random.nextInt(board.length);
        int col = random.nextInt(board.length);

        while (!goodMove) {
            if (row+1 < board.length && board[row+1][col] == 0) {
                chosenRow = row;
                chosenCol = col;
                goodMove = true;
            } else if (row-1 >=0 && board[row-1][col] == 0) {
                chosenRow = row;
                chosenCol = col;
                goodMove = true;
            } else if (col+1 < board.length && board[row][col+1] == 0) {
                chosenRow = row;
                chosenCol = col;
                goodMove = true;
            } else if (col-1 >=0 && board[row][col-1] == 0) {
                chosenRow = row;
                chosenCol = col;
                goodMove = true;
            } else if (row+1 < board.length && col+1 < board.length && board[row+1][col+1] == 0) {
                chosenRow = row;
                chosenCol = col;
                goodMove = true;
            } else if (row-1 >=0 && col-1 >=0 && board[row-1][col-1] == 0) {
                chosenRow = row;
                chosenCol = col;
                goodMove = true;
            }else {
                row = random.nextInt(board.length);
                col = random.nextInt(board.length);
            }
        }
    }

    public boolean isPossibleToPutSymbol(char[][] board, Player player){
        if (board[chosenRow][chosenCol] == 0) {
            return true;
        } else if (player.getPlayerNumber() == 3) {
            return false;
        }
        System.out.println("This field is taken. Please select again");
        return false;
    }

}

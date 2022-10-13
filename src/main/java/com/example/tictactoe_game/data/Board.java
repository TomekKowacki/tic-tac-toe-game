package com.example.tictactoe_game.data;


public class Board {
    private char gameBoard[][];

    public Board(char[][] gameBoard) {
        this.gameBoard = gameBoard;
    }


    public void setGameBoard(char[][] gameBoard) {
        this.gameBoard = gameBoard;
    }
}

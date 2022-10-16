package com.example.tictactoe_game.presentation;

import com.example.tictactoe_game.data.BoardMismatchException;
import com.example.tictactoe_game.data.Game;
import com.example.tictactoe_game.data.Player;
import com.example.tictactoe_game.data.WinResult;

import java.io.IOException;

public class GameRunner {

    public static void main(String[] args) throws IOException {

        Player activePlayer;
        Player player2 = null;
        int gameVersion = 3;
        char[][] board = new char[3][3];
        boolean isWon = false;
        boolean isRowInteger = false;
        boolean isColInteger = false;

        String firstPlayerName;
        String secondPlayerName;

        Communication view = new Communication(board);

        System.out.println("First player - give your name...");
        firstPlayerName = view.readName();
        Player player1 = new Player(firstPlayerName, 'X', 1);

        String chosenPlayer = view.chooseSecondPlayer();
        if (chosenPlayer.equals("c")) {
            player2 = new Player("computer", 'O', 3);
        } else if (chosenPlayer.equals("p")) {
            System.out.println("Second player - give your name...");
            secondPlayerName = view.readName();
            player2 = new Player(secondPlayerName, 'O', 2);
        }
        String chosenVersion = view.chooseGameVersion();
        if (chosenVersion.equals("t")) {
            board = new char[3][3];
            gameVersion = 3;
        } else if (chosenVersion.equals("e")) {
            board = new char[10][10];
            gameVersion = 10;
        }

        Game game = new Game(player1, player2, board);
        WinResult test = new WinResult(gameVersion);

        System.out.println("The game starts...");

        view.printField(board);

        while (!isWon) {

            activePlayer = game.checkRound();

            if (activePlayer.getPlayerNumber() != 3) {
                System.out.println(activePlayer.getPlayerName());
                game.readRow(board);
                game.readCol(board);
            } else {
                game.computerMove(board);
            }

            if (game.isPossibleToPutSymbol(board, activePlayer)) {
                board[game.getChosenRow()][game.getChosenCol()] = activePlayer.getPlayerSymbol();
                view.printField(board);
                game.nextRound();
                if (test.gameWinResult(board, activePlayer)) {
                    if (activePlayer.getPlayerNumber() == 1 || activePlayer.getPlayerNumber() == 2) {
                        System.out.println("Congratulations " + activePlayer.getPlayerName() + " you WON");
                    } else {
                        System.out.println(player1 + "You lose");
                    }
                    isWon = true;
                } else if (test.drawResult(board)) {
                    System.out.println("Game ended in a DRAW");
                    isWon = true;
                }
            }
        }
    }
}

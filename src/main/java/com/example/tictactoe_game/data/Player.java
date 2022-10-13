package com.example.tictactoe_game.data;

public class Player {

    private final String playerName;
    private final char playerSymbol;
    private final int playerNumber;


    public Player(String playerName, char playerSymbol, int playerNumber) {
        this.playerName = playerName;
        this.playerSymbol = playerSymbol;
        this.playerNumber = playerNumber;
    }


    public String getPlayerName() {
        return playerName;
    }

    public char getPlayerSymbol() {
        return playerSymbol;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }


}

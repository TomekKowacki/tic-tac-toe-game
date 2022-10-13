package com.example.tictactoe_game.data;

public class WinResult{

    private int gameVersion;
    public WinResult(int gameVersion) {
        this.gameVersion = gameVersion;
    }

    public boolean checkWinInRows(char[][] board, Player player) {
        int dim = board.length;

        for (int col = 0; col < dim; col++) {
            boolean win = true;
            for (int row = 0; row < dim; row++) {
                if (board[col][row] != player.getPlayerSymbol()) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return true;
            }
        }
        return false;
    }

    public boolean checkWinInColumn(char[][] board, Player player) {
        int dim = board.length;
        for (int row = 0; row < dim; row++) {
            boolean win = true;
            for (int col = 0; col < dim; col++) {
                if (board[col][row] != player.getPlayerSymbol()) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return true;
            }
        }
        return false;
    }

    public boolean checkWinInFirstDiagonal(char[][] board, Player player){
        int dim = board.length;
        for (int i = 0; i < dim; i++) {
            if (board[i][i] != player.getPlayerSymbol()) {
                return false;
            }
        }
        return true;
    }

    public boolean checkWinInSecondDiagonal(char[][] board, Player player) {
        int dim = board.length;
        for (int i = 0; i < dim; i++) {
            if (board[i][dim - i - 1] != player.getPlayerSymbol()) {
                return false;
            }
        }
        return true;
    }

    public boolean gameWinResult(char[][] board, Player player){
        if(checkWinInRows(board, player) ||
            checkWinInColumn(board, player) ||
            checkWinInFirstDiagonal(board, player) ||
            checkWinInSecondDiagonal(board, player)) {
            return true;
        }
        return false;
    }

    public boolean drawResult(char[][] board){
        int dim = board.length;
        boolean draw = true;
        for (int col = 0; col < dim; col++) {

            for (int row = 0; row < dim; row++) {
                if (board[row][col] != 'O' && board[row][col] != 'X') {
                    draw = false;
                    break;
                }
            }
        }
        if (draw) {
            return true;
        }
        return false;
    }
}


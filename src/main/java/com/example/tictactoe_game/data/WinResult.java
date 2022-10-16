package com.example.tictactoe_game.data;

public class WinResult{

    private int gameVersion;
    public WinResult(int gameVersion) {
        this.gameVersion = gameVersion;
    }


    public boolean checkWinInRows(char[][] board, Player player) {
        int dim = board.length;
        boolean win = false;

        if(gameVersion == 3) {
            for (int col = 0; col < dim; col++) {
                win = true;
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
        }else if(gameVersion == 10){
            for (int row = 0; row < dim; row++) {
                for (int col = 0; col < dim; col++) {
                    int symbolInRow = 1;
                    if (board[row][col] == player.getPlayerSymbol()) {
                        for (int i = 1; i < 5; i++) {
                            if ((col + i) < dim && board[row][col + i] == player.getPlayerSymbol()) {
                                symbolInRow ++;
                                if (symbolInRow == 5) {
                                    win = true;
                                    break;
                                }
                            }
                        }
                    }else {
                        symbolInRow = 1;
                    }
                }
                if (win) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkWinInColumn(char[][] board, Player player) {
        int dim = board.length;
        boolean win = false;

        if(gameVersion == 3) {
        for (int row = 0; row < dim; row++) {
            win = true;
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
        }else if(gameVersion == 10){
            for (int col = 0; col < dim; col++) {
                for (int row = 0; row < dim; row++) {
                    int symbolInCol = 1;
                    if (board[row][col] == player.getPlayerSymbol()) {
                        for (int i = 1; i < 5; i++) {
                            if ((row + i) < dim && board[row + i][col] == player.getPlayerSymbol()) {
                                symbolInCol ++;
                                if (symbolInCol == 5) {
                                    win = true;
                                    break;
                                }
                            }
                        }
                    }else {
                        symbolInCol = 1;
                    }
                }
                if (win) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkWinInFirstDiagonal(char[][] board, Player player){
        int dim = board.length;
        boolean win = false;

        if(gameVersion == 3) {
            for (int i = 0; i < dim; i++) {
                if (board[i][i] != player.getPlayerSymbol()) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return true;
            }
        }else if(gameVersion == 10) {
            for (int i = 0; i < dim; i++) {
                int symbolInDimension1 = 1;
                for (int p = 0; p < dim-i; p++) {
                    if (board[i][p] == player.getPlayerSymbol()) {
                        for (int j = 1; j < 5; j++) {
                            if ((i+j) < dim && (p+j) < dim && board[i+j][p+j] == player.getPlayerSymbol()) {
                                symbolInDimension1++;
                                if (symbolInDimension1 == 5) {
                                    win = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if(win){
                return true;
            }
        }
        return false;
    }

    public boolean checkWinInSecondDiagonal(char[][] board, Player player) {
        int dim = board.length;
        boolean win = false;

        if(gameVersion == 3) {
            for (int i = 0; i < dim; i++) {
                if (board[i][dim-i-1] != player.getPlayerSymbol()) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return true;
            }
        }else if(gameVersion == 10) {

            for(int i=0; i<dim; i++){
                int symbolInDimension =1;
                for(int p=0; p<dim; p++){
                    if(board[i][p] == player.getPlayerSymbol()) {
                        for (int j = 1; j < 5; j++) {
                            if ((p+j) < dim && (i-j) >= 0 && board[i-j][p+j] == player.getPlayerSymbol()) {
                                symbolInDimension++;
                                if (symbolInDimension == 5) {
                                    win = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if(win){
                return true;
            }
        }
        return false;
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


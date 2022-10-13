package com.example.tictactoe_game;

import com.example.tictactoe_game.data.Player;
import com.example.tictactoe_game.data.WinResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WinCheckTest {


        Player playerO = new Player("playerO", 'O',2);
        Player playerX = new Player("playerX", 'X', 1);
        WinResult result = new WinResult(3);


    @Test
    void victoryOInRows(){
        //Given
        char[][] board1 = {{'O','O','O'}, {'0','0','0'}, {'0','0','0'}};
        char[][] board2 = {{'0','0','0'}, {'0','0','0'}, {'0','0','0'}};
        char[][] board3 = {{'0','0','0'}, {'0','0','0'}, {'O','O','O'}};
        //When
        boolean row1 = result.checkWinInRows(board1,playerO);
        boolean row2 = result.checkWinInRows(board2,playerO);
        boolean row3 = result.checkWinInRows(board3,playerO);
        //Then
        Assertions.assertEquals(true, row1);
        Assertions.assertEquals(false, row2);
        Assertions.assertEquals(true, row3);
    }

    @Test
    void victoryOInColumns(){
        //Given
        char[][] board1 = {{'O','0','0'}, {'O','0','0'}, {'O','0','0'}};
        char[][] board2 = {{'0','0','0'}, {'0','0','0'}, {'0','0','0'}};
        char[][] board3 = {{'0','0','O'}, {'0','0','O'}, {'0','0','O'}};
        //When
        boolean col1 = result.checkWinInColumn(board1,playerO);
        boolean col2 = result.checkWinInColumn(board2,playerO);
        boolean col3 = result.checkWinInColumn(board3,playerO);
        //Then
        Assertions.assertEquals(true, col1);
        Assertions.assertEquals(false, col2);
        Assertions.assertEquals(true, col3);
    }

    @Test
    void victoryOInDiagonal(){
        //Given
        char[][] board1 = {{'O','0','0'}, {'0','O','0'}, {'0','0','O'}};
        char[][] board2 = {{'0','0','O'}, {'0','O','0'}, {'O','0','0'}};
        char[][] board3 = {{'0','0','0'}, {'0','0','0'}, {'0','0','0'}};
        //When
        boolean diagonal1 = result.checkWinInFirstDiagonal(board1,playerO);
        boolean diagonal2 = result.checkWinInSecondDiagonal(board2,playerO);
        boolean withoutDiagonal = result.checkWinInColumn(board3,playerO);
        //Then
        Assertions.assertEquals(true, diagonal1);
        Assertions.assertEquals(true, diagonal2);
        Assertions.assertEquals(false, withoutDiagonal);
    }

    @Test
    void victoryXInRows(){
        //Given
        char[][] board1 = {{'X','X','X'}, {'0','0','0'}, {'0','0','0'}};
        char[][] board2 = {{'0','0','0'}, {'0','0','0'}, {'0','0','0'}};
        char[][] board3 = {{'0','0','0'}, {'0','0','0'}, {'X','X','X'}};
        //When
        boolean row1 = result.checkWinInRows(board1,playerX);
        boolean row2 = result.checkWinInRows(board2,playerX);
        boolean row3 = result.checkWinInRows(board3,playerX);
        //Then
        Assertions.assertEquals(true, row1);
        Assertions.assertEquals(false, row2);
        Assertions.assertEquals(true, row3);
    }

    @Test
    void victoryXInColumns(){
        //Given
        char[][] board1 = {{'X','0','0'}, {'X','0','0'}, {'X','0','0'}};
        char[][] board2 = {{'0','0','0'}, {'0','0','0'}, {'0','0','0'}};
        char[][] board3 = {{'0','0','X'}, {'0','0','X'}, {'0','0','X'}};
        //When
        boolean col1 = result.checkWinInColumn(board1,playerX);
        boolean col2 = result.checkWinInColumn(board2,playerX);
        boolean col3 = result.checkWinInColumn(board3,playerX);
        //Then
        Assertions.assertEquals(true, col1);
        Assertions.assertEquals(false, col2);
        Assertions.assertEquals(true, col3);
    }

    @Test
    void victoryXInDiagonal(){
        //Given
        char[][] board1 = {{'X','0','0'}, {'0','X','0'}, {'0','0','X'}};
        char[][] board2 = {{'0','0','X'}, {'0','X','0'}, {'X','0','0'}};
        char[][] board3 = {{'0','0','0'}, {'0','0','0'}, {'0','0','0'}};
        //When
        boolean diagonal1 = result.checkWinInFirstDiagonal(board1,playerX);
        boolean diagonal2 = result.checkWinInSecondDiagonal(board2,playerX);
        boolean withoutDiagonal = result.checkWinInColumn(board3,playerX);
        //Then
        Assertions.assertEquals(true, diagonal1);
        Assertions.assertEquals(true, diagonal2);
        Assertions.assertEquals(false, withoutDiagonal);
    }

    @Test
    void draw(){
        //Given
        char[][] board1 = {{'X','O','X'}, {'O','X','O'}, {'X','X','O'}};
        char[][] board2 = {{'O','X','O'}, {'X','O','X'}, {'O','X','O'}};
        char[][] board3 = {{'X','O','0'}, {'X','0','O'}, {'0','O','X'}};
        //When
        boolean draw1 = result.drawResult(board1);
        boolean draw2 = result.drawResult(board2);
        boolean draw3 = result.drawResult(board3);
        //Then
        Assertions.assertEquals(true, draw1);
        Assertions.assertEquals(true, draw2);
        Assertions.assertEquals(false, draw3);
    }
}

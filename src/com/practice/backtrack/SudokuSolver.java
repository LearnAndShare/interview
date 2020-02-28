package com.practice.backtrack;
/*
https://leetcode.com/problems/sudoku-solver/

 */
public class SudokuSolver {
    private static final char EMPTY_ENTRY = '.';
    public void solveSudoku(char[][] board) {
        canSolveSudoku(board,0,0);
    }

    private boolean canSolveSudoku(char[][] board, int row, int col) {


        if(col == board[row].length){
            col =0;
            row++;
            if(row >= board.length){
                return true;
            }
        }

        if(board[row][col] != EMPTY_ENTRY){
            canSolveSudoku(board,row,col+1);
        }

        for(int i = 1;i<=9; i++){
            char c = (char)(1+'0');
            if(canPlaceCharOnBoard(row,col,c)){
                board[row][col] = c;
                if(canSolveSudoku(board,row,col+1))
                    return true;
                board[row][col] = EMPTY_ENTRY;
            }

        }
        return false;
    }

    private boolean canPlaceCharOnBoard(int row, int col, char c) {
        return true;
    }


}

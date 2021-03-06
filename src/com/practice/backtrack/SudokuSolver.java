package com.practice.backtrack;
/*
https://leetcode.com/problems/sudoku-solver/
Complexity Analysis
Time complexity is constant here since the board size is fixed and there is no N-parameter to measure. Though let's discuss the number of operations needed :
(9!)^9. Let's consider one row, i.e. not more than 9 cells to fill. There are not more than 9 possibilities for the first number to put, not more than 9×8 for the second one, not more than 9×8×7 for the third one etc. In total that results in not more than 9! possibilities for a just one row, that means not more than (9!)^9operations in total. mes !
Space complexity : the board size is fixed, and the space is used to store board, rows, columns and boxes structures, each contains 81 elements
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
            return canSolveSudoku(board,row,col+1);
        }
        for(int i = 1;i<=9; i++){
            char c = (char)(i+'0');
            if(canPlaceCharOnBoard(row,col,c,board)){
                board[row][col] = c;
                if(canSolveSudoku(board,row,col+1))
                    return true;
                board[row][col] = EMPTY_ENTRY;
            }

        }
        return false;
    }

    private boolean canPlaceCharOnBoard(int row, int col, char c, char[][] board) {
        //Check row
        for (int i = 0; i < board[0].length; i++) {
            if (board[row][i] == c)
                return false;
        }
        //Check column
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == c)
                return false;
        }

        int startRowIdx = row / 3;
        int startColIdx = col / 3;
        int topLeftOfSubBoxRow = startRowIdx * 3;
        int topLeftOfSubBoxCol = startColIdx * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[topLeftOfSubBoxRow + i][topLeftOfSubBoxCol + j] == c) {
                    return false;
                }
            }

        }

        return true;
    }


}

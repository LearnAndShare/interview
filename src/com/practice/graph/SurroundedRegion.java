package com.practice.graph;
/*
https://leetcode.com/problems/surrounded-regions/
 */
public class SurroundedRegion {
    public void solve(char[][] board) {
        if(board == null || board.length == 0)
            return;
        //Process top and bottom border
        for(int i=0;i<board[0].length;i++){
            dfs(board,0,i);
            dfs(board,board.length-1,i);
        }

        //Process left and right border
        for(int i=0;i<board.length;i++){
            dfs(board,i,0);
            dfs(board,i,board[0].length-1);
        }

        //process the board
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                } else if(board[i][j] == '1'){
                    board[i][j] = 'O';
                }
            }
        }

    }

    public void dfs(char[][] board,int i,int j){
        if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j] != 'O')
            return;
        board[i][j] = '1';
        dfs(board,i-1,j);
        dfs(board,i+1,j);
        dfs(board,i,j+1);
        dfs(board,i,j-1);

    }

    public static void main(String[] args) {
        SurroundedRegion sr = new SurroundedRegion();
        char[][] board = new char[][]{{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};


        sr.solve(board);

    }
}

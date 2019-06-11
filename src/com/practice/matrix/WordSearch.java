package com.practice.matrix;

/*
https://leetcode.com/problems/word-search/

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0|| word == null|| word.length() == 0)
            return false;
        boolean result = false;
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[i].length;j++) {
                result = dfs(board, i, j, word, 0);
                if(result)
                    return result;

            }
        return false;
    }

    public boolean dfs(char[][] board,int i,int j,String word,int idx){
        if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j] == '#' || board[i][j]!= word.charAt(idx))
            return false;
        if(board[i][j]== word.charAt(idx)){

            if(idx == word.length() -1)
                return true;
            char tmp = board[i][j];
            board[i][j] = '#';

            //left
           boolean  r =  dfs(board,i,j-1,word,idx+1)||
            //right
            dfs(board,i,j+1,word,idx+1)||
            //top
            dfs(board,i-1,j,word,idx+1)||
            //bottom
            dfs(board,i+1,j,word,idx+1);
            board[i][j] = tmp;

            return r;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        WordSearch ws = new WordSearch();
        System.out.println(ws.exist(board,"SEE"));
    }
}

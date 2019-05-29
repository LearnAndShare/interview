package com.practice.matrix;

public class ValidTicTacToe {
    public boolean validTicTacToe(String[] board) {
        if(board == null || board.length == 0)
            return true;

        int numX = 0;
        int numO = 0;
        char[] b = new char[9];
        int i = 0;
        for (String s : board) {

            for (char c : s.toCharArray()) {
                b[i++] = c;
                if(c == 'X')
                    ++numX;
                if(c == 'O')
                    ++numO;
            }

        }


        if(numX == numO || numX == numO+1){
            if (checkIfCharWins(b, 'O')) {
                // Check if 'X' is also winner, then
                // return false
                if (checkIfCharWins(b, 'X')) {
                    return false;
                }

                // Else return true xCount and yCount are same
                return (numO == numX);
            }

            if (checkIfCharWins(b, 'X') && numX != numO + 1) {
                return false;
            }
            return true;
        }


        return false;
    }



    public int[][] win = new int[][]{{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public boolean checkIfCharWins(char[] board,char c){
        for(int i=0;i<win.length;i++){
            if(board[win[i][0]] == c && board[win[i][1]] == c && board[win[i][2]] == c){
                return true;
            }
        }
        return false;
    }
}






























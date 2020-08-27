package com.practice.backtrack;

import java.util.ArrayList;
import java.util.List;

/*

https://leetcode.com/problems/n-queens-ii/
 */
public class NQueens {
    public int totalNQueensII(int n) {

        List<Integer> colsPlacement = new ArrayList<>();
        List<List<String>>  results = new ArrayList<>();
        solveNQueens(0,n,colsPlacement,results);
        return results.size();
    }

    public List<List<String>> totalNQueens(int n) {

        List<Integer> colsPlacement = new ArrayList<>();
        List<List<String>>  results = new ArrayList<>();

        solveNQueens(0,n,colsPlacement,results);

       // List<List<String>> boardPos = generateBoard(results);
        return results;
    }

    private List<String> generateBoard(List<Integer> cols) {
        List<String> rowVal = new ArrayList<>();
        for (int row = 0; row < cols.size(); row++) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < cols.size(); i++) {
                if (i == cols.get(row)){
                    sb.append("Q");
                } else{
                    sb.append(".");
                }
            }
            rowVal.add(sb.toString());

        }
        return rowVal;
    }

    private void solveNQueens(int rowIdx, int n, List<Integer> colsPlacement, List<List<String>> results) {
        if(rowIdx == n){

            results.add(generateBoard(colsPlacement));
            return;
        }

        for(int i=0;i<n;i++){
            colsPlacement.add(i);
            if(isValidPlacement(colsPlacement)){
                solveNQueens(rowIdx+1,n,colsPlacement,results);
            }
            colsPlacement.remove(colsPlacement.size()-1);
        }
    }

    private boolean isValidPlacement(List<Integer> colsPlacement) {
        /*
         1.) colDiff == 0
          If the absolute difference in columns is 0 then we placed in a column being
          attacked by the i'th queen.
        2.) colDiff == rowDiff
          If the absolute difference in columns equals the distance in rows from the
          i'th queen we placed, then the queen we just placed is attacked diagonally.
         */
        int currentRow = colsPlacement.size()-1;
        for(int j=0;j<colsPlacement.size()-1;j++){
            int colDiff = Math.abs(colsPlacement.get(currentRow) - colsPlacement.get(j));
            int rowDiff = Math.abs(currentRow-j);
            if(colDiff == 0 || rowDiff == colDiff)
                return false;

        }
        return true;
    }

    public static void main(String[] args) {
        NQueens nq = new NQueens();
        System.out.println(nq.totalNQueensII(4));
        System.out.println(nq.totalNQueens(4));
    }
}

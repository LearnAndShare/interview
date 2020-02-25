package com.practice.matrix;
/*
https://leetcode.com/problems/set-matrix-zeroes/
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:

Input:
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output:
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]

Example 2:

Input:
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output:
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]

 */
public class MatrixSet0 {
    public void setZeroes(int[][] matrix) {
        boolean [] r = new boolean[matrix.length];
        boolean [] c = new boolean[matrix[0].length];
        int ridx = 0;
        int cidx =0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    r[i] = true;
                    c[j] = true;
                }
            }
        }

        for(int i=0;i<r.length;i++){
            if(r[i]) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for(int i=0;i<c.length;i++){
            if(c[i] == true)
                for(int j=0;j<matrix.length;j++){
                    matrix[j][i] = 0;
                }
        }
    }

    public static void main(String[] args) {
        MatrixSet0 ms = new MatrixSet0();
        ms.setZeroes(new int[][]{{1,1,1},{1,0,1},{1,1,1}});
    }
}

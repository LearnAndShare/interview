package com.practice.matrix;
/*
Given a boolean matrix mat[M][N] of size M X N,
modify it such that if a matrix cell mat[i][j] is 1 (or true) then make all the cells of ith row and jth column as 1
 */

public class Fill2DMatrixWith1 {
    public void fill(int in[][]){
        boolean row[] = new boolean[in.length];
        boolean col[] = new boolean[in[0].length];
        for(int i=0;i<in.length;i++){
            for(int j=0;j<in[0].length;j++){
                if(in[i][j] == 1){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for(int i=0;i<row.length;i++){
            for(int j=0;j<col.length;j++){
                if(row[i]||col[j]){
                    in[i][j] = 1;
                }
            }
        }
    }

    public static void main(String args[]){
        int input[][] = {{0,0,1,0,0,0},{0,0,0,0,0,0},{1,0,0,0,0,0}};
        Fill2DMatrixWith1 fd = new Fill2DMatrixWith1();
        fd.fill(input);
        for(int i=0; i < input.length; i++){
            for(int j=0; j < input[i].length; j++){
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }
    }
}

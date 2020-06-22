package com.practice.matrix;

public class RotateMatrix {
    public void rotateExtraMem(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;
        int n = matrix.length;
        int[][] temp = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                temp[j][n-i-1]=matrix[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = temp[i][j];
            }
        }
    }

    /*
    reverse the matrix
    Then transpose the matrix
     */

    public void rotateMatrixUsingTranspose(int[][] matrix){

    }

    public void swap(int[][] matrix,int sr,int sc,int er,int ec){
        int temp  =matrix[sr][sc];
        matrix[sr][sc] = matrix[er][ec];
        matrix[er][ec] = temp;
    }

    //https://www.youtube.com/watch?v=HxMngN22YzA
    public void rotateMatrix(int[][] matrix){
        if (matrix == null || matrix.length == 0)
            return;
        int low = 0;
        int high = matrix.length-1;
        while(low<high){
            int r = high - low;
            for(int i=0;i<r;i++){
                int idx = low +i;
                //swap top left with top right
                swap(matrix,low,idx,idx,high);//As top right will be moving down for every rotation so row will be changing
                //swap top left with bottom right
                swap(matrix,low,idx,high,high-i);//As bottom right will be moving left for every rotation so column will be changing
                //swap top left with bottom left
                swap(matrix,low,idx,high-i,low);//As bottom left will be moving up for every rotation so row will be changing
            }
            low++;
            high--;
        }
    }

   public void printMatrix(int[][]r){
        for (int i = 0; i < r.length; i++) {
            for (int j = 0; j < r[i].length; j++) {
                System.out.print(r[i][j] + " ");
            }
            System.out.println("\n");
        }
    }
    public static void main(String[] args) {
//        int[][] m =new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
//        int[][] m =new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] m =new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        RotateMatrix rm = new RotateMatrix();
        rm.printMatrix(m);

        rm.rotateMatrix(m);
        System.out.println("===================");
        rm.printMatrix(m);
    }
}

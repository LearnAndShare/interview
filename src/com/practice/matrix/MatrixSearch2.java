package com.practice.matrix;

public class MatrixSearch2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)
            return false;
        int i  = 0;
        int j = matrix[0].length -1 ;
        while(i<=matrix.length - 1 && j>=0){
            if(matrix[i][j] == target)
                return true;
            if(target > matrix[i][j])
                i =i +1;
            else
                j = j-1;
        }
            return false;
    }

    public static void main(String[] args) {
        MatrixSearch2 ms = new MatrixSearch2();
        System.out.println(ms.searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}},12));
    }

}

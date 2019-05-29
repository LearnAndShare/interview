package com.practice.matrix;

public class MatrixSearch {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;int r = matrix.length;
        int c = matrix[0].length;
        int end = (r*c) -1;

        while(start <= end){
            int mid = (start +end)/2;
            int midX = mid/c;
            int midY = mid%c;
            if(matrix[midX][midY] == target){
                return true;
            } else if(target > matrix[midX][midY]){
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        return false;
    }
}

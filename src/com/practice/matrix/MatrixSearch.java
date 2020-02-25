package com.practice.matrix;
/*
https://leetcode.com/problems/search-a-2d-matrix/
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.

Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true

Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false


 */
public class MatrixSearch {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)
            return false;
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

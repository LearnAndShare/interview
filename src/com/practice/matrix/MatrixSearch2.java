package com.practice.matrix;
/*
https://leetcode.com/problems/search-a-2d-matrix-ii/
Time complexity : O(n+m)
The key to the time complexity analysis is noticing that, on every iteration (during which we do not return true) either row or col is is decremented/incremented exactly once. Because row can only be decremented m times and col can only be incremented n times before causing the while loop to terminate, the loop cannot run for more than
n+m iterations. Because all other work is constant, the overall time complexity is linear in the sum of the dimensions of the matrix.
Space complexity : O(1)
Because this approach only manipulates a few pointers, its memory footprint is constant.
 */
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

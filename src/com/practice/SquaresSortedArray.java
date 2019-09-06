package com.practice;

import java.util.Arrays;

/*
Squares of a Sorted Array
Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.



Example 1:

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Example 2:

Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 */
public class SquaresSortedArray {
    public int[] sortedSquares(int[] A) {
        if(A == null)
            return A;
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i]*A[i];
        }
        Arrays.sort(A);
        return A;
    }

    public int[] sortedSquares2(int[] A) {

        if( A == null)
            return null;
        int[] n = new int[A.length];
        int nidx = 0;
        int idx = -1;
        for(int i=0;i<A.length;i++){
            if(A[i]>=0){
                idx = i-1;
                break;
            }
        }
        int j = A.length;
        if(idx<0){
            for(int i=0;i<A.length;i++){
                n[i] = A[i]*A[i];
            }
        } else {
            j = idx + 1;
            while(idx>=0 && j< A.length){
                int negSquare = A[idx]*A[idx];
                int posSquare = A[j]*A[j];
                if(negSquare<posSquare){
                    n[nidx++] = negSquare;
                    idx--;
                } else {
                    n[nidx++] = posSquare;
                    j++;
                }
            }
        }

        while(idx>=0){
            n[nidx++] = A[idx]*A[idx];
            idx--;
        }

        while(j<A.length){
            n[nidx++] = A[j]*A[j];
            j++;
        }
        return n;

    }

    public static void main(String[] args) {
        SquaresSortedArray sq = new SquaresSortedArray();
        int[] num = new int[]{1};
        num = sq.sortedSquares2(num);
        for (int i : num) {
            System.out.print(i+" ");
        }
    }
}

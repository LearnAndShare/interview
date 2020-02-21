package com.practice.dynamic;
/*
Given an array of non negative numbers and a total, is there subset of numbers in this array which adds up
 * to given total. Another variation is given an array is it possible to split it up into 2 equal
 * sum partitions. Partition need not be equal sized. Just equal sum.
 */
public class SubsetSum {
    public boolean subsetSum(int input[], int total) {
        boolean[][] b = new boolean[input.length+1][total+1];
        for(int i=0;i<b.length;i++){
            b[i][0] = true;
        }
        for(int i=1;i<=input.length;i++){
            for(int j=0;j<=total;j++){
                if(input[i-1]<=j){
                 b[i][j] = b[i-1][j]||b[i-1][j-input[i-1]];
                } else {
                    b[i][j] = b[i-1][j];
                }
            }
        }
        return b[input.length][total];
    }
    public static void main(String args[]) {
        SubsetSum ss = new SubsetSum();


        int arr1[] = {2, 3, 7, 8};
        System.out.print(ss.subsetSum(arr1, 11));

    }
}

package com.practice.dynamic;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
This problem is variation of knapsack or subset sum problem
https://leetcode.com/problems/partition-equal-subset-sum/
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        if(nums ==null)
            return false;
        int sum = Arrays.stream(nums).sum();
        if(sum %2 != 0)
            return false;
        sum = sum/2;
        boolean [][] b = new boolean[nums.length+1][sum+1];
        for(int i=0;i<b.length;i++)
            b[i][0] = true;

        for(int i=1;i<=nums.length;i++){
            for(int j=0;j<=sum;j++){
                if(nums[i-1]<=j){
                    b[i][j] = b[i-1][j]||b[i-1][j-nums[i-1]];
                } else {
                    b[i][j] = b[i-1][j];
                }
            }
        }
        return b[nums.length][sum];
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum ps = new PartitionEqualSubsetSum();
        int arr[] = {1, 3, 5, 5, 2, 1, 1, 6};
        System.out.println(ps.canPartition(null));
    }
}

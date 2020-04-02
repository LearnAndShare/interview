package com.practice.array;
/*
https://leetcode.com/problems/maximum-subarray/
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

 */
public class MaxSumSubArray {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length ==0 )
            return 0;
        if(nums.length == 1)
            return nums[0];
        int max = nums[0];
        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        for(int i=1;i<nums.length;i++){
           max = Math.max(max,arr[i-1]);
            arr[i] = Math.max(arr[i-1]+nums[i],nums[i]);
        }
        max = Math.max(max,arr[nums.length-1]);
        return max;
    }

    public int maxSubArray2(int[] nums) {
        if(nums == null || nums.length ==0 )
            return 0;
        int maxTillNow=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            maxTillNow = Math.max(maxTillNow+nums[i],nums[i]);
            max = Math.max(max,maxTillNow);
        }
        return max;
    }


    public static void main(String[] args) {
        MaxSumSubArray ms = new MaxSumSubArray();
        System.out.println(ms.maxSubArray2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}

package com.practice.dynamic;
/*
https://leetcode.com/problems/jump-game-ii/
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example:

Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.

Note:

You can assume that you can always reach the last index.

 */
public class MinJumpsToReachEnd {

    public int minJump(int arr[],int result[]){

        int []jump = new int[arr.length];
        jump[0] = 0;
        for(int i=1; i < arr.length ; i++){
            jump[i] = Integer.MAX_VALUE-1;
        }
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++){

                if((j+arr[j])>=i){
                    jump[i] = Math.min(jump[j]+1,jump[i]);
                }
            }
        }

        return jump[jump.length-1];
    }

    public int minJumpDP(int[] nums){
        if (nums == null || nums.length < 2) return 0;
        int maxStep = nums[0], lastMax = nums[0], minVal = 1;
        for (int i = 1; i < nums.length; i++) {
            maxStep = Math.max(maxStep, nums[i] + i);
            if (i == lastMax && i != nums.length - 1) {
                lastMax = maxStep;
                minVal += 1;
            }
        }
        return minVal;
    }

    public static void main(String[] args) {
        MinJumpsToReachEnd m = new MinJumpsToReachEnd();
        System.out.println(m.minJumpDP(new int[]{2,3,1,1,4}));
    }

}

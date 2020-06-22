package com.practice.array;
/*
https://leetcode.com/problems/move-zeroes/
Given an array nums, write a function to move all 0's to the end of it while maintaining
the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
 */
public class MoveZero {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length <=1)
            return;
        int j = 0;
        for (int i=0;i<nums.length ;i++) {
            if(nums[i] != 0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }

    }

    public static void main(String[] args) {
        MoveZero mv = new MoveZero();
        int [] n = new int[]{0,1,0,3,12};
        mv.moveZeroes(n);
        for (int i : n) {
            System.out.print(i);
        }

    }
}

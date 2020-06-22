package com.practice.array.medium;
/*
https://leetcode.com/problems/jump-game/
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.


 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        if(nums== null || nums.length == 0)
            return true;
        if(nums[0]==0)
            return false;
        boolean []b = new boolean[nums.length];
        b[0]=true;
        int laststep = nums.length-1;
        for (int i = 0; i < nums.length; i++) {
            if(b[i]) {
                if (nums[i] + i >= laststep)
                    return true;
                for (int j = i; j <= nums[i] + i ; j++)
                    b[j] = true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        JumpGame jg = new JumpGame();
        System.out.println(jg.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(jg.canJump(new int[]{3,2,1,0,4}));
        System.out.println(jg.canJump(new int[]{1,2,3}));
    }
}

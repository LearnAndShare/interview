package com.practice.slidingwindow.easy;
/*
https://leetcode.com/problems/max-consecutive-ones/
Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:

Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.

Note:

    The input array will only contain 0 and 1.
    The length of input array is a positive integer and will not exceed 10,000

 */
public class MaxConsecutiveOnes {


    public int findMaxConsecutiveOnesSlidingWindow(int[] nums) {
        int left= 0,right = 0;
        int max = 0;

        while(right<nums.length){
            if(nums[right] == 1){
                right ++;
            } else {
                right++;
                left = right;
            }
            max = Math.max(max,right-left);

        }
        return max;
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count =0;
        for(int i:nums){
            if(i== 1){
                ++count;
                max = Math.max(count,max);
            } else {
                count = 0;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnes ms = new MaxConsecutiveOnes();
        System.out.println(ms.findMaxConsecutiveOnes(new int[]{0, 1}));
        System.out.println(ms.findMaxConsecutiveOnes(new int[]{1, 1, 1, 1}));
        System.out.println("{0,0,0,0}::"+ms.findMaxConsecutiveOnes(new int[]{0,0,0,0}));
        System.out.println("[1,1,0,1,1,1]::"+ms.findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));


        System.out.println("===============Sliding Window=====================");
        System.out.println(ms.findMaxConsecutiveOnesSlidingWindow(new int[]{0, 1}));
        System.out.println(ms.findMaxConsecutiveOnesSlidingWindow(new int[]{1, 1, 1, 1}));
        System.out.println("{0,0,0,0}::"+ms.findMaxConsecutiveOnesSlidingWindow(new int[]{0,0,0,0}));
        System.out.println("[1,1,0,1,1,1]::"+ms.findMaxConsecutiveOnesSlidingWindow(new int[]{1,1,0,1,1,1}));
    }
}

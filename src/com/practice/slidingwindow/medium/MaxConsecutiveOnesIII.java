package com.practice.slidingwindow.medium;
/*
https://leetcode.com/problems/max-consecutive-ones-iii/
Given an array A of 0s and 1s, we may change up to K values from 0 to 1.

Return the length of the longest (contiguous) subarray that contains only 1s.



Example 1:

Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
Output: 6
Explanation:
[1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.

Example 2:

Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
Output: 10
Explanation:
[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.

 */
public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int K) {
        int l=0,r=0;
        int numZero = 0;
        int maxOnes = 0;
        while (r<nums.length){
            if(nums[r] == 0)
                ++numZero;
            while(numZero>K){
                if(nums[l++] == 0) {
                    --numZero;
                }
            }

            maxOnes=Math.max(maxOnes,r-l+1);
            r++;
        }
        return maxOnes;
    }
}

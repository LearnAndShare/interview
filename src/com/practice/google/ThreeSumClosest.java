package com.practice.google;

import java.util.Arrays;

/*
https://leetcode.com/problems/3sum-closest/
Given an array nums of n integers and an integer target,
find three integers in nums such that the sum is closest to target.
Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).


 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
            if(nums == null || nums.length == 0)
                return 0;
            int res = 0;
        Arrays.sort(nums);
            int dist = Integer.MAX_VALUE;
            for(int i=0;i<nums.length-2;i++){
                int l= i+1;
                int r = nums.length -1;
                while(l<r){
                    int sum = nums[l] + nums[r] + nums[i];
                    if(sum== target)
                        return sum;
                    int diff = Math.abs(target-sum);
                    if(diff<dist){
                        res= sum;
                        dist=diff;
                    }

                    if(sum <target){
                        l++;
                    } else {
                        r--;
                    }
                }
            }
            return res;
    }

    public static void main(String[] args) {
        ThreeSumClosest ts = new ThreeSumClosest();
        System.out.println(ts.threeSumClosest(new int[]{-1, 2}, 1));
    }
}

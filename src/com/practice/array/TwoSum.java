package com.practice.array;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/two-sum/
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].


 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] idx = new int[2];
        Map<Integer,Integer> m = new HashMap<>();
       for(int i=0;i<nums.length;i++){
           m.put(nums[i],i);
       }
        for(int i=0;i<nums.length;i++){
            if(m.containsKey(target-nums[i]) && m.get(target-nums[i])!=i){
                idx[0] = i;
                idx[1] = m.get(target-nums[i]);
                break;
            }
        }
        return idx;
    }
//Given nums =[0,4,3,0], target = 0,

    public int[] twoSumAnotherSol(int[] nums, int target) {
        int[] idx = new int[2];
        Map<Integer,Integer> m = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(m.containsKey(nums[i]) ){
                idx[0] = m.get(nums[i]);
                idx[1] = i;
                return idx;
            } else {
                m.put(target-nums[i],i);
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        for (int i : ts.twoSumAnotherSol(new int[]{2, 7, 11, 15}, 9)) {
            System.out.println(i);
        }

        for (int i : ts.twoSumAnotherSol(new int[]{0,4,3,0}, 0)) {
            System.out.println(i);
        }
    }
}

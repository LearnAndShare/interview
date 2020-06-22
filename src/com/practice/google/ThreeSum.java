package com.practice.google;

import java.util.*;

/*
https://leetcode.com/problems/3sum/
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        if(nums== null || nums.length == 0){
            return  new ArrayList<List<Integer>>();
        }
        List<List<Integer>> list=new ArrayList<>();


        Set<List<Integer>> set = new HashSet<>();
//        [-1, 0, 1, 2, -1, -4]
        for(int i=0;i<nums.length;i++){
            int target = 0- nums[i] ;
            Map<Integer,Integer> m = new HashMap<>();
            for(int j=0;j<nums.length;j++){
                if(i!=j){
                    if(m.containsKey(nums[j])){
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[m.get(nums[j])]);
                        Collections.sort(l);
                        set.add(l);
                    } else {
                        m.put(target-nums[j],j);
                    }
                }
            }
        }
        list.addAll(set);

        return list;
    }

    public static void main(String[] args) {
        ThreeSum ts= new ThreeSum();
        System.out.println(ts.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}

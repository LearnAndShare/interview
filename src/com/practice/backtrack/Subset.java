package com.practice.backtrack;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/subsets/
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]


 */
public class Subset {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsetList = new ArrayList<>();
        helper(nums,subsetList,new ArrayList<>(),0);
        return subsetList;
    }

    private void helper(int[] nums, List<List<Integer>> subsetList, List<Integer>tmpList,int start) {

        subsetList.add(new ArrayList<>(tmpList));
        for(int i=start; i < nums.length; i++){
            tmpList.add(nums[i]);
            helper(nums,subsetList,tmpList,i+1);
            tmpList.remove(tmpList.size()-1);
        }
    }


    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        output.add(new ArrayList<Integer>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList();
            for (List<Integer> curr : output) {
                newSubsets.add(new ArrayList<Integer>(curr){
                    {add(num);}}
                    );
            }
            for (List<Integer> curr : newSubsets) {
                output.add(curr);
            }
        }
        return output;
    }
    public static void main(String[] args) {
        Subset s = new Subset();
        List<List<Integer>>  l = s.subsets(new int[]{1,2,3});
        l.forEach(e-> System.out.println(e));
    }
}

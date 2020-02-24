package com.practice.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/subsets-ii/
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]


 */
public class SubsetII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(list,new ArrayList<Integer>(),nums,0);
        return list;

    }

    private void backTrack(List<List<Integer>> list, ArrayList<Integer> subsetList, int[] nums, int start) {
        list.add(new ArrayList<>(subsetList));

        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i-1] == nums[i])
                continue;
            subsetList.add(nums[i]);
            backTrack(list,subsetList,nums,i+1);
            subsetList.remove(subsetList.size()-1);
        }
    }

    public static void main(String[] args) {
        SubsetII s  = new SubsetII();
        s.subsetsWithDup(new int[]{1,2,2}).forEach(e-> System.out.println(e));
    }
}

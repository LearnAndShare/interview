package com.practice.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/combination-sum-ii/

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]


 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if(candidates == null || candidates.length == 0)
            return list;
        Arrays.sort(candidates);
        backTrack(candidates,list,new ArrayList<Integer>(),target,0);
        return list;
    }

    private void backTrack(int[] nums, List<List<Integer>> list, ArrayList<Integer> tmpList, int remain, int start) {
        if(remain < 0)
            return;
        if(remain == 0)
            list.add(new ArrayList<>(tmpList));
        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i] == nums[i-1])
                continue;
            tmpList.add(nums[i]);
            backTrack(nums,list,tmpList,remain-nums[i],i+1);
            tmpList.remove(tmpList.size()-1);
        }
    }

    public static void main(String[] args) {
        CombinationSumII cs  = new CombinationSumII();
        cs.combinationSum2(new int[]{2,5,2,1,2},5).forEach(e-> System.out.println(e));
    }
}

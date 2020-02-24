package com.practice.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/subsets/discuss/27281/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning
https://leetcode.com/problems/combination-sum/
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]

Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]


 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates,list,new ArrayList<Integer>(),target,0);
        return list;
    }

    private void backTrack(int[] nums, List<List<Integer>> list, ArrayList<Integer> tempList, int remaining,int start) {
        if(remaining < 0)
            return;
        if(remaining == 0){
            list.add(new ArrayList<>(tempList));
        }
        for(int i=start;i<nums.length;i++){
            tempList.add(nums[i]);
            backTrack(nums,list,tempList,remaining-nums[i],i);
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        cs.combinationSum(new int[]{2,3,6,7},7).forEach(e-> System.out.println(e));
    }
}

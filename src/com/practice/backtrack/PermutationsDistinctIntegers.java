package com.practice.backtrack;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/permutations/
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]


 */
public class PermutationsDistinctIntegers {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backTrack(list,new ArrayList<Integer>(),nums);
        return list;
    }

    private void backTrack(List<List<Integer>> list, ArrayList<Integer> tempList, int[] nums ){

        if(tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if(tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                backTrack(list, tempList, nums);
                tempList.remove(tempList.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        PermutationsDistinctIntegers p = new PermutationsDistinctIntegers();
        p.permute(new int[]{1,2,3}).forEach(e-> System.out.println(e));
    }
}

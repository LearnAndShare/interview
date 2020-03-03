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
public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(result,new ArrayList<Integer>(),nums);
        return result;
    }

    private void backTrack(List<List<Integer>> result, ArrayList<Integer> tmpList, int[] nums) {
        if(nums.length == tmpList.size()){
            result.add(new ArrayList<>(tmpList));
            return;
        }
        for(int i =0 ; i<nums.length;i++){
            if(tmpList.contains(nums[i]))
                continue;
            tmpList.add(nums[i]);
            backTrack(result,tmpList,nums);
            tmpList.remove(tmpList.size()-1);
        }
    }

    public static void main(String[] args) {
        Permutation p = new Permutation();
        p.permute(new int[]{1,2,3}).forEach(System.out::println);
    }
}

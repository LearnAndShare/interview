package com.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/k-diff-pairs-in-an-array/
Given an array of integers and an integer k, you need to find the number of
unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
Example 1:
Input: [3, 1, 4, 1, 5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.
Example 2:
Input:[1, 2, 3, 4, 5], k = 1
Output: 4
Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
Example 3:
Input: [1, 3, 1, 5, 4], k = 0
Output: 1
Explanation: There is one 0-diff pair in the array, (1, 1).
 */
public class KDiffPairsInArray {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length == 1)
            return 0;
        Set<String> set = new HashSet<>();
        Set<Integer> s1 = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if(s1.contains(nums[i])) continue;
            s1.add(nums[i]);
            for(int j = i+1;j<=nums.length-1;j++){
                int diff = nums[j]-nums[i];
                if(diff > k)
                    break;
                if(diff == k){
                    String s = nums[i]+""+nums[j];
                    set.add(s);
                }
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        KDiffPairsInArray k = new KDiffPairsInArray();
        System.out.println(k.findPairs(new int[]{3, 1, 4, 1, 5}, 2));
        System.out.println(k.findPairs(new int[]{1, 2, 3, 4, 5}, 1));
        System.out.println(k.findPairs(new int[]{1, 3, 1, 5, 4}, 0));
        System.out.println(k.findPairs(new int[]{1,1,1,1,1}, 0));
    }
}

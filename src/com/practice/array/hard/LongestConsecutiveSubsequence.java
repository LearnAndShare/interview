package com.practice.array.hard;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/longest-consecutive-sequence/
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.


 */
public class LongestConsecutiveSubsequence {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if(!map.containsKey(num)){
                int left = (map.containsKey(num - 1)) ? map.get(num - 1) : 0;
                int right = (map.containsKey(num + 1)) ? map.get(num + 1) : 0;
                int sum = left + right + 1;
                map.put(num, sum);
                res = Math.max(res,sum);
                map.put(num-left,sum);
                map.put(num+ right,sum);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestConsecutiveSubsequence ls = new LongestConsecutiveSubsequence();
        System.out.println(ls.longestConsecutive(new int[]{100, 1,4, 200, 1, 3, 2}));
        System.out.println(ls.longestConsecutive(new int[]{1,2,0,1}));
        System.out.println(ls.longestConsecutive(new int[]{1,3,5,2,4}));
    }
}

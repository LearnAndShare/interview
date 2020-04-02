package com.practice.google;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/

Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


 */
public class LongestSubStringNoRepeatingChars {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;
        if(s.length() == 1)
            return 1;
        Set<Character> set = new HashSet<>();
        char[] c = s.toCharArray();

        int sub = -1;
       // for (int j = 0; j < c.length; j++)
        int j = 0;
            for (int i = 0; i < c.length && j<c.length; ) {
                if (set.contains(c[i])) {
                    set.remove(c[j]);
                    j++;
                } else {
                    set.add(c[i]);
                    i++;
                    sub = Math.max(sub, i-j);
                }
            }

        return sub;
    }

    public static void main(String[] args) {
        LongestSubStringNoRepeatingChars ls = new LongestSubStringNoRepeatingChars();
        System.out.println(ls.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(ls.lengthOfLongestSubstring("aaaaaaaa"));
        System.out.println(ls.lengthOfLongestSubstring("pwwkew"));
        System.out.println(ls.lengthOfLongestSubstring("dvdf"));
    }
}

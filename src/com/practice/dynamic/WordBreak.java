package com.practice.dynamic;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
https://leetcode.com/problems/word-break/

https://www.youtube.com/watch?v=hLQYQ4zj0qg

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

    The same word in the dictionary may be reused multiple times in the segmentation.
    You may assume the dictionary does not contain duplicate words.

Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.

Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false


 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean isBreak  = false;
        Set<String> dictSet= new HashSet<>(wordDict);
        boolean[] isBreakAble = new boolean[s.length()];
        isBreakAble[0] = true;
        for(int i=1;i<=s.length();i++){
            for (int j=0;j<i;j++){
                if(isBreakAble[j] && wordDict.contains(s.substring(j,i))){
                    isBreakAble[i] = true;
                    break;
                }
            }
        }
        return isBreakAble[s.length()];
    }
}

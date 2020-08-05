package com.practice.slidingwindow.hard;

import java.util.HashMap;
import java.util.Map;
/*
https://leetcode.com/problems/minimum-window-substring/
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"

Note:

    If there is no such window in S that covers all characters in T, return the empty string "".
    If there is such window, you are guaranteed that there will always be only one unique minimum window in S.

https://medium.com/outco/how-to-solve-sliding-window-problems-28d67601a66

 */
public class MinWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character,Integer> charsNeeded = new HashMap<>();
        Map<Character,Integer> charCountInWindow = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int c = charsNeeded.getOrDefault(t.charAt(i),0);
            charsNeeded.put(t.charAt(i),c+1);
        }
        int required = charsNeeded.keySet().size();
        int l =0;int r=0;
        int minLen = -1;
        int[] minWindow = new int[2];
        int formed = 0;
        while(r<s.length()){
            char sourceChar = s.charAt(r);
            int c = charCountInWindow.getOrDefault(sourceChar,0);
            charCountInWindow.put(sourceChar,c+1);

            if(charsNeeded.containsKey(sourceChar) && charCountInWindow.get(sourceChar)
                        == charsNeeded.get(sourceChar)){
                ++formed;
            }

            while(l<=r && formed == required){
                char lchar = s.charAt(l);
                int len = r-l+1;
                if(len<minLen || minLen == -1){
                    minLen = len;
                    minWindow[0] = l;
                    minWindow[1] = r;
                }
                //Char at Left window pointer is no longer part of window
                charCountInWindow.put(lchar, charCountInWindow.get(lchar) - 1);
                if(charsNeeded.containsKey(lchar) && charCountInWindow.get(lchar)
                        < charsNeeded.get(sourceChar)){
                    --formed;
                }
                // Move the left pointer ahead, this would help to look for a new window.
                l++;
            }

            r++;
        }

        return minLen==-1?"":s.substring(minWindow[0],minWindow[1]+1);
    }

    public static void main(String[] args) {
        MinWindowSubstring mws = new MinWindowSubstring();
        System.out.println(mws.minWindow("ADOBECODEBANC", "ABC"));
    }
}

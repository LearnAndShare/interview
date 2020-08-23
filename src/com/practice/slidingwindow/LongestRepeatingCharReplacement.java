package com.practice.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
  https://leetcode.com/problems/longest-repeating-character-replacement/
  https://leetcode.com/problems/longest-repeating-character-replacement/discuss/503011/Java-sliding-window-O(n)-with-detailed-explanation
 Given a string s that consists of only uppercase English letters, you can perform at most k operations on that string.

In one operation, you can choose any character of the string and change it to any other uppercase English character.

Find the length of the longest sub-string containing all repeating letters you can get after performing the above operations.

Note:
Both the string's length and k will not exceed 104.

Example 1:

Input:
s = "ABAB", k = 2

Output:
4

Explanation:
Replace the two 'A's with two 'B's or vice versa.



Example 2:

Input:
s = "AABABBA", k = 1

Output:
4

Explanation:
Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.

 */
public class LongestRepeatingCharReplacement {
    public int characterReplacement(String s, int k) {
        if(s == null || s.trim().length() == 0)
            return 0;
        int start =0,end = 0;
        Map<Character,Integer> charRepeatCountInWindow = new HashMap<>();
        //Rather than map we can also use int[] charCountCache = new int[26];  as only upper case letters needs to be considered
        int max = -1;
        int repeat = 0;
        char[] schars = s.toCharArray();
        while(end<schars.length){
            char ch = schars[end];
            charRepeatCountInWindow.put(ch,charRepeatCountInWindow.getOrDefault(ch,0)+1);
           repeat = Math.max(repeat,charRepeatCountInWindow.get(ch));
            int uniqueCharsInWindow = (end-start+1) - repeat;
            if(uniqueCharsInWindow > k){
                char c = schars[start];
                charRepeatCountInWindow.put(c,charRepeatCountInWindow.get(c)-1);
                start++;
                repeat =0;
            }
            max = Math.max(max,end-start+1);
            end++;
        }
        return max;
    }

    public static void main(String[] args) {
        LongestRepeatingCharReplacement ls = new LongestRepeatingCharReplacement();
        System.out.println("[ABAB, 2]::"+ls.characterReplacement("ABAB", 2));
        System.out.println("[AABABBA, 1]::"+ls.characterReplacement("AABABBA", 1));
    }
}

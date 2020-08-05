package com.practice.slidingwindow.medium;

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

Approach:
- Use a hashmap to remember the frequency of each character we have seen.
- As we iterate through the string and add character to the window, we
  also keep track of the maximum repeating character count.
- Shrink the window accordingly as we are not allowed to replace more than
  k characters.

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
public class LongestCharReplacement {
    public int characterReplacement(String s, int k) {
        if(s ==null || s.trim().length() == 0)
            return 0;
        int start =0;
        int end =0;
        int max = -1;
        int rep =0;
        Map<Character,Integer> wordFreq = new HashMap<>();
        while(end <s.length()){
            char c = s.charAt(end);
            wordFreq.put(c,wordFreq.getOrDefault(c,0)+1);
            rep = Math.max(rep,wordFreq.get(c));
            if(end-start +1 -rep > k){
                char startc = s.charAt(start);
                wordFreq.put(startc,wordFreq.get(startc)-1);
                start++;
                rep = 0;
            }
            max = Math.max(end-start+1,max);
            ++end;
        }
        return max;
    }

    public static void main(String[] args) {
        LongestCharReplacement lp = new LongestCharReplacement();
//        System.out.println(lp.characterReplacement("ABAB", 2));
        System.out.println(lp.characterReplacement("BAAAB" ,2));

    }
}

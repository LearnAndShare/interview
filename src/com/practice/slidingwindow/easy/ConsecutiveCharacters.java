package com.practice.slidingwindow.easy;
/*
https://leetcode.com/problems/consecutive-characters/

Given a string s, the power of the string is the maximum length of a non-empty substring that contains only one unique character.

Return the power of the string.



Example 1:

Input: s = "leetcode"
Output: 2
Explanation: The substring "ee" is of length 2 with the character 'e' only.

Example 2:

Input: s = "abbcccddddeeeeedcba"
Output: 5
Explanation: The substring "eeeee" is of length 5 with the character 'e' only.

Example 3:

Input: s = "triplepillooooow"
Output: 5

Example 4:

Input: s = "hooraaaaaaaaaaay"
Output: 11

Example 5:

Input: s = "tourist"
Output: 1

 */
public class ConsecutiveCharacters {
    public int maxPower(String s) {
        int max = 1;
        int count =1;

        char prevChar = s.charAt(0);
        for(int i=1;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == prevChar){
                ++count;
                max = Math.max(count,max);
            } else {
                prevChar = ch;
                count = 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ConsecutiveCharacters cs = new ConsecutiveCharacters();
        System.out.println("leetcode::"+cs.maxPower("leetcode"));
        System.out.println("triplepillooooow::"+cs.maxPower("triplepillooooow"));
    }
}

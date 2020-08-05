package com.practice.slidingwindow.medium;
/*
https://leetcode.com/problems/permutation-in-string/
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
In other words, one of the first string's permutations is the substring of the second string.



Example 1:

Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:

Input:s1= "ab" s2 = "eidboaoo"
Output: False


 */
public class PalindromeInclusion {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length()>s2.length())
            return false;
        int[] s1CharsCount = new int[26];
        int[] s2CharsCount = new int[26];

        //since s1 is shorter we will create array with shorter size as window will always contain those many chars
        for(int i=0;i<s1.length();i++){
            s1CharsCount[s1.charAt(i)-'a']++;
            s2CharsCount[s2.charAt(i)-'a']++;
        }

        for(int i=0;i<s2.length()-s1.length();i++){
            if(matches(s1CharsCount,s2CharsCount))
                return true;
            //Since chars count does not match move 1 character out of left side of window
            // and add 1 more charcter from right
            s2CharsCount[s2.charAt(i)-'a']--;
            s2CharsCount[s2.charAt(i+s1.length()) - 'a']++;
        }
        return matches(s1CharsCount,s2CharsCount);
    }

    public boolean matches(int[] s1Count,int[] s2Count){
        for(int i=0;i<s1Count.length;i++){
            if(s1Count[i]!= s2Count[i])
                return false;
        }
        return true;

    }

    public static void main(String[] args) {
       PalindromeInclusion pi = new PalindromeInclusion();
        System.out.println(pi.checkInclusion("ab", "a"));
//        System.out.println(pi.checkInclusion("adc", "dcda"));
//        System.out.println(pi.checkInclusion("ab", "eidbaooo"));
    }
}

package com.practice.slidingwindow.medium;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/find-all-anagrams-in-a-string/
Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

 */
public class FindAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> anagramIdx = new ArrayList<>();
        if(s != null && s.length() >0 && s.length()>p.length()){
            int[] sarr = new int[26];
            int[] parr = new int[26];
            for(int i=0;i<p.length();i++){
                parr[p.charAt(i)-'a']++;
                sarr[s.charAt(i)-'a']++;
            }

            int idx = 0;
           for(;idx<s.length()-p.length();idx++){
                if(match(sarr,parr)){
                    anagramIdx.add(idx);
                }
                sarr[s.charAt(idx)-'a']--;
                sarr[s.charAt(idx+p.length())-'a']++;
           }

            if(match(sarr,parr)){
                anagramIdx.add(idx);
            }

        }


        return anagramIdx;
    }

    public boolean match(int[] arr1,int[] arr2){
        for (int i = 0; i < arr1.length ; i++) {
            if(arr1[i] != arr2[i]){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        FindAnagramsInString fs = new FindAnagramsInString();
        System.out.println(fs.findAnagrams("cbaebabacd", "abc"));
        System.out.println(fs.findAnagrams("abab", "ab"));
        System.out.println(fs.findAnagrams("aaaaaaaaaa","aaaaaaaaaaaaa"));
    }
}

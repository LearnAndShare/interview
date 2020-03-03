package com.practice.backtrack;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/letter-case-permutation/
Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.
Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]

 */
public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> l = new ArrayList<>();
        helper(S.toCharArray(),0,l);
        return l;
    }

    private void helper(char[] s, int i, List<String> list) {
        if(i>= s.length){
            list.add(new String(s));
            return;
        }

        if(Character.isLetter(s[i])){
            s[i] = Character.toUpperCase(s[i]);
            helper(s,i+1,list);
            s[i] = Character.toLowerCase(s[i]);
            helper(s,i+1,list);
        } else {
            helper(s,i+1,list);
        }
    }

    public static void main(String[] args) {
        LetterCasePermutation lp = new LetterCasePermutation();
        lp.letterCasePermutation("a1b2").forEach(System.out::println);
        /*lp.letterCasePermutation("a1b2").forEach(System.out::println);
        lp.letterCasePermutation("3z4").forEach(System.out::println);*/
    }
}

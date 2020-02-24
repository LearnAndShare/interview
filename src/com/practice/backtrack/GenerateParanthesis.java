package com.practice.backtrack;

import java.util.ArrayList;
import java.util.List;

/*

FYR :: https://github.com/bephrem1/backtobackswe/blob/master/Dynamic%20Programming%2C%20Recursion%2C%20%26%20Backtracking/GenerateNMatchedParenStrings/GenerateNMatchedParenStrings.java

https://leetcode.com/problems/generate-parentheses/solution/
 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

 */
public class GenerateParanthesis {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backTrack(n,n,"",list);
        return list;
    }

    private void backTrack(int leftNeeded, int rightNeeded, String curr, List<String> list) {
        if(leftNeeded == 0 && rightNeeded == 0){
            list.add(curr);
        }

        if(leftNeeded>0){
            backTrack(leftNeeded-1,rightNeeded,curr+"(",list);
        }

        if(rightNeeded>leftNeeded){
            backTrack(leftNeeded,rightNeeded-1,curr+")",list);
        }
    }

    public static void main(String[] args) {
        GenerateParanthesis gp = new GenerateParanthesis();
        gp.generateParenthesis(2).forEach(System.out::println);
    }
}

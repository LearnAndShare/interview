package com.practice.dynamic;
/*
https://leetcode.com/problems/decode-ways/

https://leetcode.com/problems/decode-ways/discuss/30522/Java-2ms-DP-solution-with-detailed-explanation-and-inline-comments
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26

Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).

Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).


 */
public class DecodeWays {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0)
            return 0;
        if(s.length() == 1 && s.charAt(0) == '0')
            return 0;
        int [] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = s.charAt(0)!='0'?1:0;
        for(int i=1;i<s.length();i++){
            int curr = s.charAt(i)-'0';
            int prev = s.charAt(i-1)-'0';
            // can't make progress, return 0
            if(curr == 0 && prev == 0|| (curr == 0 && (prev * 10 + curr > 26)))
                return 0;
            else if(prev == 0 ||((prev*10+curr)>26)) // can't use the previous value, so can only get to this state from the current
                dp[i+1] = dp[i];
            else if(curr == 0)
                dp[i+1] = dp[i-1];// can't use current state, can only get to this state from i - 1 state
            else
                dp[i+1] = dp[i]+dp[i-1];// can get to this state from the previous two states

        }
        return dp[s.length()];
    }
    /*
    dp[0] means an empty string will have one way to decode, dp[1] means the way to decode a string of size 1.
    check one digit and two digit combination and save the results along the way. In the end, dp[n] will be the end result.
     */
    public int numDecodings2(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i=2;i<=s.length();i++){
            int first = Integer.parseInt(s.substring(i-1,i));
            int second = Integer.parseInt(s.substring(i-2,i));
            if(first>0 && first<=9)
                dp[i] += dp[i-1];
            if(second>9 && second<=26)
                dp[i] += dp[i-2];
        }
        return dp[s.length()];
    }


    public static void main(String[] args) {
        DecodeWays dc = new DecodeWays();
        System.out.println(dc.numDecodings("01"));
    }
}

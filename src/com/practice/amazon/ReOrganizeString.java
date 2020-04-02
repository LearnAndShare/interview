package com.practice.amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/reorganize-string/
Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.

Example 1:

Input: S = "aab"
Output: "aba"

Example 2:

Input: S = "aaab"
Output: ""

Note:
 */
public class ReOrganizeString {
    public String reorganizeString(String S) {
        Map<Character,Integer> charCount = new HashMap<>();
        for (char c : S.toCharArray()) {
            int cnt = charCount.getOrDefault(c,0);
            charCount.put(c,cnt+1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((o1, o2) -> {
            if(!charCount.get(o1).equals(charCount.get(o2))){
                return charCount.get(o2).compareTo(charCount.get(o1));
            } else {
                return o2.compareTo(o1);
            }
        });
        StringBuilder sb = new StringBuilder();
        pq.addAll(charCount.keySet());
        while(pq.size() >= 2){
            char ch = pq.poll();
            char ch1 = pq.poll();
            sb.append(ch);
            sb.append(ch1);

            charCount.put(ch,charCount.get(ch)-1);
            charCount.put(ch1,charCount.get(ch1)-1);
            if(charCount.get(ch)>0){
                pq.offer(ch);
            }
            if(charCount.get(ch1)>0){
                pq.offer(ch1);
            }

        }

        if(pq.size() == 1){
            char ch = pq.poll();
            if(charCount.get(ch)>1)
                return "";
            else
                sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReOrganizeString rs = new ReOrganizeString();
        System.out.println(rs.reorganizeString("aab"));
        System.out.println("rs.reorganizeString(\"aaab\")" + rs.reorganizeString("aaab"));
    }
}

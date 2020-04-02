package com.practice.amazon;

import java.util.*;

/*
https://www.programcreek.com/2014/08/leetcode-rearrange-string-k-distance-apart-java/

https://tenderleo.gitbooks.io/leetcode-solutions-/GoogleHard/358.html

Given a non-empty string str and an integer k, rearrange the string such that the same characters are at least distance k from each other.

All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".

Example 1: str = "aabbcc", k = 3

Result: "abcabc"

The same letters are at least distance 3 from each other. Example 2: str = "aaabc", k = 3

Answer: ""

It is not possible to rearrange the string. Example 3: str = "aaadbbcc", k = 2

Answer: "abacabcd"

Another possible answer is: "abcabcda"

The same letters are at least distance 2 from each other.
 */
public class RearrangeStringKDistanceApart {

    public String rearrangeString(String str, int k) {
        if(str == "")
            return str;
        StringBuilder sb = new StringBuilder();
        Map<Character,Integer> charCount = new HashMap<>();
        for (char c : str.toCharArray()) {
            int cnt = charCount.getOrDefault(c,0);
            charCount.put(c,cnt+1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((o1, o2) -> {
            if(charCount.get(o1) != charCount.get(o2)){
                return charCount.get(o2) - charCount.get(o1);
            }else {
                return o1.compareTo(o2);
            }
        });

        pq.addAll(charCount.keySet());

        while(!pq.isEmpty()){
            int i=0;
            List<Character> tmp = new ArrayList<>();
            while(i < k){
                char ch = pq.poll();
                sb.append(ch);
                charCount.put(ch,charCount.get(ch)-1);
                if(charCount.get(ch) > 0){
                    tmp.add(ch);
                }
               ++i;
            }
            pq.addAll(tmp);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RearrangeStringKDistanceApart rs = new RearrangeStringKDistanceApart();
        System.out.println(rs.rearrangeString("aabbcc", 3));
    }
}

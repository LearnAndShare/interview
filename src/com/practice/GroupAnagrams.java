package com.practice;

import java.util.*;

/*
https://leetcode.com/problems/group-anagrams/
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list=new ArrayList<>();
        if(strs == null || strs.length == 0)
            return list;
        Map<String,List<String>>m = new HashMap<>();
        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String st = new String(ch);
            List<String> li = new ArrayList<>();
            if(m.containsKey(st)){
                li = m.get(st);
            }
            li.add(str);
            m.put(st,li);
        }
        m.forEach((k,e)->list.add(e));
        return list;
    }

    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        ga.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}).forEach(System.out::println);

    }

}

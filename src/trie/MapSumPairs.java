package trie;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/map-sum-pairs/
Implement a MapSum class with insert, and sum methods.

For the method insert, you'll be given a pair of (string, integer). The string represents the key and the integer represents the value. If the key already existed, then the original key-value pair will be overridden to the new one.

For the method sum, you'll be given a string representing the prefix, and you need to return the sum of all the pairs' value whose key starts with the prefix.

Example 1:

Input: insert("apple", 3), Output: Null
Input: sum("ap"), Output: 3
Input: insert("app", 2), Output: Null
Input: sum("ap"), Output: 5

 */
public class MapSumPairs {
    Map<String,Integer> map ;
    TrieNode root ;


    /** Initialize your data structure here. */
    public MapSumPairs() {
        map = new HashMap();
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode n = root;
        int delta = val-map.getOrDefault(key,0);
        map.put(key,val);
        n.score += delta;
        for(char ch:key.toCharArray()){
            TrieNode n1 = n.children.getOrDefault(ch,new TrieNode());
            n1.score += delta;
            n.children.put(ch,n1);
            n = n1;
        }
    }


    public int sum(String prefix) {
        TrieNode cur = root;
        for(char ch:prefix.toCharArray()){
            cur = cur.children.get(ch);
            if (cur == null) return 0;
        }
        return cur.score;
    }


}
class TrieNode{
    Map<Character,TrieNode> children = new HashMap();
    int score;

}
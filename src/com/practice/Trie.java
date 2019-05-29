package com.practice;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    private class TrieNode{
        Map<Character,TrieNode> children;
        boolean eow ;

        public TrieNode(){
            children = new HashMap<>();
            eow = false;
        }
    }


    private TrieNode root;
    public Trie(){
        root  = new TrieNode();
    }

    public void insert(String word){
        TrieNode current = root;
        for (int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            TrieNode t = current.children.get(ch);
            if(t == null){
                t = new TrieNode();
                current.children.put(ch,t);
            }
            current = t;
        }
        current.eow = true;
    }


    public boolean search(String word){
        TrieNode current = root;
        for (int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            TrieNode t = current.children.get(ch);
            if(t == null)
                return false;
            current = t;
        }

        return current.eow;
    }

}

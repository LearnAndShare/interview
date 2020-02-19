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

    public boolean startsWith(String prefix){
        TrieNode current = root;
        for (char ch:prefix.toCharArray()) {
            if(!current.children.containsKey(ch))
                return false;
            current = current.children.get(ch);
        }
        return true;
    }


    /**
     * Delete word from trie.
     */
    public void delete(String word) {
        delete(root, word, 0);
    }

    /**
     * Returns true if parent should delete the mapping
     */
    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            //when end of word is reached only delete if currrent.endOfWord is true.
            if (!current.eow) {
                return false;
            }
            current.eow = false;
            //if current has no other mapping then return true
            return current.children.size() == 0;
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

        //if true is returned then delete the mapping of character and trienode reference from map.
        if (shouldDeleteCurrentNode) {
            current.children.remove(ch);
            //return true if no mappings are left in the map.
            return current.children.size() == 0;
        }
        return false;
    }
    public static void main(String[] args) {

    }


}

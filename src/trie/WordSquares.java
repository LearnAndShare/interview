package trie;
/*
https://leetcode.com/problems/word-squares/


 */

import java.util.ArrayList;
import java.util.List;

/*

l a d y
Note:
There are at least 1 and at most 1000 words.
All words will have the exact same length.
Word length is at least 1 and at most 5.
Each word contains only lowercase English alphabet a-z.

Example 1:
Input:
["area","lead","wall","lady","ball"]

Output:
[
  [ "wall",
    "area",
    "lead",
    "lady"
  ],
  [ "ball",
    "area",
    "lead",
    "lady"
  ]
]

Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).

Example 2:
Input:
["abat","baba","atan","atal"]

Output:
[
  [ "baba",
    "abat",
    "baba",
    "atan"
  ],
  [ "baba",
    "abat",
    "baba",
    "atal"
  ]
]

Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).

 */
public class WordSquares {
    class TrieNode{
        TrieNode[] children;
        List<String> startsWith;
        public TrieNode(){
            children = new TrieNode[26];
            startsWith=new ArrayList<>();
        }
    }
    class Trie{
        TrieNode root;
        Trie(String[] words){
            root = new TrieNode();
            for(String w:words){
                TrieNode curr = root;
                for(char ch:w.toCharArray()){
                    int idx = ch-'a';
                    if(curr.children[idx] == null)
                        curr.children[idx] = new TrieNode();
                    curr.children[idx].startsWith.add(w);
                    curr = curr.children[idx];
                }
            }
        }

        List<String> findByPrefix(String word){
            List<String> prefixResults = new ArrayList<>();
            TrieNode curr = root;
            for(char ch:word.toCharArray()){
                int idx = ch-'a';
                if(curr.children[idx] == null)
                    return prefixResults;
                curr = curr.children[idx];
            }
            prefixResults.addAll(curr.startsWith);
            return prefixResults;
        }
    }

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> ans = new ArrayList<>();
        if(words == null || words.length ==0){
            return ans;
        }
        int len = words[0].length();
        Trie trie = new Trie(words);
        List<String> ansBuilder = new ArrayList<>();
        for (String word : words) {
            ansBuilder.add(word);
            dfs(len,trie,ans,ansBuilder);
            ansBuilder.remove(ansBuilder.size()-1);
        }

        return ans;
    }

    private void dfs(int len, Trie trie, List<List<String>> ans, List<String> ansBuilder) {
        if(ansBuilder.size() == len){
            ans.add(new ArrayList<>(ansBuilder));
            return;
        }

        StringBuilder prefixBuilder = new StringBuilder();
        int idx = ansBuilder.size();
        for(String sw: ansBuilder){
            prefixBuilder.append(sw.charAt(idx));
        }

        List<String> startsWith = trie.findByPrefix(prefixBuilder.toString());
        for(String s:startsWith){
            ansBuilder.add(s);
            dfs(len,trie,ans,ansBuilder);
            ansBuilder.remove(ansBuilder.size()-1);
        }
    }

    public static void main(String[] args) {
        WordSquares ws = new WordSquares();
        for (List<String> wordSquare : ws.wordSquares(new String[]{"ball","area","lead","lady","wall"})) {
            wordSquare.forEach(e-> System.out.print(e+","));
            System.out.println("===============");
        }
    }
}

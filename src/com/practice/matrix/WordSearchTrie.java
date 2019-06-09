package com.practice.matrix;

import com.practice.Trie;

import java.util.*;

/*
https://leetcode.com/problems/word-search-ii/
 */
public class WordSearchTrie {
    Trie t = new Trie();
    Set<String> res = new LinkedHashSet<>();
    public List<String> findWords(char[][] board, String[] words) {
        if(board == null || board.length == 0 || words ==  null || words.length == 0)
            return Collections.emptyList();
        for (String word : words) {
            t.insert(word);
        }
        int r = board.length;
        int c = board[0].length;
        boolean visited[][] = new boolean[r][c];
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[i].length;j++) {
                dfs(board, i, j,  "",visited);
            }
        List<String> l = new ArrayList<>();
            l.addAll(res);
        return l;
    }

    public void dfs(char[][] board,int i,int j,String st,boolean[][] v){
        if(i<0||i>=board.length||j<0||j>=board[0].length||v[i][j])
            return ;
        st += board[i][j];
        if(!t.startsWith(st)){
            return ;
        }
        if(t.search(st)){
            res.add(st);
        }

        v[i][j] = true;
        dfs(board,i,j-1,st,v);
                //right
        dfs(board,i,j+1,st,v);
        //top
        dfs(board,i-1,j,st,v);
        //bottom
        dfs(board,i+1,j,st,v);

        v[i][j]= false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
        {'o', 'a', 'a', 'n'},
        {'e', 't', 'a', 'e'},
        {'i', 'h', 'k', 'r'},
        {'i', 'f', 'l', 'v'}
    };
        String [] words = new String[] {"oath","pea","eat","rain"};
        WordSearchTrie w = new WordSearchTrie();
        List<String> ret = w.findWords(board,words);
        for (String re : ret) {
            System.out.println(re);
        }

    }
}

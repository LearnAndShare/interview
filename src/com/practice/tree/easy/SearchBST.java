package com.practice.tree.easy;

import com.practice.tree.TreeNode;

/*
https://leetcode.com/problems/search-in-a-binary-search-tree/

Given the tree:
        4
       / \
      2   7
     / \
    1   3

And the value to search: 2
You should return this subtree:

      2
     / \
    1   3

 */
public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {

        TreeNode t = root;
        while(t != null){
            if(val == t.val)
                break;
            if(val>t.val){
                t = t.right;
            } else {
                t = t.left;
            }
        }

        return t;
    }
}

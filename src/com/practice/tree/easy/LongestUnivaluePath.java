package com.practice.tree.easy;

import com.practice.tree.TreeNode;

/*
https://leetcode.com/problems/longest-univalue-path/
Given a binary tree, find the length of the longest path where each node in the path has the same value.
 This path may or may not pass through the root.

The length of path between two nodes is represented by the number of edges between them.

Example 1:

Input:

              5
             / \
            4   5
           / \   \
          1   1   5

Output: 2



Example 2:

Input:

              1
             / \
            4   5
           / \   \
          4   4   5

Output: 2

 */
public class LongestUnivaluePath {

    int maxHeight = 1;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null)
            return 0;
         helper(root,root.val);
        return maxHeight-1;
    }

    private int helper(TreeNode root,int val) {
        if(root ==null)
            return 0;

        int lHeight = helper(root.left,val);
        int rHeight = helper(root.right,val);
        maxHeight = Math.max(maxHeight,lHeight+rHeight+1);
        if(root.val == val){
            return 1+ Math.max(lHeight,rHeight);
        }
       return 0;
    }

}

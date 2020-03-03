package com.practice.tree.medium;

import com.practice.tree.TreeNode;

/*
https://leetcode.com/problems/binary-tree-pruning/

We are given the head node root of a binary tree, where additionally every node's value is either a 0 or a 1.

Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.

Example 1:
Input: [1,null,0,0,1]
Output: [1,null,0,null,1]

 */
public class BinaryTreePrune {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null)
            return null;
         boolean ret = helper(root);
        return ret?root:null;
    }

    private boolean helper(TreeNode root) {
        if (root == null)
            return false;

        boolean a1 = helper(root.left);
        boolean a2= helper(root.right);

        if(!a1)
            root.left = null;
        if(!a2)
            root.right = null;


       return root.val == 1||a1||a2;
    }
}

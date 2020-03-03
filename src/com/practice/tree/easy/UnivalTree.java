package com.practice.tree.easy;

import com.practice.tree.TreeNode;

/*
https://leetcode.com/problems/univalued-binary-tree/
A binary tree is univalued if every node in the tree has the same value.

Return true if and only if the given tree is univalued.
 */
public class UnivalTree {

    public boolean isUnivalTree(TreeNode root) {
        return helper(root,root.val);
    }

    public boolean helper(TreeNode root,int val){
        if(root == null || root.val ==val)
            return true;

        return root.val ==val && helper(root.left,val) && helper(root.right,val);
    }
}

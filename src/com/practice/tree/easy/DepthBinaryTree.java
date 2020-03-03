package com.practice.tree.easy;

import com.practice.tree.TreeNode;

/*
https://leetcode.com/problems/maximum-depth-of-binary-tree/
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class DepthBinaryTree {

    public int maxDepth(TreeNode root) {
        return helper(root);
    }

    private int helper(TreeNode root) {
        if(root == null)
            return 0;
        return 1+Math.max(helper(root.left),helper(root.right));
    }

    public int maxDepth2(TreeNode root) {
        if(root == null)
            return 0;
        return 1+Math.max(maxDepth2(root.left),maxDepth2(root.right));
    }
}

package com.practice.tree.easy;

import com.practice.tree.TreeNode;

/*
https://leetcode.com/problems/binary-tree-tilt/
Given a binary tree, return the tilt of the whole tree.

The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values.
Null node has tilt 0.

The tilt of the whole tree is defined as the sum of all nodes' tilt.
 */
public class BinaryTreeTilt {
    int tilt = 0;
    public int findTilt(TreeNode root) {
        if(root ==null)
            return 0;
        helper(root);
        return tilt;
    }

    private int helper(TreeNode root) {
        if(root == null)
            return 0;
        int lTilt = helper(root.left);
        int rTilt = helper(root.right);
        tilt += Math.abs(lTilt-rTilt);
        return root.val + lTilt +rTilt;
    }
}

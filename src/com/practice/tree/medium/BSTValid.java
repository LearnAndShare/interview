package com.practice.tree.medium;

import com.practice.tree.TreeNode;
import com.practice.tree.TreeUtil;

/*
https://leetcode.com/problems/validate-binary-search-tree/
Given a binary tree, determine if it is a valid binary search tree (BST).

Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true

Example 2:

    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.

 */
public class BSTValid {
    public boolean isValidBST(TreeNode root) {
        if(root == null )
            return true;
        return helper(root,Long.MAX_VALUE,Long.MIN_VALUE);
    }

    private boolean helper(TreeNode root, long maxValue, long minValue) {
        if(root == null)
            return true;
        if(root.val>=maxValue ||  root.val<=minValue)
            return false;
        return helper(root.left,root.val,minValue)
                && helper(root.right,maxValue,root.val);

    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.createTreeFromArray(new int[]{1,1});
        BSTValid b = new BSTValid();
        System.out.println("isValidBST:: "+ b.isValidBST(root));
    }
}

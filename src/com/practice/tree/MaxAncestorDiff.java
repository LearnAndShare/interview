package com.practice.tree;
/*
https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/

 */
public class MaxAncestorDiff {
    public int maxAncestorDiff(TreeNode root) {
        return helper(root,Integer.MAX_VALUE,Integer.MIN_VALUE);
    }

    private int helper(TreeNode root,  int minValue,int maxValue) {
        if(root == null)
            return 0;
        minValue = Math.min(minValue,root.val);
        maxValue = Math.max(maxValue,root.val);

        if(root.left==null && root.right == null)
            return Math.abs(maxValue-minValue);
        return Math.max(helper(root.left,minValue,maxValue),helper(root.right,minValue,maxValue));
    }

}

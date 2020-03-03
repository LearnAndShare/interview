package com.practice.tree.easy;

import com.practice.tree.TreeNode;

/*
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 */
public class LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        return helper(root,p.val,q.val);
    }

    private TreeNode helper(TreeNode root, int pVal, int qVal) {
        if(root ==null)
            return null;

        if(root.val < pVal && root.val <qVal)
            return helper(root.right,pVal,qVal);
        else if(root.val > pVal && root.val > qVal)
            return helper(root.left,pVal,qVal);
        else return root;
    }
}

package com.practice.tree.medium;

import com.practice.tree.TreeNode;

public class BST {
    /*
    https://leetcode.com/problems/insert-into-a-binary-search-tree/
    Given the root node of a binary search tree (BST) and a value to be inserted into the tree, insert the value into the BST. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
       TreeNode t = new TreeNode(val);
       TreeNode t1 = root;
        TreeNode pn = null;
       while(root != null){
           pn = root;
            if(root.val < val){
                root = root.right;
            } else {
                root = root.left;
            }
       }
        if(pn != null){
           if(val > pn.val){
               pn.right = t;
           } else {
               pn.left = t;
           }
        }
       return t1;

    }

}

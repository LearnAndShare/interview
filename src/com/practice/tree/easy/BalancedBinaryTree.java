package com.practice.tree.easy;

import com.practice.tree.TreeNode;

/*
https://leetcode.com/problems/balanced-binary-tree/
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.

Example 3
Tree: [1,2,null,3,null,4,null,5]
1
/
2
/
3
/
4
/
5

 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(helper(root) == -1) return false;
        return true;
    }

    private int helper(TreeNode root) {
        if(root == null)
            return 0;
        int lHeight = helper(root.left);
        //Lheight == -1 means tree was not balanced at this node so exit
        if(lHeight == -1)
            return -1;
        int rHeight = helper(root.right);
        //Rheight == -1 means tree was not balanced at this node so exit
        if(rHeight == -1)
            return -1;
        int diff = rHeight-lHeight;
        if( Math.abs(diff)>1)return -1;
        return 1+Math.max(lHeight,rHeight);
    }


}

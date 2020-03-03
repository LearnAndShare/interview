package com.practice.tree.easy;

import com.practice.tree.TreeNode;

import java.util.Stack;
/*
https://leetcode.com/problems/sum-of-left-leaves/
Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null ||(root.left == null && root.right ==null))
            return 0;

        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        int sum = 0;

        while(!s.isEmpty()){
            TreeNode t = s.pop();
            TreeNode tLeft = t.left;
            if(tLeft != null) {
                if (tLeft.left == null && tLeft.right == null)
                    sum += t.val;
                s.push(tLeft);
            }

            t = t.right;
            if(t !=null){
                s.push(t);
            }
        }
        return sum;
    }

    public int sumOfLeftLeavesRC(TreeNode root) {
        if(root == null)
            return 0;
        return helper(root,false);
    }

    private int helper(TreeNode root, boolean isLeft) {
        if(root == null )
            return 0;

        if(isLeft && root.left == null && root.right == null)
            return root.val;
        return helper(root.left,true)+ helper(root.right,false);
    }


}

package com.practice.tree.easy;

import com.practice.tree.TreeNode;

import java.util.LinkedList;

/*
https://leetcode.com/problems/symmetric-tree/
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
    1
   / \
  2   2
 / \ / \
3  4 4  3
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return helper(root.left,root.right);

    }

    private boolean helper(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2==null)
            return true;
        if(t1 == null  || t2 == null )
            return false;
        return t1.val == t2.val && helper(t1.left,t2.right)&& helper(t1.right,t2.left);
    }



    public boolean isSymmetricIterative(TreeNode root){
        if(root == null){
            return true;
        }
        LinkedList<TreeNode> l = new LinkedList<>();
        l.push(root);
        l.push(root);
        while(!l.isEmpty()){
            TreeNode t1= l.poll();
            TreeNode t2= l.poll();
            if(t1 == null && t2 == null)
                continue;
            if(t1 == null || t2 == null)
                return false;
            if(t1.val != t2.val)
                return false;
            l.push(t1.left);
            l.push(t2.right);
            l.push(t1.right);
            l.push(t2.left);
        }
        return true;
    }
}

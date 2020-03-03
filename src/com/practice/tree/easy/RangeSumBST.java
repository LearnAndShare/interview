package com.practice.tree.easy;

import com.practice.tree.TreeNode;

import java.util.Stack;
/*
https://leetcode.com/problems/range-sum-of-bst/
Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).

The binary search tree is guaranteed to have unique values.



Example 1:

Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
Output: 32

Example 2:

Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
Output: 23

 */
public class RangeSumBST {
    int ans;
    public int rangeSumBST(TreeNode root, int L, int R) {
        ans = 0;
        if(root != null){
            dfs(root,L,R);
        }
        return ans;
    }

    private void dfs(TreeNode root, int l, int r) {
        if(root == null)
            return ;
        if(root.val >=l && root.val <=r)
            ans = ans+root.val;
        dfs(root.left,l,r);
        dfs(root.right,l,r);


    }

    private int rangeIterative(TreeNode root, int L, int R){
       int sum =0;
       if(root != null){
           Stack<TreeNode> s = new Stack<>();

            s.push(root);

           while(!s.isEmpty()){
               TreeNode t = s.pop();
               if(t.val >=L && t.val <=R){
                   sum +=t.val;
               }

               if(t.left != null)
                   s.push(t.left);
               if(t.right != null)
                   s.push(t.right);
           }
       }
       return sum;
    }
}

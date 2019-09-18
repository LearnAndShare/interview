package com.practice.tree;

import java.util.LinkedList;

/*
https://leetcode.com/problems/find-bottom-left-tree-value/

 Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:

Input:

    2
   / \
  1   3

Output:
1

Example 2:

Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7

 */
public class BottomLeftMostNode {
    public int findBottomLeftValue(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return root.val;
        LinkedList<TreeNode> l =new LinkedList<>();
        l.add(root);
        TreeNode finNode = null;
        while(!l.isEmpty()){
            int size = l.size();
            for(int i=0;i<size;i++){
                TreeNode t = l.poll();
                if(t.right != null)
                    l.add(t.right);
                if(t.left != null)
                    l.add(t.left);
                if(l.isEmpty())
                    finNode = t;
            }

        }
        return finNode == null?-1:finNode.val;
    }
}

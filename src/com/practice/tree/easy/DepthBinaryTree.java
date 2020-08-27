package com.practice.tree.easy;

import com.practice.tree.TreeNode;

import java.util.LinkedList;

/*
https://leetcode.com/problems/maximum-depth-of-binary-tree/
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class DepthBinaryTree {

    public int maxDepth(TreeNode root) {
        return helper(root);
    }

    private int helper(TreeNode root) {
        if(root == null)
            return 0;
        return 1+Math.max(helper(root.left),helper(root.right));
    }

    public int maxDepth2(TreeNode root) {
        if(root == null)
            return 0;
        return 1+Math.max(maxDepth2(root.left),maxDepth2(root.right));
    }

    public int maxDepthIterative(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> depths = new LinkedList<>();
        if (root == null) return 0;

        stack.add(root);
        depths.add(1);

        int depth = 0, current_depth = 0;
        while(!stack.isEmpty()) {
            root = stack.pollLast();
            current_depth = depths.pollLast();
            if (root != null) {
                depth = Math.max(depth, current_depth);
                if(root.left != null){
                    stack.add(root.left);
                    depths.add(current_depth + 1);
                }
                if(root.right != null){
                    stack.add(root.right);
                    depths.add(current_depth + 1);
                }
            }
        }
        return depth;
    }
}

package com.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/minimum-depth-of-binary-tree/
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its minimum depth = 2.
 */
public class MinDepthBinaryTree {
    public int minDepth(TreeNode root) {
        return helper(root);
    }

    private int helper(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left != null && root.right != null) {
            int l = helper(root.left);
            int r = helper(root.right);
            return 1 + Math.min(l, r);
        }
        if(root.left == null)
            return helper(root.right)+1;
        if(root.right == null)
            return helper(root.left)+1;
        return 0;
    }

    public static void main(String[] args) {
        TreeNode t = TreeUtil.createTreeFromArray(new int[]{1, 2});
        MinDepthBinaryTree m = new MinDepthBinaryTree();
        System.out.println("Min Depth::"+m.minDepth(t));
    }

    public int minDepthBFS(TreeNode root){
        if(root==null) return 0;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode t = queue.remove();
                if(t.right == null && t.left == null) {
                    return level;
                } else {
                    if(t.left != null) {
                        queue.add(t.left);
                    }
                    if(t.right != null) {
                        queue.add(t.right);
                    }
                }
            }
            ++level;
        }
        return level;
    }
}

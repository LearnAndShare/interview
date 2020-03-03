package com.practice.tree.easy;

import com.practice.tree.TreeNode;

/*
https://leetcode.com/problems/diameter-of-binary-tree/
https://leetcode.com/problems/diameter-of-binary-tree/discuss/240383/Java-Solutions
https://www.youtube.com/watch?v=i9nVJDr4HmA

 */
public class DiameterBinaryTree {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root !=null){
           diameter(root);
        }
        return max;
    }

    private int diameter(TreeNode root) {
        if(root == null)
            return 0;
        int lHeight = diameter(root.left);
        int rHeight = diameter(root.right);
        max= Math.max(max,lHeight+rHeight+1);
        return 1+ Math.max(lHeight,rHeight);
    }
}

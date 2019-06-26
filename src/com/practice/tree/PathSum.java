package com.practice.tree;
/*
https://leetcode.com/problems/path-sum/
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {

        return helperPathSum(root,sum);
    }

    private boolean helperPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;

        sum = sum - root.val ;
        if(sum == 0 && root.left == null && root.right == null)
            return true;
        return helperPathSum(root.left,sum) || helperPathSum(root.right,sum);
    }
}

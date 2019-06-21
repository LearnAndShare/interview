package com.practice.tree;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        return helperPathSum(root,sum);
    }

    private boolean helperPathSum(TreeNode root, int sum) {
        if(root == null)
            return true;

        int v = root.val - sum;
        if(v == 0 && root.left == null && root.right == null)
            return true;
        return helperPathSum(root.left) || helperPathSum(root.right);
    }
}

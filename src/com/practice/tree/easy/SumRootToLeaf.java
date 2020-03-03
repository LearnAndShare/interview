package com.practice.tree.easy;

import com.practice.tree.TreeNode;

/*
https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
 */
public class SumRootToLeaf {
    public int sumRootToLeaf(TreeNode root) {
        if(root==null)
            return 0;
        return dfs(root,0);
    }

    public int dfs(TreeNode t,int sum){
        if(t== null)
            return 0;
        sum =sum*2+ t.val;
        if(isLeaf(t))
            return sum;
        return dfs(t.left,sum)+dfs(t.right,sum);
    }

    public boolean isLeaf(TreeNode t){
        return t.left== null && t.right == null;
    }
}

package com.practice.tree;
/*
https://leetcode.com/problems/path-sum-iii/
 */
public class PathSumIII {
    int count = 0;
    public int pathSum(TreeNode root, int sum) {

        find(root,sum);
        return count;
    }

    private void find(TreeNode root, int sum) {
        if(root==null)
            return;
        helper(root,sum);
        find(root.left,sum);
        find(root.right,sum);
    }


    private void  helper(TreeNode root, int sum) {

        if(root== null)
            return ;
        sum = sum - root.val;

        if(sum == 0) {
            count ++;
        }
        helper(root.left,sum);
        helper(root.right,sum);

    }
}

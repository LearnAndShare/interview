package com.practice.tree.easy;

import com.practice.tree.TreeNode;

/*
https://leetcode.com/problems/path-sum-iii/

You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11

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

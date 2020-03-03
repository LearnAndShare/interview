package com.practice.tree.medium;

import com.practice.tree.TreeNode;
import com.practice.tree.TreeUtil;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/path-sum-ii/

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]

 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> listOfPaths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(root,sum,listOfPaths,path);
        return listOfPaths;
    }

    private void helper(TreeNode root, int target, List<List<Integer>> listOfPaths, List<Integer> path) {
        if(root == null)
            return;
        target -= root.val;
        path.add(root.val);
        if(target == 0 && root.left == null && root.right == null){
            listOfPaths.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }

        helper(root.left,target,listOfPaths,path);
        helper(root.right,target,listOfPaths,path);
        path.remove(path.size()-1);
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.createTreeFromArray(new int[]{5,1,2});
        PathSumII ps = new PathSumII();
        List<List<Integer>> li = ps.pathSum(root,6);
        li.forEach(e-> System.out.println("val::"+e));
    }
}

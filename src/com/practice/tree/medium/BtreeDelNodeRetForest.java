package com.practice.tree.medium;

import com.practice.tree.TreeNode;

import java.util.*;
/*
https://leetcode.com/problems/delete-nodes-and-return-forest/

Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

Return the roots of the trees in the remaining forest.  You may return the result in any order.
                            1
                           / \
                         2    3
                        /\    /\
                       4  5  6  7


Example 1:

Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]

 */
public class BtreeDelNodeRetForest {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> list = new LinkedList<>();

        if(root!=null && to_delete != null && to_delete.length>0){
            Set<Integer> nums = new HashSet<>();
            for (int i : to_delete) {
                nums.add(i);
            }

            dfs(root,nums,list);
            if(!nums.contains(root.val)){
                list.add(root);
            }
        }
        return list;
    }

    private TreeNode dfs(TreeNode root, Set<Integer> nums, List<TreeNode> list) {
        if(root == null)
            return null;

        root.left = dfs(root.left,nums,list);
        root.right = dfs(root.right,nums,list);

        if(nums.contains(root.val)){
            if(root.left != null)
                list.add(root.left);
            if(root.right != null)
                list.add(root.right);
            return null;
        }

        return root;
    }
}

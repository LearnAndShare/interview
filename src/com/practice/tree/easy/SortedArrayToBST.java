package com.practice.tree.easy;

import com.practice.tree.TreeNode;

/*
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:
Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5

 */
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length ==0)
            return null;
        return createArrayToBST(nums,0,nums.length);
    }

    private TreeNode createArrayToBST(int[] nums, int low, int high) {
        TreeNode t= null;
        if(low<high){
            int mid = low+high/2;
             t = new TreeNode(nums[mid]);
            t.left = createArrayToBST(nums,0,mid-1);
            t.right = createArrayToBST(nums,mid+1,nums.length);
        }
        return t;
    }
}

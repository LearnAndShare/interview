package com.practice.tree;
/*
https://leetcode.com/problems/maximum-binary-tree/

 Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
    The root is the maximum number in the array.
    The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
    The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.

Construct the maximum tree by the given array and output the root node of this tree.

 */
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length ==0)
            return null;
        return construct(nums,0,nums.length-1);
    }

    private TreeNode construct(int[] nums, int l, int r) {
        if(l>r)
            return null;
        int max_i = maxIdx(nums,l,r);
        TreeNode t = new TreeNode(nums[max_i]);
        t.left =  construct(nums,l,max_i-1);
        t.right = construct(nums,max_i+1,r);
        return t;
    }

    private int maxIdx(int[] nums, int l, int r) {
        int max = nums[l];
        int idx = l;
        for(int i=l+1;i<=r;i++){
            if(nums[i]>max){
                idx = i;
                max= nums[i];
            }
        }
        return idx;
    }


    public static void main(String[] args) {
        MaximumBinaryTree mbt  = new MaximumBinaryTree();
        mbt.constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
    }

}

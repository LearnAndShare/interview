package com.practice.tree;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
Given a Binary Search Tree and a target number, return true
if there exist two elements in the BST such that their sum is equal to the given target.
Input:
    5
   / \
  3   6
 / \   \
2   4   7

Inourder:2345678
Target = 9

Output: True
 */
public class TwoElementsEqualSumBST {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null)
            return false;
        List<Integer> l = new ArrayList<>();
        inorder(root,l);
        int cnt =0;
        int start =0,end = l.size()-1;
        while(start<end){
            int s =l.get(start)+l.get(end);
            if(s == k)
                return true;
            if(s<k){
                start++;
            } else {
                end--;
            }
        }
        return false;
    }



    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length ==0)
            return null;

        int l = 0;
        int r = numbers.length-1;
        while(l<r){
            int sum =numbers[l]+numbers[r];
            if(sum == target){
                return  new int[]{l+1,r+1};
            }
            if(sum < target){
                l++;
            } else {
                r--;
            }

        }
        return null;
    }

    private void inorder(TreeNode root, List<Integer> l) {
        if(root == null)
            return;
        inorder(root.left,l);
        l.add(root.val);
        inorder(root.right,l);

    }

}

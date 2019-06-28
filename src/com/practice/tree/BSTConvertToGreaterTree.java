package com.practice.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
https://leetcode.com/problems/convert-bst-to-greater-tree/
Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

Example:
Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13


 */
public class BSTConvertToGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        if(root == null)
            return null;
        List<Integer> vals = new ArrayList<>();
        inorder(root,vals);
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode t = s.pop();
            int sum = findSumValGreater(vals,t.val);

            if(t.left != null){
                s.push(t.left);
            }
            if(t.right != null){
                s.push(t.right);
            }
            t.val += sum;
        }
        return root;
    }

    private int findSumValGreater(List<Integer> vals, int val) {
        int l = 0;
        int  r = vals.size()-1;
        int m = -1;
        int idx = 0;
        while(l<=r){
            m = (l+r)/2;
            int v = vals.get(m);
            if( v == val) {
                idx = m;
                break;
            }
            if(val > v){
                l = m+1;
            } else {
                r = m-1;
            }

        }
        int sum = 0;

        for(int i=idx+1;i<vals.size();i++){
            sum+= vals.get(i);
        }
        return sum;
    }

    private void inorder(TreeNode root, List<Integer> vals) {
        if(root != null){
            inorder(root.left,vals);
            vals.add(root.val);
            inorder(root.right,vals);

        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.createTreeFromArray(new int[]{2,0,3,-4,1});
        BSTConvertToGreaterTree b = new BSTConvertToGreaterTree();
        b.convertBST(root);
        List<Integer> l = new ArrayList<>();
        b.inorder(root,l);
       l.forEach(System.out::println);
    }
}

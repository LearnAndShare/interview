package com.practice.tree.easy;

import com.practice.tree.TreeNode;
import com.practice.tree.TreeUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/find-mode-in-binary-search-tree/
Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
 */
public class ModeBinarySearchTree {
    Map<Integer,Integer> countMap = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    int maxCount = -1;
    public int[] findMode(TreeNode root) {
            if(root == null)
                return new int[]{};
            inorder(root);
            int [] num = new int[list.size()];
            int idx = 0;
            for (int listVal : list) {
                //System.out.println("list val::"+ listVal);
                num[idx++] = listVal;
            }
            return num;
    }

    private void inorder(TreeNode root) {
        if(root != null){
            inorder(root.left);
            int val = root.val;
            int count = countMap.getOrDefault(root.val,0);
            count++;
            countMap.put(root.val,count);
            if(count > maxCount){
                list = new ArrayList<>();
                list.add(val);
                maxCount = count;
            } else if(count == maxCount){
                list.add(val);
            }

            inorder(root.right);

        }
    }

    public static void main(String[] args) {
        ModeBinarySearchTree mbst = new ModeBinarySearchTree();
        TreeNode root = TreeUtil.createTreeFromArray(new int[]{1,1,1,2,2,2});
//        TreeNode root = TreeUtil.createTreeFromArray(new int[]{1,2,1});
        int[] n  = mbst.findMode(root);
    }
}

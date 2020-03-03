package com.practice.tree.medium;
/*
https://leetcode.com/problems/find-largest-value-in-each-tree-row/
You need to find the largest value in each row of a binary tree.

Example:

Input:

          1
         / \
        3   2
       / \   \
      5   3   9

Output: [1, 3, 9]

 */
import com.practice.tree.TreeNode;
import com.practice.tree.TreeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BTreeRowLargestVal {
    public List<Integer> largestValues(TreeNode root) {
       List<Integer> list  = new ArrayList<>();
       if(root != null) {
           LinkedList<TreeNode> ll = new LinkedList<>();
           ll.add(root);
           while (!ll.isEmpty()) {
               int size = ll.size();
               int max = Integer.MIN_VALUE;
               for (int i = 0; i < size; i++) {
                   TreeNode t = ll.pollFirst();
                   max = Math.max(t.val, max);
                   if (t.left != null) {
                       ll.add(t.left);
                   }
                   if (t.right != null) {
                       ll.add(t.right);
                   }
               }

               list.add(max);

           }
       }
       return list;
    }

    public static void main(String[] args) {
        BTreeRowLargestVal b = new BTreeRowLargestVal();

        TreeNode root = TreeUtil.createTreeFromArray(new int[]{1,3,2,5,3,8,9});
//        mbt.flipEquiv(root,root);
        List<Integer> li = b.largestValues(root);
        li.forEach(System.out::print);
    }
}

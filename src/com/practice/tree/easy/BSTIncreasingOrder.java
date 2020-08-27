package com.practice.tree.easy;

import com.practice.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
https://leetcode.com/problems/increasing-order-search-tree/
Given a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree,
and every node has no left child and only 1 right child.
xample 1:
Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]

       5
      / \
    3    6
   / \    \
  2   4    8
 /        / \
1        7   9

Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

 1
  \
   2
    \
     3
      \
       4
        \
         5
          \
           6
            \
             7
              \
               8
                \
                 9
 */
public class BSTIncreasingOrder {
    public TreeNode increasingBST(TreeNode root) {
        if(root == null )
            return null;
        List<Integer> vals = new ArrayList<>();
        inOrder(root,vals);
        TreeNode ans = new TreeNode(0), cur = ans;
        for (int val : vals) {
            ans.right = new TreeNode(val);
            ans = ans.right;
        }
        return cur.right;
    }

    private void inOrder(TreeNode root, List<Integer> vals) {
        if(root == null)
            return;
        inOrder(root.left,vals);
        vals.add(root.val);
        inOrder(root.right,vals);
    }
    public TreeNode increasingBSTIterative(TreeNode root) {
        if(root == null)
            return  null;
        TreeNode curr = root, head = new TreeNode(0), prev = null;
        Stack<TreeNode> s = new Stack<>();

        while(curr != null){
            s.push(curr);
            curr = curr.left;
        }

        curr =null;
        while(!s.isEmpty()){
            TreeNode t = s.pop();

            if(t.right != null){
                TreeNode t1 = t.right;
                while(t1 != null){
                    s.push(t1);
                    t1=t1.left;
                }
            }
            if(head.right == null)
                head.right = t;
            else
                prev.right = t;
            t.left = null;
            prev = t;

        }
        return head.right;
    }
}

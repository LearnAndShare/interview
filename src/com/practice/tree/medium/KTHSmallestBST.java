package com.practice.tree.medium;

import com.practice.tree.TreeNode;

import java.util.Stack;

/*
https://leetcode.com/problems/kth-smallest-element-in-a-bst/
Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1

Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3

 */
public class KTHSmallestBST {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return -1;

        Stack<TreeNode> s = new Stack<>();
        while(root != null){
            s.push(root);
            root = root.left;
        }
        int i = 1;
        while(!s.isEmpty()){
            TreeNode tmp =s.pop();
            int v = tmp.val;
            if(i == k)
                return v;
            ++i;
            TreeNode r = tmp.right;
            while(r!= null){
                s.push(r);
                r= r.left;
            }
        }
        return -1;
    }
}

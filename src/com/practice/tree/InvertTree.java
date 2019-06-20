package com.practice.tree;

import java.util.LinkedList;

/*
Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9

Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;
        invertTreeRecursive(root);
        return root;
    }

    private void invertTreeRecursive(TreeNode root) {
        if(root == null)
            return;
        invertTreeRecursive(root.left);
        invertTreeRecursive(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

    }


    private void invertTreeIterative(TreeNode root){
        if(root != null) {
            LinkedList<TreeNode> l =new LinkedList<>();
            l.add(root);

            while(!l.isEmpty()){
                TreeNode t = l.poll();
                if(t.left !=null)
                    l.add(t.left);
                if(t.right!=null)
                    l.add(t.right);
                TreeNode tmp = t.left;
                t.left = t.right;
                t.right = tmp;
            }


        }
    }
}

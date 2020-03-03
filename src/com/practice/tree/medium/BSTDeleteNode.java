package com.practice.tree.medium;

import com.practice.tree.TreeNode;

/*
https://leetcode.com/problems/delete-node-in-a-bst/
Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Note: Time complexity should be O(height of tree).

Example:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

Given key to delete is 3. So we find the node with value 3 and delete it.

One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

    5
   / \
  4   6
 /     \
2       7


Another valid answer is [5,2,6,null,4,null,7].

    5
   / \
  2   6
   \   \
    4   7
 */
public class BSTDeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root !=  null){
            TreeNode t = root;
            TreeNode par = null;
            while(t != null){
                if(key == t.val){
                    break;
                }

                par = t;
                if(key>t.val)
                    t = t.right;
                else
                    t = t.left;
            }

            if(par == null){
                return deleteNode(t);
            } else if(par.left == t){
                par.left = deleteNode(t);
            } else {
                par.right = deleteNode(t);
            }

        }

        return root;
    }

    private TreeNode deleteNode(TreeNode node) {
        if(node == null){
            return null;
        }

        if(node.left == null)
            return node.right;

        if(node.right == null)
            return node.left;

        TreeNode leftMost = node.right;
        TreeNode parent = null;
        while(leftMost.left != null){
            parent = leftMost;
            leftMost = leftMost.left;
        }

        leftMost.left = node.left;
        if(node.right != leftMost){
            parent.left = leftMost.right;
            leftMost.right = node.right;
        }

        return leftMost;
    }
}

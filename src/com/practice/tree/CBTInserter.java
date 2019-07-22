package com.practice.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/*

A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.

Write a data structure CBTInserter that is initialized with a complete binary tree and supports the following operations:

CBTInserter(TreeNode root) initializes the data structure on a given tree with head node root;
CBTInserter.insert(int v) will insert a TreeNode into the tree with value node.val = v so that the tree remains complete, and returns the value of the parent of the inserted TreeNode;
CBTInserter.get_root() will return the head node of the tree.


Example 1:

Input: inputs = ["CBTInserter","insert","get_root"], inputs = [[[1]],[2],[]]
Output: [null,1,[1,2]]
Example 2:

Input: inputs = ["CBTInserter","insert","insert","get_root"], inputs = [[[1,2,3,4,5,6]],[7],[8],[]]
Output: [null,3,4,[1,2,3,4,5,6,7,8]]

 */
public class CBTInserter {
    Deque<TreeNode> leaves ;
    private TreeNode root;
    public CBTInserter(TreeNode root) {
        leaves = new ArrayDeque<>() ;
        this.root = root;
        Deque<TreeNode> q2 = new ArrayDeque<>();
        q2.push(root);
        while(!q2.isEmpty()){
            TreeNode t = q2.remove();
            if(t.left == null || t.right == null){
                leaves.add(t);
            }

            if(t.left != null)
                q2.add(t.left);

            if(t.right != null)
                q2.add(t.right);
        }
    }

    public int insert(int v) {
        TreeNode node = new TreeNode(v);
        TreeNode p = leaves.peek();
        if(p.left == null){
            p.left = node;

        } else {
            p.right = node;
            leaves.remove();
        }
        leaves.add(node);
        return p.val;
    }

    public TreeNode get_root() {
        return root;
    }
}

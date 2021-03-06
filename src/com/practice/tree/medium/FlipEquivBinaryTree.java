package com.practice.tree.medium;

import com.practice.tree.TreeNode;
import com.practice.tree.TreeUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/*
https://leetcode.com/problems/flip-equivalent-binary-trees/

For a binary tree T, we can define a flip operation as follows: choose any node, and swap the left and right child subtrees.

A binary tree X is flip equivalent to a binary tree Y if and only if we can make X equal to Y after some number of flip operations.

Write a function that determines whether two binary trees are flip equivalent.  The trees are given by root nodes root1 and root2.



Example 1:

Input: root1 = [1,2,3,4,5,6,null,null,null,7,8], root2 = [1,3,2,null,6,4,5,null,null,null,null,8,7]
Output: true
Explanation: We flipped at nodes with values 1, 3, and 5.

 */
public class FlipEquivBinaryTree {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 ==null ||root2==null){
            return false;
        }

        LinkedList<TreeNode> l = new LinkedList<>();
        l.add(root1);
        l.add(root2);
        while(!l.isEmpty()){
            TreeNode t1 = l.pollFirst();
            TreeNode t2 = l.pollFirst();
            if(t1 == null && t2 == null)
                continue;
            if(!equals(t1,t2)){
                return false;
            }

            if(equals(t1.left,t2.left) && equals(t1.right,t2.right)){
                l.add(t1.left);
                l.add(t2.left);
                l.add(t1.right);
                l.add(t2.right);
            } else if(equals(t1.left,t2.right) && equals(t1.right,t2.left)){
                l.add(t1.left);
                l.add(t2.right);
                l.add(t1.right);
                l.add(t2.left);
            } else {
                return false;
            }
        }
        return true;


    }

    private boolean equals(TreeNode t1, TreeNode t2) {
        if(t1 == null || t2 == null || t1.val != t2.val)
            return false;
        return true;
    }


    public String bfs(TreeNode root){
        LinkedList<TreeNode> l = new LinkedList<>();
        l.add(root);
        List<Integer> list = new ArrayList<>();
        while(!l.isEmpty()){
            int s = l.size();
            for(int i=0;i<s;i++){
                TreeNode t = l.pollFirst();
                list.add(t.val);
                if(t.left  != null){
                    l.add(t.left);
                }
                if(t.right != null){
                    l.add(t.right);
                }
            }

            Collections.sort(list);
        }
        StringBuilder s = new StringBuilder();
        list.forEach(e->s.append(e));
        return s.toString();
    }


    public static void main(String[] args) {
        FlipEquivBinaryTree mbt  = new FlipEquivBinaryTree();
        TreeNode root = TreeUtil.createTreeFromArray(new int[]{1,2,3,4,5,6,7});
        TreeNode root1 = TreeUtil.createTreeFromArray(new int[]{1,3,2,6,5,6,7});
//        mbt.flipEquiv(root,root);
        System.out.print(mbt.bfs(root));
    }
}

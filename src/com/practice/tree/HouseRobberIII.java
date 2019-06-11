package com.practice.tree;

import com.practice.HouseRobber;

import java.util.Stack;

/*
https://leetcode.com/problems/house-robber-iii/

 */
public class HouseRobberIII {
    public int rob(TreeNode root) {
        if(root == null){
            return 0;
        }

        Stack<TreeNode> s1 = new Stack<>();
        s1.push(root);
        Stack<TreeNode> s2 = new Stack<>();
        int l1 = 0;
        int l2 = 0;
        int max= 0;
        while(!s1.isEmpty() || !s2.isEmpty()){
            while(!s1.isEmpty()){
                TreeNode n = s1.pop();
                l1 += n.val;
                if(n.left!= null){
                    s2.push(n.left);
                }
                if(n.right != null){
                    s2.push(n.right);
                }

            }
            l1 = Math.max(l1,l2);
            while(!s2.isEmpty()){
                TreeNode n = s2.pop();
                l2 += n.val;
                if(n.left!= null){
                    s1.push(n.left);
                }
                if(n.right != null){
                    s1.push(n.right);
                }

            }
            l2 = Math.max(l1,l2);
        }

        return Math.max(l1,l2);
    }

    public static void main(String[] args) {
        HouseRobberIII h = new HouseRobberIII();
        TreeNode n = new TreeNode(4);
        n.left = new TreeNode(1);

        n.left.left = new TreeNode(2);
        n.left.left.right = new TreeNode(3);
        System.out.println(h.rob(n));

    }

}

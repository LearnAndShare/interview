package com.practice.tree;

import javafx.beans.binding.StringBinding;

import java.util.*;

/*
https://leetcode.com/problems/cousins-in-binary-tree/
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

 */
public class BinaryTreeCousins {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null )
            return false;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        Stack<TreeNode> sChild = new Stack<>();
        Map<Integer,List<String>> depthChild = new HashMap<>();
        int lvl = 0;
        depthChild.putIfAbsent(lvl,new ArrayList<>());
        int xlvl = 0;
        int ylvl = 0;
        boolean xFound = false;
        boolean yFound = false;
        while(!s.isEmpty() || !sChild.isEmpty()){
            if(xFound && yFound)
                break;
            TreeNode t = s.pop();
            List<String> list = depthChild.getOrDefault(lvl,new ArrayList<>());
            if(t.left != null) {
                sChild.push(t.left);
                list.add(t.left.val+":"+t.val);
                if(!xFound && x == t.left.val ){
                    xlvl = lvl;
                    xFound = true;
                }
                if(!yFound && y == t.left.val ){
                    yFound = true;
                    ylvl = lvl;
                }


            }
            if(t.right != null) {
                sChild.push(t.right);
                list.add(t.right.val+":"+t.val);
                if(!xFound && x == t.right.val ){
                    xlvl = lvl;
                }
                if(!yFound && y == t.right.val ){
                    ylvl = lvl;
                    yFound = true;
                }
            }
            if(s.isEmpty()){
                lvl++;
                depthChild.putIfAbsent(lvl,new ArrayList<>());
                s = sChild;
                sChild = new Stack<>();
            }
        }

        System.out.println("xlvl::"+xlvl);
        System.out.println("ylvl::"+ylvl);

        if(xFound && yFound){
            if(xlvl != ylvl)
                return false;
            List<String>l = depthChild.get(xlvl);
            for (String s1 : l) {
                System.out.println(s1);
            }
            String xP = "";
            String yP = "";
            boolean xpFound = false;
            boolean ypFound= false;
            for (String s1 : l) {
                if(xpFound && ypFound)
                    break;
                if(s1.startsWith(x+"")){
                    xP = s1.substring(s1.indexOf(":"));
                    xpFound = true;
                }
                if(s1.startsWith(y+"")){
                    yP = s1.substring(s1.indexOf(":"));
                    ypFound = true;
                }
            }


            return !xP.equalsIgnoreCase(yP);

        }
        return false;
    }

    public boolean isCousinsLC(TreeNode root, int x, int y) {
        if(root == null) return false;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean isXSeen = false;
        boolean isYSeen = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode curr = queue.poll();
                if(curr.val == x) isXSeen = true;
                if(curr.val == y) isYSeen = true;
                if(curr.left != null && curr.right != null) {
                    if(curr.left.val == x && curr.right.val == y || curr.left.val == y && curr.right.val == x) return false;
                }
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
            if(isXSeen && isYSeen) return true;
            if(isXSeen || isYSeen) return false;
        }
        return false;
    }

    public static void main(String[] args) {

        TreeNode root = TreeUtil.createTreeFromArray(new int[]{1,2,3,4});
        BinaryTreeCousins bc = new BinaryTreeCousins();
        System.out.println(bc.isCousins(root,2,3));
    }
}

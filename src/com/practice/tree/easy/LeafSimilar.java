package com.practice.tree.easy;

import com.practice.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/leaf-similar-trees/
Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
 */
public class LeafSimilar {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> r1 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();
        dfs(root1,r1);
        dfs(root2,r2);
       /*
       if(r1.size() != r2.size()) return false;
        int j = 0;
        for (Integer i: r1) {
            if (i != r2.get(j++)) return false;
        }
        return true;
        */
        return r1.equals(r2);
    }

    private void dfs(TreeNode r, List<Integer> l) {
        if(r == null)
            return;

        if(r.left == null && r.right == null)
            l.add(r.val);
        dfs(r.left,l);
        dfs(r.right,l);
    }


}


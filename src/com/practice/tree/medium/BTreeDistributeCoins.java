package com.practice.tree.medium;

import com.practice.tree.TreeNode;

/*
https://leetcode.com/problems/distribute-coins-in-binary-tree/
Given the root of a binary tree with N nodes, each node in the tree has node.val coins, and there are N coins total.

In one move, we may choose two adjacent nodes and move one coin from one node to another.  (The move may be from parent to child, or from child to parent.)

Return the number of moves required to make every node have exactly one coin.
Input: [3,0,0]
Output: 2
 */
public class BTreeDistributeCoins {

    int moves = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }

    public int dfs(TreeNode node) {
        if(node == null)
            return 0;
        int lCoins = dfs(node.left);
        int rCoins = dfs(node.right);

        moves += Math.abs(lCoins)+ Math.abs(rCoins);
        return lCoins+rCoins+node.val - 1;

    }


}

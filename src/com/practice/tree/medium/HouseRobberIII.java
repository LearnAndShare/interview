package com.practice.tree.medium;

import com.practice.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/house-robber-iii/

For this problem you can use post order traversal technique.Before processing the parent you need to findmax
and min for the left and right child.

https://leetcode.com/problems/house-robber-iii/discuss/79484/C%2B%2B-bottom-up-iterative-DP-solution

 */
public class HouseRobberIII {

    Map<TreeNode, Integer> dp = new HashMap<TreeNode, Integer>();
    public int rob(TreeNode root) {

        if(root == null){
            return 0;
        }

        if(dp.containsKey(root)){
            return dp.get(root);
        }
        int exclude = rob(root.left)+rob(root.right);
        TreeNode leftLeft = null;
        TreeNode leftRight = null;
        TreeNode rightLeft = null;
        TreeNode rightRight = null;

        if(root.left != null){
            leftLeft = root.left.left;
            leftRight = root.left.right;
        }

        if(root.right != null){
            rightLeft = root.right.left;
            rightRight = root.right.right;
        }

        int include= rob(leftLeft)+rob(leftRight)+rob(rightLeft)+rob(rightRight)+root.val;
        dp.put(root,Math.max(exclude,include));



        return dp.get(root);

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

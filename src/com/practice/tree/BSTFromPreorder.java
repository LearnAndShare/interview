package com.practice.tree;

/*
https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
Return the root node of a binary search tree that matches the given preorder traversal.
Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]
 */
public class BSTFromPreorder {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);

        for (int i = 1; i < preorder.length; i++) {
            TreeNode curr = root;
            TreeNode pn = curr;
            TreeNode t = new TreeNode(preorder[i]);
            while (curr != null) {
                pn = curr;
                if (preorder[i] < curr.val)
                    curr = curr.left;
                else
                    curr = curr.right;
            }

            if (preorder[i] < curr.val)
                pn.left = t;
            else
                pn.right = t;
        }

        return root;
    }

}

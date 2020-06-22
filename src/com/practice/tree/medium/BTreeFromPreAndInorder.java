package com.practice.tree.medium;

import com.practice.tree.TreeNode;
import com.practice.tree.TreeTraversal;

import java.util.Stack;

/*
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/discuss/34607/Deep-Understanding-on-the-Iterative-Solution

Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]

Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7


 */
public class BTreeFromPreAndInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder== null || inorder == null)
                return null;
        int preIdx = 0;
        int inIdx = 0;
        TreeNode t = new TreeNode(preorder[preIdx++]);
        Stack<TreeNode> st= new Stack<>();
        st.push(t);
        while(true){
            while(st.peek().val!=inorder[inIdx]){
                TreeNode n = new TreeNode(preorder[preIdx++]);
                st.peek().left = n;
                st.push(n);
            }
            TreeNode node = null;
            while(!st.empty() && st.peek().val == inorder[inIdx]){
                node = st.pop();
                ++inIdx;
            }
            if(preIdx == preorder.length)
                break;
            TreeNode t1 = new TreeNode(preorder[preIdx++]);
            node.right = t1;
            st.push(t1);


        }
        return t;
    }

    public static void main(String[] args) {
        BTreeFromPreAndInorder bt= new BTreeFromPreAndInorder();
        int[] pre = new int[]{3,9,20,15,7};
        int[] post = new int[]{9,3,15,20,7};
        TreeNode t = bt.buildTree(pre,post);
        TreeTraversal t1 = new TreeTraversal();
        t1.preOrderTraversal(t).forEach(System.out::print);
    }


}

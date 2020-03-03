package com.practice.tree.medium;

import com.practice.tree.TreeNode;
import com.practice.tree.TreeTraversal;
import com.practice.tree.TreeUtil;

/*
https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
 */
public class FlattenBTree {

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        TreeNode node = root;
        while (node.left != null || node.right != null) {

            if (node.left != null) {
                if (node.right != null) {
                    TreeNode tmp = node.right;
                    TreeNode r = findRightMostNodeInLeftSubtree(node.left);

                    r.right = tmp;
                }
                node.right = node.left;
                node.left = null;
                node = node.right;

            } else {
                node = node.right;
            }


        }
    }

    private TreeNode findRightMostNodeInLeftSubtree(TreeNode n) {
        TreeNode r = n;
        while(n != null){
            r= n;
            n = n.right;
        }
        return r;
    }

    public static void main(String[] args) {
//        TreeNode root = TreeUtil.createTreeFromArray(new int[]{20,15,50,10,16,30,60});
//        TreeNode root = TreeUtil.createTreeFromArray(new int[]{1,2,5,3,4,7,6});
        TreeNode root = TreeUtil.createTreeFromArray(new int[]{1,2});
//        TreeNode root = TreeUtil.createTreeFromArray(new int[]{1,2,5});
        FlattenBTree f = new FlattenBTree();
        f.flatten(root);
        TreeTraversal t = new TreeTraversal();
        System.out.println("Serialize::"+ t.preOrderTraversal(root));
    }

}

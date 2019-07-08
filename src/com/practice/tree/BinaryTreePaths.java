package com.practice.tree;

import java.util.ArrayList;
import java.util.List;
/*
https://leetcode.com/problems/binary-tree-paths/
Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> l = new ArrayList<>();
        if(root == null)
            return l;
        helper(root,String.valueOf(root.val),l);
        return l;
    }

    private void helper(TreeNode root, String val, List<String> l) {
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            l.add(val);
            return;
        }
        if(root.left !=null){
            helper(root.left,val + "->"+root.left.val,l);
        }
        if(root.right !=null){
            helper(root.right,val + "->"+root.right.val,l);
        }
    }
}

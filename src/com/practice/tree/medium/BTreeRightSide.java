package com.practice.tree.medium;

import com.practice.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
https://leetcode.com/problems/binary-tree-right-side-view/
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

 */
public class BTreeRightSide {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root !=null){
            LinkedList<TreeNode> l =new LinkedList<>();
            l.add(root);
            while(!l.isEmpty()){
                int size = l.size();
                TreeNode tmp=null;
                for(int i=0;i<size;i++){
                    TreeNode t = l.poll();

                    if(t.left != null){
                        l.add(t.left);
                    }

                    if(t.right != null){
                        l.add(t.right);
                    }

                    tmp=t;
                }
                if(tmp !=null){
                    list.add(tmp.val);
                }
            }

        }

        return list;
    }
}

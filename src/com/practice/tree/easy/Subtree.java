package com.practice.tree.easy;

/*
https://leetcode.com/problems/subtree-of-another-tree/
 */

import com.practice.tree.TreeNode;

public class Subtree {
    public boolean isSubtree(TreeNode s, TreeNode t) {

        if(s == null && t == null)
            return true;
        String tree1 = preorder(s, true);
        String tree2 = preorder(t, true);
        System.out.println("tree1"+tree1);
        System.out.println("tree2"+tree2);
        return tree1.contains(tree2);
    }

    public String preorder(TreeNode t,boolean isLeft){

        if(t == null){
            if(isLeft)
                return "lnull";
            else
                return "rnull";
        }


        return "#"+String.valueOf(t.val)+ preorder(t.left,true)+preorder(t.right,false);
    }

}

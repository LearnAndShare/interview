package com.practice.tree;

import java.util.Stack;

public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null ||(root.left == null && root.right ==null))
            return 0;

        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        int sum = 0;

        while(!s.isEmpty()){
            TreeNode t = s.pop();
            TreeNode tLeft = t.left;
            if(tLeft != null) {
                if (tLeft.left == null && tLeft.right == null)
                    sum += t.val;
                s.push(tLeft);
            }

            t = t.right;
            if(t !=null){
                s.push(t);
            }
        }
        return sum;
    }

    public int sumOfLeftLeavesRC(TreeNode root) {
        if(root == null)
            return 0;
        return helper(root,false);
    }

    private int helper(TreeNode root, boolean isLeft) {
        if(root == null )
            return 0;

        if(isLeft && root.left == null && root.right == null)
            return root.val;
        return helper(root.left,true)+ helper(root.right,false);
    }


}

package com.practice.tree;

public class PreOrderStringFromBTree {
    public String tree2strhelper(TreeNode t) {
        if (t== null )
            return "";
        return helper(t);
    }

    private String helper(TreeNode t) {
        if(t == null)
            return "";
        if(t.left == null && t.right == null)
            return t.val + "";
        if(t.right == null)
            return  t.val + "(" + helper(t.left) + ")";
        return t.val + "("+ helper(t.left)+")("+helper(t.right)+")";
    }

    public String tree2str(TreeNode t) {
        StringBuilder sb =new StringBuilder();
        if (t== null )
            return "";
        sb.append(t.val);
        if(t.left != null && t.right == null){
            sb.append("(").append(tree2str(t.left)).append(")");
        }
        if(t.left == null&& t.right != null){
            sb.append("()(").append(tree2str(t.right)).append(")");
        }

        if(t.left!=null&& t.right != null){
            sb.append("(").append(tree2str(t.left)).append(")(").append(tree2str(t.right)).append(")");
        }
        return sb.toString();
    }
}

package com.practice.tree;

import java.util.Stack;

public class RangeSumBST {
    int ans;
    public int rangeSumBST(TreeNode root, int L, int R) {
        ans = 0;
        if(root != null){
            dfs(root,L,R);
        }
        return ans;
    }

    private void dfs(TreeNode root, int l, int r) {
        if(root == null)
            return ;
        if(root.val >=l && root.val <=r)
            ans = ans+root.val;
        dfs(root.left,l,r);
        dfs(root.right,l,r);


    }

    private int rangeIterative(TreeNode root, int L, int R){
       int sum =0;
       if(root != null){
           Stack<TreeNode> s = new Stack<>();

            s.push(root);

           while(!s.isEmpty()){
               TreeNode t = s.pop();
               if(t.val >=L && t.val <=R){
                   sum +=t.val;
               }

               if(t.left != null)
                   s.push(t.left);
               if(t.right != null)
                   s.push(t.right);
           }
       }
       return sum;
    }
}

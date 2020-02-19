package com.practice.tree;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */
public class SumAllRootToLeafPath {
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return root.val;
        List<String> allPaths = new ArrayList<>();
        int sum = 0;
        helper(root,allPaths,String.valueOf(root.val));
        for (String allPath : allPaths) {
            System.out.println("path:" + allPath);
            sum += Integer.parseInt(allPath);
        }
        return sum;
    }

    private void helper(TreeNode root, List<String> allPaths ,String val) {
        if(root == null)
            return ;
        if(root.left == null && root.right==null){
            allPaths.add(String.valueOf(val));
            return ;
        }
//        allPaths.add(val);
        if(root.left != null){

            helper(root.left,allPaths,val+root.left.val);
        }

        if(root.right != null)
            helper(root.right,allPaths,val+root.right.val);


    }

    public int sumNumbers2(TreeNode root) {
        return  sumNumbers(root,0);
    }

    private int sumNumbers(TreeNode node,int val){
        if(node ==null)
            return 0;
        if(node.left== null && node.right == null) {
            return val+node.val;
        }
        val = (node.val+val)*10;

        return sumNumbers(node.left,val)+sumNumbers(node.right,val);

    }
    public static void main(String[] args) {
        TreeNode root = TreeUtil.createTreeFromArray(new int[]{1,2,3});
        SumAllRootToLeafPath b = new SumAllRootToLeafPath();
        System.out.println("sum::"+b.sumNumbers(root));
         root = TreeUtil.createTreeFromArray(new int[]{4,9,0,5,1});

        System.out.println("sum::"+b.sumNumbers(root));
        System.out.println("sum::"+b.sumNumbers2(root));
    }
}

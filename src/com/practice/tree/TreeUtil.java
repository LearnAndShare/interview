package com.practice.tree;

import java.util.HashMap;
import java.util.Map;

public class TreeUtil {
/*
Input  :  arr[] = {1, 2, 3, 4, 5, 6}
Output : Root of the following tree
                  1
                 / \
                2   3
               / \ /
              4  5 6


Input: arr[] = {1, 2, 3, 4, 5, 6, 6, 6, 6, 6}
Output: Root of the following tree
                   1
                  / \
                 2   3
                / \ / \
               4  5 6  6
              / \ /
             6  6 6
 */
    public static TreeNode createTreeFromArray(int[] arr){
        if(arr == null || arr.length ==0)
            return null;
        TreeNode t = new TreeNode(arr[0]);
        Map<Integer,TreeNode> m = new HashMap<>();
        m.put(0,t);
        for(int i=0;i<arr.length/2;i++){
            int left = 2*i+1;
            int right = 2*i+2;
            TreeNode t1 = m.get(i);
            if(t1 !=null) {
                if (left < arr.length) {
                    t1.left = new TreeNode(arr[left]);
                    m.put(left,t1.left);
                }
                if (right < arr.length) {
                    t1.right = new TreeNode(arr[right]);
                    m.put(right,t1.right);
                }
            }
        }
        return t;

    }

    public static void main(String[] args) {
        TreeNode t = TreeUtil.createTreeFromArray(new int[]{1, 2, 3, 4, 5, 6});
        TreeTraversal t1 = new TreeTraversal();
        t1.inorderTraversal(t).forEach(System.out::print);
        System.out.println("=======================");
         t = TreeUtil.createTreeFromArray(new int[]{1, 2, 3, 4, 5, 6, 6, 6, 6, 6});
        t1.inorderTraversal(t).forEach(System.out::print);
    }

}

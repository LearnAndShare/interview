package com.practice.tree;

import java.util.*;

public class BtreeDelNodeRetForest {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> list = new LinkedList<>();

        if(root!=null && to_delete != null && to_delete.length>0){
            Set<Integer> nums = new HashSet<>();
            for (int i : to_delete) {
                nums.add(i);
            }

            dfs(root,nums,list);
            if(!nums.contains(root.val)){
                list.add(root);
            }
        }
        return list;
    }

    private TreeNode dfs(TreeNode root, Set<Integer> nums, List<TreeNode> list) {
        if(root == null)
            return null;

        root.left = dfs(root.left,nums,list);
        root.right = dfs(root.right,nums,list);

        if(nums.contains(root.val)){
            if(root.left != null)
                list.add(root.left);
            if(root.right != null)
                list.add(root.right);
            return null;
        }

        return root;
    }
}

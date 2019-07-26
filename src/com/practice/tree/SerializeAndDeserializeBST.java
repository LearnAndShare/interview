package com.practice.tree;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
https://leetcode.com/problems/serialize-and-deserialize-bst/
 */
public class SerializeAndDeserializeBST {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root,sb);
        if(sb != null && sb.length()>0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();

    }

    private void preorder(TreeNode root, StringBuilder sb) {
        if(root != null){
            sb.append(root.val+",");
            preorder(root.left,sb);
            preorder(root.right,sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() <=0 )
            return null;
        String[] arr = data.split(",");
        int [] arrInt = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
        return deserializeHelperUsingStack(arrInt);
    }


    public TreeNode deserializeOn2(String data) {
        if(data.length() <=0 )
            return null;
        String[] arr = data.split(",");
        int [] arrInt = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
        return deserializeHelper(arrInt,0,arrInt.length-1);
    }



    //O(n2) solution
    private TreeNode deserializeHelper(int [] arr,int low,int high) {
        if(low>high || low == -1 || high == -1)
            return null;

        TreeNode root = new TreeNode(arr[low]);
        int rightIdx = findRightIdx(arr,low,high);
        if(rightIdx != -1) {
            root.left = deserializeHelper(arr, low + 1, rightIdx - 1);
            root.right = deserializeHelper(arr, rightIdx, high);
        }
        return root;
    }

    private int findRightIdx(int[] arr, int low, int high) {
        if(low == high)
            return -1;
        int val = arr[low];
        int idx = low+1;
        for(;idx<=high;idx++){
            if(arr[idx]>val){
                return idx;
            }
        }
        return high+1;
    }

    private TreeNode deserializeHelperUsingStack(int[] arr){

        TreeNode n = new TreeNode(arr[0]);
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(n);

        for(int idx = 1;idx<arr.length;idx++) {
            TreeNode tmp = null;
            int val = arr[idx];
            while (!stack.isEmpty() && stack.peek().val < val ) {
                tmp = stack.pop();
            }

            TreeNode t = new TreeNode(val);

            if(tmp != null){
                tmp.right = t;
            } else {
                tmp = stack.peek();
                tmp.left = t;
            }
            stack.push(t);
        }
        return n;
    }


    public static void main(String[] args) {
//        TreeNode root = TreeUtil.createTreeFromArray(new int[]{20,15,50,10,16,30,60});
//        TreeNode root = TreeUtil.createTreeFromArray(new int[]{2,1,3});
        SerializeAndDeserializeBST s = new SerializeAndDeserializeBST();
       /* TreeNode root = TreeUtil.createTreeFromArray(new int[]{2,1});

        String serialize = s.serialize(root);
        System.out.println("Serialize::"+ serialize);*/
        TreeNode deseriaizeRoot = s.deserialize("2,1,3");
        TreeTraversal t = new TreeTraversal();
        System.out.println("Serialize::"+ t.preOrderTraversal(deseriaizeRoot));
    }


}

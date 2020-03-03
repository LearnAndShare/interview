package com.practice.tree.medium;

import com.practice.tree.TreeNode;
import com.practice.tree.TreeUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/most-frequent-subtree-sum/
Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.

Examples 1
Input:

  5
 /  \
2   -3
return [2, -3, 4], since all the values happen only once, return all of them in any order.
Examples 2
Input:

  5
 /  \
2   -5
return [2], since 2 happens twice, however -5 only occur once.
 */
public class FrequestTreeSum {
    Map<Integer, Integer> frequencies;
    List<Integer> resultList = new ArrayList<Integer>();
    int maxFreq = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        frequencies = new HashMap<>();
        resultList = new ArrayList<Integer>();
        sumSubtree(root);
        int result[] = new int[resultList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    private int sumSubtree(TreeNode root){
        if (root == null) return 0;

        int sum = root.val + sumSubtree(root.left) + sumSubtree(root.right);
        int freq = frequencies.getOrDefault(sum, 0) + 1;
        if(freq > maxFreq){
            maxFreq = freq;
            resultList.clear();
            resultList.add(sum);
        } else if(freq == maxFreq){
            resultList.add(sum);
        }
        frequencies.put(sum, freq);
        return sum;

    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.createTreeFromArray(new int[]{5,2,-3});
        FrequestTreeSum fs = new FrequestTreeSum();
       int[]t =  fs.findFrequentTreeSum(root);
        for (int i : t) {
            System.out.print(" "+i);
        }
    }
}

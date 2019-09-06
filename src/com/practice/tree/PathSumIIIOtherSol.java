package com.practice.tree;

import java.util.HashMap;
import java.util.Map;
/*
Discussion Thread: https://leetcode.com/problems/path-sum-iii/discuss/91878/17-ms-on-java-prefix-sum-method
Similar Problem: https://www.geeksforgeeks.org/number-subarrays-sum-exactly-equal-k/

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
 */
public class PathSumIIIOtherSol {
    public int pathSum(TreeNode root, int sum) {
        Map<Integer,Integer> sumMap = new HashMap<>();
        sumMap.put(0,1);
        return helper(root,0,sum,sumMap);
    }

    private int helper(TreeNode root, int currSum, int target, Map<Integer, Integer> sumMap) {
        if(root ==null)
            return 0;
        currSum +=root.val;
        int res = sumMap.getOrDefault(currSum-target,0);
        sumMap.put(currSum,sumMap.getOrDefault(currSum,0)+1);
        res += helper(root.left,currSum,target,sumMap)+ helper(root.right,currSum,target,sumMap);
        sumMap.put(currSum,sumMap.get(currSum)-1);
        return res;
    }

}

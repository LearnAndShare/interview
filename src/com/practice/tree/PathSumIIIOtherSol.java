package com.practice.tree;

import java.util.HashMap;
import java.util.Map;

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

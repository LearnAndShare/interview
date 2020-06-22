package com.practice;
/*
https://leetcode.com/problems/house-robber-ii/

 */
public class HouseRobberII {
    public int rob(int[] nums) {
        if(nums == null || nums.length ==0 )
            return 0;
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        int firstHouseIncluded = findMax(nums,0,nums.length-1);

        int lastHouseIncluded = findMax(nums,1,nums.length-1);


        return Math.max(firstHouseIncluded,lastHouseIncluded);
    }

    public int findMax(int[]nums,int startHouseIdx,int lastHouseIdx){
        int len = nums.length -1;
        int[]dp = new int[len];
        dp[0] = nums[startHouseIdx];
        dp[1]= Math.max(dp[0],nums[startHouseIdx+1]);
        for(int k = 2;k<lastHouseIdx;k++){
            dp[k] = Math.max(dp[k-1],dp[k-2]+nums[startHouseIdx+k]);
        }

        return dp[len-1];
    }

    public static void main(String[] args) {
        HouseRobberII h = new HouseRobberII();
//        System.out.println(h.rob(new int[]{1, 2, 3, 1}));
        System.out.println(h.rob(new int[]{0,0}));
//        h.rob(new int[]{2,3,2});
    }
}

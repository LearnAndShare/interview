package com.practice;
/*
https://leetcode.com/problems/house-robber/

 */
public class HouseRobber {
    public int rob(int[] num) {
        if(num==null || num.length == 0)
            return 0;

        int even = 0;
        int odd = 0;

        for (int i = 0; i < num.length; i++) {
            if (i % 2 == 0) {
                even += num[i];
                even = even > odd ? even : odd;
            } else {
                odd += num[i];
                odd = even > odd ? even : odd;
            }
        }

        return even > odd ? even : odd;
    }
/*
[2,1,1,2]
 Expected: 4
 */


    public int robDP(int[] nums) {
        if(nums == null || nums.length ==0 )
            return 0;
        if(nums.length == 1)
            return nums[0];
        int[]dp=new int[nums.length];
        dp[0]= nums[0];
        dp[1]=Math.max(dp[0],nums[1]);

        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);

        }
        return dp[nums.length-1];
    }


    public static void main(String[] args) {
        HouseRobber h= new HouseRobber();
        System.out.println(h.robDP(new int[]{1, 2, 3, 1}));
    }
}

package com.practice.array.medium;
/*

https://leetcode.com/problems/maximum-product-subarray/

https://leetcode.com/problems/maximum-product-subarray/discuss/307098/Java-Solution-With-Explanation

Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.


 */
public class MaximumProductSubArray {
    public int maxProduct(int[] nums) {
        int[] dpMax = new int[nums.length];
        int [] dpMin = new  int[nums.length];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        int max = dpMax[0];
        for(int i=1;i<nums.length;i++){
            dpMax[i] = Math.max(nums[i]*dpMin[i-1],Math.max(nums[i],dpMax[i-1]*nums[i]));
            dpMin[i] = Math.min(nums[i]*dpMax[i-1],Math.min(nums[i],dpMin[i-1]*nums[i]));
            max = Math.max(max,dpMax[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumProductSubArray ms = new MaximumProductSubArray();
        System.out.println(ms.maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(ms.maxProduct(new int[]{2, 7, -2, 6}));
        System.out.println(ms.maxProduct(new int[]{-2, 0,-1}));

    }
}

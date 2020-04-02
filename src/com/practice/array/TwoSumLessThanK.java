package com.practice.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given an array A of integers and integer K, return the maximum S such that there exists
i < j with A[i] + A[j] = S and S < K.
If no i, j exist satisfying this equation, return -1.
Input : arr = {30, 20, 50} , K = 70
Output : 30, 20
30 + 20 = 50 which is maximum possible usm which is less than K
 */
public class TwoSumLessThanK {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return null;
        Arrays.sort(nums);
//{20,30,50}
        int breakPoint  = nums.length;
        for(int i=0;i<nums.length;i++){
            if(nums[i] > target) {
                breakPoint = i;
                break;
            }
        }
        int maxSum = Integer.MIN_VALUE,a=Integer.MIN_VALUE,b=Integer.MIN_VALUE;
        for(int i=0;i<breakPoint;i++){
            for(int j=i+1;j<breakPoint;j++){
                if(nums[i] + nums[j] < target && (nums[i] + nums[j] > maxSum)){
                    maxSum = nums[i] + nums[j];
                    a = i;
                    b = j;
                }
            }
        }
        if(a != Integer.MIN_VALUE && b != Integer.MIN_VALUE){
            return new int[]{a,b};
        }
        return null;

    }

    public static void main(String[] args) {
        TwoSumLessThanK ts = new TwoSumLessThanK();
        for (int i : ts.twoSum(new int[]{30, 20, 50}, 70)) {
            System.out.println(i);
        }

    }
}

package com.practice.array;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/continuous-subarray-sum/
Given a list of non-negative numbers and a target integer k,
write a function to check if the array has a continuous subarray of size at least 2 that sums up to a multiple of k, that is, sums up to n*k where n is also an integer.



Example 1:

Input: [23, 2, 4, 6, 7],  k=6
Output: True
Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.

Example 2:

Input: [23, 2, 6, 4, 7],  k=6
Output: True
Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.

 */
public class ContinuousSubarrayMutiple {
    /*
   in case of the array [23,2,6,4,7] the running sum is [23,25,31,35,42] and the remainders are [5,1,1,5,0].
   We got remainder 5 at index 0 and at index 3. That means, in between these two indexes we must have added a number which is multiple of the k. Hope this clarifies your doubt
   */
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return false;

        Map<Integer,Integer> map = new HashMap();
        //This is added in case starting element is multiple [2,4] 6
        map.put(0, -1);
        int currSum = 0;
       for(int i=0;i<nums.length;i++){
           currSum += nums[i];
           int rem = k ==0?currSum:currSum%k;
           if(map.containsKey(rem) ){
               int index = map.get(rem);
               if(i - index > 1)
                   return true;
           }
           map.putIfAbsent(rem,i);
       }
        return false;
    }

    public static void main(String[] args) {
        ContinuousSubarrayMutiple cs = new ContinuousSubarrayMutiple();
        System.out.println(cs.checkSubarraySum(new int[]{0, 0}, 0));

    }
}

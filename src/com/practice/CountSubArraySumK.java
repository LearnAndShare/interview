package com.practice;

import java.util.HashMap;

/*
https://www.geeksforgeeks.org/number-subarrays-sum-exactly-equal-k/
https://leetcode.com/problems/subarray-sum-equals-k/

Given an unsorted array of integers, find the number of subarrays having sum exactly equal to a given number k.


Input : arr[] = {10, 2, -2, -20, 10},
        k = -10
Output : 3
Subarrays: arr[0...3], arr[1...4], arr[3..4]
have sum exactly equal to -10.

Input : arr[] = {9, 4, 20, 3, 10, 5},
            k = 33
Output : 2
Subarrays : arr[0...2], arr[2...4] have sum
exactly equal to 33.

 */
public class CountSubArraySumK {
    int findSubarraySum(int arr[],  int sum){
        HashMap<Integer, Integer> prevSum = new HashMap<>();

        int res = 0;

        // Sum of elements so far.
        int currsum = 0;

        for (int i = 0; i < arr.length; i++) {

            // Add current element to sum so far.
            currsum += arr[i];

            // If currsum is equal to desired sum,
            // then a new subarray is found. So
            // increase count of subarrays.
            if (currsum == sum)
                res++;

            // currsum exceeds given sum by currsum
            //  - sum. Find number of subarrays having
            // this sum and exclude those subarrays
            // from currsum by increasing count by
            // same amount.
            if (prevSum.containsKey(currsum - sum))
                res += prevSum.get(currsum - sum);


            // Add currsum value to count of
            // different values of sum.
            Integer count = prevSum.get(currsum);
            if (count == null)
                prevSum.put(currsum, 1);
            else
                prevSum.put(currsum, count+1);
        }

        return res;
    }

    public static void main(String[] args) {
        CountSubArraySumK cs = new CountSubArraySumK();
        System.out.println(cs.findSubarraySum(new int[] { 10, 2, -2, -20, 10 },-10));
        System.out.println(cs.findSubarraySum(new int[] { 1,2,1 },2));
        System.out.println(cs.findSubarraySum(new int[] { 2,1,1 },2));
        System.out.println(cs.findSubarraySum(new int[] { 23, 2, 4, 6, 7 },6));
    }


}

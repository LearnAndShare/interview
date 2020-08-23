package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/minimum-absolute-difference/
Input: arr = [4,2,1,3]
Output: [[1,2],[2,3],[3,4]]
Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.

Example 2:

Input: arr = [1,3,6,10,15]
Output: [[1,3]]

Example 3:

Input: arr = [3,8,-10,23,19,-4,-14,27]
 */
public class MinAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<arr.length-1;i++){
            int diff = arr[i+1] - arr[i];
            if(diff<min){
                list.clear();
                List<Integer> l = new ArrayList<>();
                l.add(arr[i]);
                l.add(arr[i+1]);
                list.add(l);
                min = diff;
            } else if(diff ==min){
                List<Integer> l = new ArrayList<>();
                l.add(arr[i]);
                l.add(arr[i+1]);
                list.add(l);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        MinAbsoluteDifference ms = new MinAbsoluteDifference();
        ms.minimumAbsDifference(new int[]{1,3,6,10,15}).forEach(System.out::println);

    }
}

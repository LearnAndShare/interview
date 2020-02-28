package com.practice.array;
/*
https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/
Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time.

Return that integer.



Example 1:

Input: arr = [1,2,2,6,6,6,6,7,10]
Output: 6


 */
public class SpecialIntegerMaxTime {
    public int findSpecialInteger(int[] arr) {
        if(arr == null || arr.length == 0 )
            return 0;
        int count = 1;
        int ct = 1;
        int prevVal = arr[0];
        int v = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] == prevVal) {
                ++count;
            } else {
                if(count>ct) {
                    v = prevVal;
                    ct =count;
                }
                count = 1;
            }

            prevVal  = arr[i];

        }
        if(count>ct) {
            v = prevVal;
            ct =count;
        }
//        System.out.println("Max no::"+ ct);
        return v;
    }

    public int findSpecialIntegerQuarter(int[] arr) {
        int quater = arr.length / 4;
        int count = 1;
        if(arr.length == 1)
            return arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i] == arr[i+1]) {
                ++count;
                if(count>quater)
                    return arr[i];
            } else {
                count =1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        SpecialIntegerMaxTime sp = new SpecialIntegerMaxTime();
        System.out.println(sp.findSpecialInteger(new int[]{1, 2, 2, 6, 6, 6, 6, 7, 10}));
        System.out.println(sp.findSpecialInteger(new int[]{1,2,3,3}));

        System.out.println("===========================Using 25%=======================");
        System.out.println(sp.findSpecialIntegerQuarter(new int[]{1, 2, 2, 6, 6, 6, 6, 7, 10}));
        System.out.println(sp.findSpecialIntegerQuarter(new int[]{1,2,3,3}));
    }
}

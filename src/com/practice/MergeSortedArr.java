package com.practice;

import java.util.Arrays;

/*
https://leetcode.com/problems/merge-sorted-array/
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.

Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
 */
public class MergeSortedArr {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       int [] num = new int[m+n];
       int nums1idx=0,nums2idx=0,numsidx = 0;
       while(nums1idx<m && nums2idx<n){
            if(nums1[nums1idx] <= nums2[nums2idx]){
                num[numsidx++] = nums1[nums1idx];
                nums1idx++;

            } else {
                num[numsidx++] = nums2[nums2idx];
                nums2idx++;

            }
       }
       while(nums1idx<m){
           num[numsidx++] = nums1[nums1idx++];
       }
        while(nums2idx<n){
           num[numsidx++] = nums2[nums2idx++];
        }

        for(int i=0;i<num.length;i++){
            nums1[i] =num[i];
        }

    }

    public static void main(String[] args) {
        MergeSortedArr ms = new MergeSortedArr();
        int[] num1 = new int[6];
        num1[0]=1;
        num1[1]=2;
        num1[2]=3;
        int[] num2 = new int[]{2,5,6};
        ms.merge(num1,3,num2,3);
        for (int i : num1) {
            System.out.println(i);
        }
    }
}

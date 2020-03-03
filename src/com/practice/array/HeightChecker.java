package com.practice.array;

import java.util.Arrays;

/*
https://leetcode.com/problems/height-checker/
Students are asked to stand in non-decreasing order of heights for an annual photo.

Return the minimum number of students that must move in order for all students to be standing in non-decreasing order of height.



Example 1:

Input: heights = [1,1,4,2,1,3]
Output: 3

 */
public class HeightChecker {
    public int heightChecker(int[] heights) {
        if(heights == null || heights.length == 0)
            return -1;
        int[] h = Arrays.copyOf(heights,heights.length);
        int j =0;
        Arrays.sort(heights);
        for (int i = 0; i < h.length; i++) {
            if(h[i] != heights[i])
                ++j;
        }
        return j;
    }

    public int heightCheckerCountSort(int[] heights) {
        if(heights == null || heights.length == 0)
            return -1;
        int[] countArray = new int[101];
        for (int i : heights) {
            countArray[i]++;
        }

        int idx = 0;
        int ct = 0;
        for (int i = 0; i < countArray.length; i++) {
            while(countArray[i] != 0){
                if(i != heights[idx]){
                    ++ct;
                }
                countArray[i]--;
                idx++;
            }

        }
        return ct;
    }
    public static void main(String[] args) {
        HeightChecker hc = new HeightChecker();
        System.out.println(hc.heightCheckerCountSort(new int[]{1, 1, 4, 2, 3}));

    }
}

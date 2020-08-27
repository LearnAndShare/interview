package com.practice.google;

import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/container-with-most-water/
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
In this case, the max area of water (blue section) the container can contain is 49.

Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if(height == null || height.length == 0)
            return 0;
        int max = 0;
        int i=0;
        int j= height.length-1;

        while(i<j){
            max = Math.max(max,(j-i)*Math.min(height[i],height[j]));
            if(height[i]<height[j])
                ++i;
            else
                --j;
        }
        return max;
    }

    public int maxArea1(List<Integer> A) {
        int l=0;
        int r = A.size()-1;
        int max = 0;
        while(l<r){
            int low = A.get(l);
            int high = A.get(r);
            int area = Math.min(low,high) * Math.abs(r-l);
            max = Math.max(area,max);
            if(low<high){
                l++;
            } else{
                r--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ContainerWithMostWater cm = new ContainerWithMostWater();
        System.out.println(cm.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        List<Integer> li = Arrays.asList(new Integer[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(cm.maxArea1(li));

         li = Arrays.asList(new Integer[]{1,5, 4, 3});
        System.out.println(cm.maxArea1(li));
    }
}

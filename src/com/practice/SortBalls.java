package com.practice;

import java.util.ArrayList;
/*
https://leetcode.com/problems/sort-colors/

 */
public class SortBalls {
    public void sortColors(ArrayList<Integer> a) {

    }

    public void sortColors(int[] nums) {
        int p0 =0 ;
        int curr = 0;
        int p2 = nums.length-1;
        while(curr<=p2){
            if(nums[curr] == 0){
                nums[curr++] = nums[p0];
                nums[p0++] = 0;


            } else if(nums[curr] == 2){
                nums[curr] = nums[p2];
                 nums[p2--] = 2;

            } else {
                curr++;
            }
        }
    }

    public static void main(String[] args) {
        SortBalls sb = new SortBalls();
        int[]b = new int[]{2,0,2,1,1,0};
        sb.sortColors(b);
        for (int i : b) {
            System.out.print(i +",");
        }
        System.out.println();

        b = new int[]{2,0,1};
        b = new int[]{2,0,1};
        sb.sortColors(b);
        for (int i : b) {
            System.out.print(i +",");
        }
        System.out.println();
    }
}

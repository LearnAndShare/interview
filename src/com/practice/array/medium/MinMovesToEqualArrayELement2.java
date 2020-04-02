package com.practice.array.medium;

import java.util.Arrays;

/*
https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/discuss/94937/Java(just-like-meeting-point-problem)
sort the array first, for the first and last element, no matter what intermedia value you chose, the distance summary is always nums[right] - nums[left], do the same step for the second left most and right most. Why this the accmulated value minimum, if it is not , you will have a line which is above or below 2 points, every other pairs to the line is same, but the 2 points to the line is bigger than the line the program find.
 */
public class MinMovesToEqualArrayELement2 {
    public int minMoves2(int[] nums) {
        int move = 0;
        Arrays.sort(nums);
        int i=0;
        int j = nums.length-1;
        while(i<=j) {
            move += nums[j] - nums[i];
            i++;
            j--;
        }
        return move;
    }

    public static void main(String[] args) {
        MinMovesToEqualArrayELement2 ms = new MinMovesToEqualArrayELement2();
        System.out.println(ms.minMoves2(new int[]{1, 2, 3}));
    }
}

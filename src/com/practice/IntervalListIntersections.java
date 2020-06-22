package com.practice;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/interval-list-intersections/
Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
The intersection of two closed intervals is a set of real numbers that is either empty,
or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)

Example 1:


Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.


 */
public class IntervalListIntersections {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if(A == null || A.length ==0 ||B == null || B.length ==0)
            return new int[][]{};
        List<int[]> list = new ArrayList<>();
        int i=0,j=0;
        while(i<A.length && j<B.length){
            int lo = Math.max(A[i][0],B[j][0]);
            int high = Math.min(A[i][1],B[j][1]);
            if(lo <= high){
                list.add(new int[]{lo,high});
            }
            if(A[i][1]<B[j][1])
                ++i;
            else
                ++j;
        }
        int [][]arr = new int[list.size()][2];
        int idx = 0;
        for (int[] t : list) {
            arr[idx] = t;
            ++idx;
        }
        return  arr;
    }

    public static void main(String[] args) {
        /*int[][]a = new int[][]{{0,2},{5,10},{13,23},{24,25}};
        int [][]b = new int[][]{{1,5},{8,12},{15,24},{25,26}};*/
        int[][]a = new int[][]{{4,7},{8,14}};
        int[][]b = new int[][]{{3,4}};
        IntervalListIntersections is = new IntervalListIntersections();
        int [][] intersect = is.intervalIntersection(a,b);
        for (int[] ints : intersect) {
            for (int anInt : ints) {
                System.out.print(anInt+",");
            }
            System.out.println();
        }
    }
}

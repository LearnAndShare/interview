package com.practice;
/*
https://leetcode.com/problems/merge-intervals/
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length ==0 )
            return intervals;

        int r = intervals.length;
        int c = intervals[0].length;
        int [][] mergedInterval = new int[r][c];
        int lx = intervals[0][0];
        int ly = intervals[0][1];
        int mi = 0;
        for(int i=1;i<r;i++){
            int [] d = intervals[i];
            if(d[0] >lx && d[0] < ly && d[1] < ly){
               ly = d[1];
               mergedInterval[mi++] = new int[]{lx,ly};
            } else {

            }

        }

        return mergedInterval;

    }
}

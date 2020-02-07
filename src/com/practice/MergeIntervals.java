package com.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
    class Interval{
        public int start;
        public int end;

        @Override
        public String toString() {
            return "[" + start +","+ end + "]";
        }
    }
    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
        }
    }
    public int[][] merge(int[][] intervals) {
        List<Interval> intervalList = new ArrayList<>();
        for(int i=0;i<intervals.length;i++) {
            Interval inte= new Interval();
            inte.start = intervals[i][0];
            inte.end = intervals[i][1];
            intervalList.add(inte);
        }
        Collections.sort(intervalList,new IntervalComparator());
        System.out.println("============");
        intervalList.forEach(System.out::println);
        Interval prev = null;
        List<Interval> mergedList = new ArrayList<>();
         /*
        Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
         */
        for (Interval in:intervalList){

            if(prev == null || in.start>prev.end) {
                mergedList.add(in);
                prev=in;
            }else {
                prev.end=Math.max(prev.end,in.end);
            }


        }
        System.out.println("===========");
        mergedList.forEach(System.out::println);
        int[][] intArr = new int[mergedList.size()][2];
        int idx = 0;
        for(Interval i:mergedList){
            intArr[idx][0] = i.start;
            intArr[idx][1] = i.end;
            ++idx;
        }
        return intArr;

    }
}

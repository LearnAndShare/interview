package com.practice.array.medium;
/*
https://leetcode.com/problems/corporate-flight-bookings/
There are n flights, and they are labeled from 1 to n.

We have a list of flight bookings.  The i-th booking bookings[i] = [i, j, k] means that we booked k seats from flights labeled i to j inclusive.

Return an array answer of length n, representing the number of seats booked on each flight in order of their label.



Example 1:

Input: bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
Output: [10,55,45,25,25]

 */
public class CoroporateFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ret = new int[n];
        for (int[] booking : bookings) {
            int idx1 = booking[0]-1;
            int idx2 = booking[1]-1;
            while(idx1<=idx2){
                ret[idx1] += booking[2];
                idx1++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        CoroporateFlightBookings cp = new CoroporateFlightBookings();
        int[] o = cp.corpFlightBookings(new int[][]{{1,2,10},{2,3,20},{2,5,25}},5) ;
        for (int i : o) {
            System.out.println(i);
        }
    }
}

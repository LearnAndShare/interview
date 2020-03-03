package com.practice.array;
/*

https://leetcode.com/problems/minimum-time-visiting-all-points/discuss/451405/Java-Solution-and-my-humble-explanation-easy-to-understand
https://leetcode.com/problems/minimum-time-visiting-all-points/
On a plane there are n points with integer coordinates points[i] = [xi, yi]. Your task is to find the minimum time in seconds to visit all points.

You can move according to the next rules:

    In one second always you can either move vertically, horizontally by one unit or diagonally (it means to move one unit vertically and one unit horizontally in one second).
    You have to visit the points in the same order as they appear in the array.
Example 1:

Input: points = [[1,1],[3,4],[-1,0]]
Output: 7
Explanation: One optimal path is [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]
Time from [1,1] to [3,4] = 3 seconds
Time from [3,4] to [-1,0] = 4 seconds
Total time = 7 seconds

Example 2:

Input: points = [[3,2],[-2,2]]
Output: 5


 */
public class MinTimeVisitAllPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        if(points == null || points.length == 0)
            return 0;
        int dis = 0;
        int[] src = points[0];
        for(int i=1;i<points.length;i++){
            int[] p = points[i];
            int disX = Math.abs(p[0]-src[0]);
            int disY = Math.abs(p[1]-src[1]);
            dis += Math.max(disX,disY);
            src = p;
        }
        return dis;
    }



    public static void main(String[] args) {
        MinTimeVisitAllPoints m = new MinTimeVisitAllPoints();
        System.out.println(m.minTimeToVisitAllPoints(new int[][]{{1, 1}, {3, 4}, {-1, 0}}));
        System.out.println(m.minTimeToVisitAllPoints(new int[][]{{3, 2}, {-2, 2}}));
    }
}

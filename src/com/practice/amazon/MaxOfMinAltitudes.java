package com.practice.amazon;
/*
https://leetcode.com/discuss/interview-question/383669/
Given a matrix with r rows and c columns, find the maximum score of a path starting at [0, 0] and ending at [r-1, c-1]. The score of a path is the minimum value in that path. For example, the score of the path 8 → 4 → 5 → 9 is 4.

Don't include the first or final entry. You can only move either down or right at any point in time.

Example 1:

Input:
[[5, 1],
 [4, 5]]

Output: 4
Explanation:
Possible paths:
5 → 1 → 5 => min value is 1
5 → 4 → 5 => min value is 4
Return the max value among minimum values => max(4, 1) = 4.

Example 2:

Input:
[[1, 2, 3]
 [4, 5, 1]]

Output: 4
Explanation:
Possible paths:
1-> 2 -> 3 -> 1
1-> 2 -> 5 -> 1
1-> 4 -> 5 -> 1
So min of all the paths = [2, 2, 4]. Note that we don't include the first and final entry.
Return the max of that, so 4.

 */
public class MaxOfMinAltitudes {
    public int findMaxScore(int[][]grid){
        if(grid == null || grid.length == 0)
            return -1;
        int r = grid.length;
        int c = grid[0].length;

        int[][] gp = new int[r][c];
        gp[0][0] = Integer.MIN_VALUE;
        gp[r-1][c-1] = Integer.MIN_VALUE;
        //Set First Row
        for(int i=1;i<c;i++){
            gp[0][i] = Math.max(gp[0][i-1],grid[0][i]);
        }

        //Set First Col
        for(int i=1;i<r;i++){
            gp[i][0] = Math.max(gp[i-1][0],grid[i][0]);
        }

        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                gp[i][j] = Math.max(gp[i][j-1],gp[i-1][j]);
            }
        }

        return gp[r-1][c-1];
    }

    public static void main(String[] args) {
        MaxOfMinAltitudes ms = new MaxOfMinAltitudes();
        System.out.println(ms.findMaxScore(new int[][]{{5, 1}, {4, 5}}));
        System.out.println(ms.findMaxScore(new int[][]{{1, 2, 3}, {4, 5, 1}}));

    }
}

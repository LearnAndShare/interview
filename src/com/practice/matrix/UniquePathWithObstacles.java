package com.practice.matrix;
/*
https://leetcode.com/problems/unique-paths-ii/
 */
public class UniquePathWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0][0] == 1)
            return 0;
        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;
        int [][] tmp = new int[r][c];
        r--;
        c--;
        tmp[0][0] =  1;
        for(int i=1;i<=c;i++){
            if(obstacleGrid[0][i] == 1){
                tmp[0][i] = 0;
            } else {
                tmp[0][i] = tmp[0][i-1];
            }
        }

        for(int i=1;i<=r;i++){
            if(obstacleGrid[i][0] == 1){
                tmp[i][0] = 0;
            } else {
                tmp[i][0] = tmp[i-1][0];
            }
        }

        for(int i=1;i<=r;i++)
            for(int j=1;j<=c;j++)
                if(obstacleGrid[i][j] == 1){
                    tmp[i][j] = 0;
                }else {
                    tmp[i][j] = tmp[i][j - 1] + tmp[i - 1][j];
                }

        return tmp[r][c];
    }

    public static void main(String[] args) {
        UniquePathWithObstacles o = new UniquePathWithObstacles();
        int[][]g = new int[][]{
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        /*int[][]g = new int[][]{
                {0,0},
                {1,1},
                {0,0}
        };*/
        System.out.println( o.uniquePathsWithObstacles(g));
    }
}

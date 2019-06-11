package com.practice.matrix;
/*
https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 */

public class LongestPathMatrix {

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;

        int r = matrix.length;
        int c = matrix[0].length;
        int[][] distance = new int[r][c];
        int max = 1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int ret = dfs(matrix,distance,i,j,Integer.MIN_VALUE);
                if(ret>max)
                    max = ret;
            }

        }
        return max;
    }

    public int longestIncreasingPathRec(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;

        int[] m = new int[1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                longestIncreasingPath(matrix,i,j,m,1);

            }

        }
        return m[0];
    }

    public void longestIncreasingPath(int[][] m,int i,int j,int[]max,int level){
        if(i<0||i>=m.length||j<0||j>=m[0].length)
            return;
        max[0] = Math.max(max[0],level);
        if(i-1>=0 ) {
            //top val
            int top = m[i - 1][j];
            if (m[i][j] < top)
                longestIncreasingPath(m, i - 1, j, max,level + 1);
        }
        if(i+1 < m.length) {
            //Bottom
            int bottom = m[i + 1][j];
            if (m[i][j] < bottom)
                longestIncreasingPath(m, i + 1, j, max,level + 1);
        }
        if(j-1>=0 ) {
            //left
            int left = m[i][j - 1];
            if (m[i][j] < left)
                longestIncreasingPath(m, i, j - 1, max,level + 1);
        }
        if(j+1<m[0].length) {
            //Right
            int right = m[i][j + 1];
            if (m[i][j] < right)
                longestIncreasingPath(m, i, j + 1, max,level + 1);
        }
    }

    public int dfs(int[][]m,int[][] distance,int i,int j,int prev){
        if(i<0||i>=m.length||j<0||j>=m[0].length || m[i][j]<=prev)
            return 0;
        if(distance[i][j] != 0)
            return distance[i][j];

        int v1 = dfs(m,distance,i-1,j,m[i][j]);
        int v2 = dfs(m,distance,i,j-1,m[i][j]);
        int v3 = dfs(m,distance,i+1,j,m[i][j]);
        int v4 = dfs(m,distance,i,j+1,m[i][j]);
        distance[i][j] = 1+ Math.max(v1,Math.max(v2,Math.max(v3,v4)));
        return distance[i][j];

    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2},{1,1}};
        int[][] arr1 = new int[][]{{9,9,4},
                {6,6,8},
                {2,1,1}};
        LongestPathMatrix m = new LongestPathMatrix();
        m.longestIncreasingPath(arr1);
    }
}

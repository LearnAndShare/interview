package com.practice.matrix;
/*
https://leetcode.com/problems/unique-paths/
 */
public class UniquePath {
    public int uniquePaths(int m, int n) {
        int[][]tmp = new int[m][n];
        tmp[0][0] = 1;
        for(int i=0;i<n;i++)
            tmp[0][i]  =1;
        for(int i=0;i<m;i++)
            tmp[i][0]  =1;
        for(int i=1;i<m;i++)
            for(int j=1;j<n;j++)
                tmp[i][j] = tmp[i][j-1]+tmp[i-1][j];
        return tmp[m-1][n-1];
    }

    public static void main(String[] args) {
        UniquePath up = new UniquePath();
        System.out.println(up.uniquePaths(3,2));
    }
}

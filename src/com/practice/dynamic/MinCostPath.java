package com.practice.dynamic;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
 */
public class MinCostPath {
    //You can traverse only rigth and down
    public int minCost(int [][]cost,int m,int n){
        int temp[][] = new int[m][n];
        int sum = 0;
        for(int i=0;i<m;i++){
            temp[0][i] = sum + temp[0][i];
        }

        sum = 0;
        for(int i=0;i<m;i++){
            temp[i][0] = sum + temp[i][0];
        }

        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                temp[i][j] += Math.min(temp[i][j-1],temp[i-1][j]);
            }

        return temp[m-1][n-1];
    }
}

package com.practice.dynamic;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
 */
public class MinCostPath {
    //You can traverse only rigth and down
    public int minCost(int [][]cost,int row,int col){
        int temp[][] = new int[row+1][col+1];
        temp[0][0] = cost[0][0];
        for(int i=1;i<=row;i++){
            temp[i][0] =  cost[i][0]+temp[i-1][0];
        }


        for(int i=1;i<=col;i++){
            temp[0][i] = cost[0][i]+ temp[0][i-1];
        }

        for(int i=1;i<=row;i++)
            for(int j=1;j<=col;j++){
                temp[i][j] = cost[i][j]+Math.min(Math.min(temp[i-1][j-1],temp[i-1][j]),temp[i][j-1]);
            }

        return temp[row][col];
    }

    public static void main(String args[])
    {
        int cost[][]= {{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};
        MinCostPath mc = new MinCostPath();
        System.out.println(mc.minCost(cost,2,2));
    }
}

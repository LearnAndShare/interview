package com.practice.dynamic;

public class PaintHouse {
    /*
    There are a row of n houses,
    each house can be painted with one of the three colors: red, green or blue.
    The cost of painting each house with a certain color is different. You have to paint all the houses
    such that no two adjacent houses have the same color.
    The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
    For example, costs[0][0] is the cost of painting house 0 with color red;
    costs[1][2] is the cost of painting house 1 with color green, and so on...
    Find the minimum cost to paint all houses.
    Input: [[17,2,17],[16,16,5],[14,3,19]]
    Output:10
    Explanation:Paint House 0 in blue,House 1 in green and house 3 in blue
     */

    public int minCost(int[][] cost){
        int[][] color = new int[3][cost.length];
        for(int i=0;i<cost.length;i++){
            if(i==0){
                color[0][i]= cost[i][0];
                color[1][i]= cost[i][1];
                color[2][i]= cost[i][2];
            } else {
                color[0][i] = cost[i][0]+Math.min(color[1][i-1],color[2][i-1]);
                color[1][i] = cost[i][1]+Math.min(color[0][i-1],color[2][i-1]);
                color[2][i] = cost[i][2]+Math.min(color[0][i-1],color[1][i-1]);
            }
        }

        int len = cost.length-1;
        int res = Math.min(color[0][len],Math.min(color[1][len],color[2][len]));
        return res;
    }

    public int minCostNoExtraSpace(int[][] cost){
        if(cost == null || cost.length == 0)
            return 0;
        for(int i=1;i<cost.length;i++){
            cost[i][0] = cost[i][0] + Math.min(cost[i-1][1],cost[i-1][2]);
            cost[i][1] = cost[i][1] + Math.min(cost[i-1][0],cost[i-1][2]);
            cost[i][2] = cost[i][2] + Math.min(cost[i-1][0],cost[i-1][1]);
        }
        int len = cost.length-1;
        int res = Math.min(cost[len][0],Math.min(cost[len][1],cost[len][2]));
        return res;
    }

    public static void main(String[] args) {
        PaintHouse p = new PaintHouse();
        int[][] c = new int[][]{{17,2,17},{16,16,5},{14,3,19}};
        System.out.println("Min cost to paint house::"+p.minCost(c));
        System.out.println("Min cost to paint house without extra space::"+p.minCostNoExtraSpace(c));
    }
}

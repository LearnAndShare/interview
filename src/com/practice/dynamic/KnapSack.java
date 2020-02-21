package com.practice.dynamic;

/*
https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/Knapsack01.java
* 0/1 Knapsack Problem - Given items of certain weights/values and maximum allowed weight
 * how to pick items to pick items from this set to maximize sum of value of items such that
 * sum of weights is less than or equal to maximum allowed weight.
 *
 * Time complexity - O(W*total items)
 */
public class KnapSack {
    public int bottomUpDP(int val[], int wt[], int totalWeight){
        int[][] k = new int[val.length+1][totalWeight+1];
        for(int j=0;j<k.length;j++){
            k[j][0] = 0;
        }
        for(int i=0;i<k[0].length;i++){
            k[0][i] = 0;
        }

        for(int i=0;i<=val.length;i++){
            for(int j=0;j<=totalWeight;j++){
                if(i==0||j==0)continue;
                //System.out.println(i);
                if(wt[i-1]<=j){
                    int itemIncluded = val[i-1]+k[i-1][j-wt[i-1]];
                    int itemNotIncluded = k[i-1][j];
                    k[i][j] = Math.max(itemIncluded,itemNotIncluded);
                } else {
                    k[i][j]=k[i-1][j];
                }
            }
        }
        return k[val.length][totalWeight];
    }

    public static void main(String[] args) {
        int val[] = {1,4,5,7};
        int wt[] = {1,3,4,5};
        KnapSack ks = new KnapSack();
        System.out.println(ks.bottomUpDP(val, wt, 7));
    }
}

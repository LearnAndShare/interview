package com.practice.stock;

public class BuySellStockIV {
    public int maxProfit(int k, int[] prices) {
        if(k == 0 || prices == null || prices.length == 0)
            return 0;
        //If we donot add below check then OOM error for larger inputs
        //When k is more than inputs length teh problem reduced to having maximum profit with as many transactions
        if (k >= prices.length) {
            return allTimeProfit(prices);
        }
        int [][]t = new int[k+1][prices.length];
        for (int i=1;i<t.length;i++){
            int maxDiff = -prices[0];
            for(int j=1;j<t[0].length;j++){
                t[i][j] = Math.max(t[i][j-1],prices[j]+maxDiff);
                maxDiff = Math.max(maxDiff,t[i-1][j]-prices[j]);
            }
        }
        return t[k][prices.length-1];
    }

    public int allTimeProfit(int prices[]){
        if(prices == null || prices.length <=1)
            return 0;
        int profit = 0;
        for (int i=0;i<prices.length-1;i++){
            if(prices[i+1]>prices[i])
                profit += (prices[i+1] - prices[i]) ;
        }
        return profit;
    }

    public static void main(String[] args) {
        BuySellStockIV bs = new BuySellStockIV();
        System.out.println("{2,4,1} :: "+bs.maxProfit(2, new int[]{2, 4, 1}));
        System.out.println("{2,4,1} :: "+bs.maxProfit(1, new int[]{2,  1}));
    }
}

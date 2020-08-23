package com.practice.minswaps;

import java.util.Arrays;

/*
https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together/
Given a binary array data, return the minimum number of swaps required to group all 1’s present in the array together in any place in the array.

Example 1:
Input: [1,0,1,0,1]
Output: 1
Explanation:
There are 3 ways to group all 1's together:
[1,1,1,0,0] using 1 swap.
[0,1,1,1,0] using 2 swaps.
[0,0,1,1,1] using 1 swap.
The minimum is 1.
Example 2:
Input: [0,0,0,1,0]
Output: 0
Explanation:
Since there is only one 1 in the array, no swaps needed.
Example 3:
Input: [1,0,1,0,1,0,0,1,1,0,1]
Output: 3
Explanation:
One possible solution that uses 3 swaps is [0,0,0,0,0,1,1,1,1,1,1].
 */
public class MinSwapsToGroupAllOnes {
    public int minSwaps(int[] data) {

        int numOfOnes = Arrays.stream(data).filter(value -> value ==1).sum();

        if(numOfOnes == data.length || numOfOnes == 0)
            return 0;

        int minSwaps = Integer.MAX_VALUE;
        int [] dp = new int[data.length];
        if(data[0] == 1){
            dp[0] = 1;
        }
        for(int i=1;i<data.length;i++){
            dp[i] = dp[i-1] + (data[i] ==1 ?1:0);
        }
        int windowSize = numOfOnes;
        for(int i=numOfOnes-1;i<data.length;i++){
            if(i == numOfOnes-1){
                numOfOnes = dp[i];
            } else {
                numOfOnes = dp[i] - dp[i-windowSize];
            }
            minSwaps = Math.min(minSwaps,windowSize-numOfOnes);
        }
        return minSwaps;
    }

    public int minSwapsSlidingWindow(int[] data) {
            int numOfOnes = Arrays.stream(data).filter(value -> value ==1).sum();
            if(numOfOnes == data.length || numOfOnes == 0)
                return 0;
            int k = numOfOnes;
            int windowOnes = 0;
            int windowSize = numOfOnes;
            int swaps = Integer.MAX_VALUE;
            for(int l=0,r=0;r<data.length;r++){
                windowOnes += data[r];
                if(r-l == windowSize-1){
                    swaps = Math.min(swaps,windowSize-windowOnes);
                    windowOnes -=data[l++];
                }
            }
            return swaps;


    }

    public static void main(String[] args) {
        MinSwapsToGroupAllOnes ms = new MinSwapsToGroupAllOnes();
        System.out.println(ms.minSwaps(new int[]{1, 0, 1, 0, 1}));
        System.out.println(ms.minSwaps(new int[]{0, 0, 0, 1, 0}));
        System.out.println(ms.minSwaps(new int[]{1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1}));
        System.out.println(ms.minSwaps(new int[]{0,0,0,0,0,0,0,0,0,0,0,0}));
        System.out.println("=======================");
        System.out.println(ms.minSwapsSlidingWindow(new int[]{1, 0, 1, 0, 1}));
        System.out.println(ms.minSwapsSlidingWindow(new int[]{0, 0, 0, 1, 0}));
        System.out.println(ms.minSwapsSlidingWindow(new int[]{1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1}));
        System.out.println(ms.minSwapsSlidingWindow(new int[]{0,0,0,0,0,0,0,0,0,0,0,0}));
    }
}

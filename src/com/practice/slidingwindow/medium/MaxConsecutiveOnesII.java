package com.practice.slidingwindow.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://massivealgorithms.blogspot.com/2017/01/leetcode-487-max-consecutive-ones-ii.html
Problem:

Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.

Example 1:

Input: [1,0,1,1,0]
Output: 4
Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
    After flipping, the maximum number of consecutive 1s is 4.
Note:
    The input array will only contain 0 and 1.
    The length of input array is a positive integer and will not exceed 10,000

Follow up: What if the input numbers come in one by one as an infinite stream?
In other words, you can't store all numbers coming from the stream as it's too large to hold in memory.
Could you solve it efficiently?
 */
public class MaxConsecutiveOnesII {
    public int findMaxConsecutiveOnes(int[] nums) {
        int l=0,r=0,k=1;
        int numZero = 0;
        int maxOnes = 0;
        while (r<nums.length){
            if(nums[r] == 0)
                ++numZero;
            while(numZero>k){
                if(nums[l++] == 0) {
                    --numZero;
                }
            }

            maxOnes=Math.max(maxOnes,r-l+1);
            r++;
        }
        return maxOnes;
    }

    public List<Integer> maxone1(List<Integer> A, int B) {
        int l=0,r=0,max=0;
        int numZero = 0;
        List<Integer> li = new ArrayList<>();
        List<int[]> list = new ArrayList();
        while(r<=A.size()-1){
            if(A.get(r)==0)
                numZero++;
            while(numZero>B){
                if(A.get(l++) == 0){
                    --numZero;
                }

            }



            if(max<r-l+1){
                max = r-l+1;
                list.clear();
                list.add(new int[]{l,r});
            }
            r++;
        }
        for (int[] ints : list) {
            int s = ints[0];
            int e = ints[1];
            for (int i=s;i<=e;i++){
                li.add(i);
            }
        }
        return li;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnesII ms = new MaxConsecutiveOnesII();
        //System.out.println(ms.findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0}));
//        System.out.println(ms.maxone1(Arrays.asList(new Integer[]{1,0,1,1,0}),1));
        System.out.println(ms.maxone1(Arrays.asList(new Integer[]{1,1,0,1,1,0,0,1,1,1 }),1));
        System.out.println(ms.maxone1(Arrays.asList(new Integer[]{0, 1, 1, 1 }),0));
    }
}

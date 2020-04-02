package com.practice.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/advantage-shuffle/
Given two arrays A and B of equal size, the advantage of A with respect to B is the number of indices i for which A[i] > B[i].

Return any permutation of A that maximizes its advantage with respect to B.



Example 1:

Input: A = [2,7,11,15], B = [1,10,4,11]
Output: [2,11,7,15]

Example 2:

Input: A = [12,24,8,32], B = [13,25,32,11]
Output: [24,32,8,12]


 */
public class AdvantageShuffle {
    public int[] advantageCount(int[] A, int[] B) {
        if(A == null && B == null)
            return null;
        if(A== null)
            return B;
        if(B== null)
            return A;
        Arrays.sort(A);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(int i=0;i<B.length;i++){
            pq.add(new int[]{B[i],i});
        }
        int [] res = new int[A.length];
        int hi = A.length-1;
        int lo = 0;
        while(!pq.isEmpty()){
            int [] cur = pq.poll();
            if(A[hi]>cur[0]){
                res[cur[1]] = A[hi--];
            } else {
                res[cur[1]] = A[lo++];
            }
        }
        return res;
    }
}


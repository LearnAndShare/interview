package com.practice.heap;
/*
https://www.techiedelight.com/sort-k-sorted-array/
Given a k sorted array that is almost sorted such that each of the N elements may be misplaced by no more tha K positions
from the correct sorted order.Find a space and time efficient algo to sort the array

For example:
arrr=[1,4,5,2,3,7,8,6,10,9], k=2
o/p: [1,2,3,4,5,6,7,8,9,10]

 */

import java.util.PriorityQueue;

public class SortKSortedArray {
    public void sortKSortedArray(int[] arr,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<=k;i++){
            pq.add(arr[i]);
        }
        int idx = 0;
        for(int i=k+1;i<arr.length;i++){
            arr[idx++] = pq.poll();
            pq.add(arr[i]);
        }
        while(!pq.isEmpty()){
           arr[idx++] =pq.poll();
        }
    }

    public static void main(String[] args) {
        SortKSortedArray s = new SortKSortedArray();
        int[] arr = new int[]{1,4,5,2,3,7,8,6,10,9};
        s.sortKSortedArray(arr,2);
        for (int i : arr) {
            System.out.print(i);
        }
    }
}

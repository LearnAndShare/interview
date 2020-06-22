package com.practice.heap;

import java.util.*;

/*
https://leetcode.com/problems/top-k-frequent-elements/
Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:

Input: nums = [1], k = 1
Output: [1]


 */
public class TopKFrequentElements {

    public int[] topKFrequentQuickSelect(int[] nums, int k){
        int[] unique;
        Map<Integer, Integer> count;
        count = new HashMap();
        for (int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        unique = new int[count.size()];
        int idx = 0;
        for (Integer e : count.keySet()) {
            unique[idx++]=e;
        }
        int n= count.size();
        //Kth top frequent elments is (n-k)th elements
        // Do a partial sort: from less frequent to the most frequent, till
        // (n - k)th less frequent element takes its place (n - k) in a sorted array.
        // All element on the left are less frequent.
        // All the elements on the right are more frequent.
        quickSelect(count,unique,0,n-1,n-k);
        return Arrays.copyOfRange(unique,n-k,n);
    }

    private void quickSelect(Map<Integer, Integer> countMap,
                             int[] unique, int left, int right, int kSmallest) {
        if(left == right)
            return;


        while(left <= right){
            int chosenPivotIdx = (left+right)/2;
            int finalIndexOfChosenPivot = partition(countMap,unique,left,right,chosenPivotIdx);
            if(finalIndexOfChosenPivot == kSmallest){
                return;
            } else if(finalIndexOfChosenPivot > kSmallest){
                right = finalIndexOfChosenPivot-1;

            } else {
                left = finalIndexOfChosenPivot+1;
            }

        }
    }

    private int partition(Map<Integer, Integer> countMap, int[] unique, int left, int right, int chosenPivotIdx) {
        int pivotFreq = countMap.get(unique[chosenPivotIdx]);
        swap(unique,chosenPivotIdx,right);
        /*
          Remember how partitioning works? We need to keep track of where
          we last placed an item in the section of items "less than the
          pivot"

          We keep track of the tail index of this section. We will
          need this later
        */
        int lesserItemsTailIndex = left;
        /*
          Iterate from the left bound to 1 index right before the right bound
          (where the choosen pivot value is now sitting in saftey)
        */
        for (int i = left; i < right; i++) {
            if(countMap.get(unique[i])<pivotFreq){
                swap(unique,i,lesserItemsTailIndex);
                lesserItemsTailIndex++;
            }
        }

        swap(unique,lesserItemsTailIndex,right);
        return lesserItemsTailIndex;

    }

    public void swap(int[]unique,int a, int b) {
        int tmp = unique[a];
        unique[a] = unique[b];
        unique[b] = tmp;
    }

    public int[] topKFrequentPriorityQueue(int[] nums, int k) {

            int[] e = new int[k];
            Map<Integer,Integer> intCount=new HashMap<>();
            for (int num : nums) {
                int count = intCount.getOrDefault(num,0);
                intCount.put(num,++count);
            }
           PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparing(intCount::get));

            for (Integer n : intCount.keySet()) {
                pq.add(n);
                if(pq.size()>k)
                    pq.poll();
            }
            int idx =0;
            while(!pq.isEmpty()){
                e[idx++]=pq.poll();
            }
            return e;
    }



    public static void main(String[] args) {
        TopKFrequentElements t = new TopKFrequentElements();
        for (int i : t.topKFrequentPriorityQueue(new int[]{1, 1, 1, 2, 2, 3}, 2)) {
            System.out.print(i + ",");
        }

        System.out.println("\n==============Using quick select=====================");
        for (int i : t.topKFrequentQuickSelect(new int[]{1, 1, 1, 2, 2, 3}, 2)) {
            System.out.print(i +",");
        }


        System.out.println("\n ==============DATA Set 2================");
        for (int i : t.topKFrequentPriorityQueue(new int[]{2,3,4,1,4,0,4,-1,-2,-1}, 2)) {
            System.out.print(i + ",");
        }

        System.out.println("\n==============Using quick select=====================");
        for (int i : t.topKFrequentQuickSelect(new int[]{3,0,1,0}, 1)) {
            System.out.print(i +",");
        }

    }
}

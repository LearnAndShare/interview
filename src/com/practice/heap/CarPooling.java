package com.practice.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
https://leetcode.com/problems/car-pooling/
 */
public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {

        Arrays.sort(trips, Comparator.comparingInt(o->o[1]));
        Queue<int[]> pq = new PriorityQueue<int[]>(Comparator.comparingInt(o -> o[2]));
        for(int i=0;i<trips.length;i++){
            while(!pq.isEmpty() && trips[i][1]>=pq.peek()[2]){
                capacity += pq.peek()[0];
                pq.poll();
            }

            capacity -= trips[i][0];
            pq.offer(trips[i]);
            if(capacity <0)
                return false;
        }
        return true;
    }


}

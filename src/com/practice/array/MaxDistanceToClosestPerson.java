package com.practice.array;

import java.util.ArrayList;
import java.util.List;

public class MaxDistanceToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        //Input: [1,0,0,0,1,0,1]
        //Output: 2

        List<Integer> l =new ArrayList<>();
        for(int i=0;i<seats.length;i++){
            if(seats[i] == 1){
                l.add(i);
            }
        }

        int max = -1;
        for(int i=0;i<seats.length;i++){
            int min = Integer.MAX_VALUE;
            if(seats[i] != 1){
                for(int j=0;j<l.size();j++){
                 min = Math.min(min,Math.abs(i-l.get(j)));
                }
                max = Math.max(max,min);
            }

        }
        return max;
    }

    public int maxDistToClosest2(int[] seats) {
        int l = -1;
        int r = 0;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < seats.length; i++) {
            if(seats[i] == 1){
                l = i;
            } else {

                while(r<seats.length && seats[r] == 0||r<i)
                    r++;
                int left = l==-1?seats.length:i-l;
                int right = r == seats.length?seats.length:r-i;
                ans = Math.max(ans,Math.min(right,left));

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxDistanceToClosestPerson ms = new MaxDistanceToClosestPerson();
        System.out.println(ms.maxDistToClosest2(new int[]{1, 0, 0, 0, 1, 0, 1}));
        System.out.println(ms.maxDistToClosest2(new int[]{1, 0, 0, 0}));
    }
}

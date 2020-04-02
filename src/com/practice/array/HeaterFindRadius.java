package com.practice.array;

import java.util.Arrays;

/*
https://leetcode.com/problems/heaters/

Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.

Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.

So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.


Example 1:

Input: [1,2,3],[2]
Output: 1
Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.



Example 2:

Input: [1,2,3,4],[1,4]
Output: 1
Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.

 */
public class HeaterFindRadius {
    public int findRadius(int[] houses, int[] heaters) {
        if(houses == null || houses.length == 0 || heaters == null || heaters.length == 0)
            return 0;
        Arrays.sort(heaters);
        int r = Integer.MIN_VALUE;
        for (int i = 0; i < houses.length; i++) {
            r = Math.max(r,binarySearch(heaters,houses[i]));
        }
        return r;
    }

    public int binarySearch(int[] heaters,int houseNumber){
        int low = 0;
        int high=heaters.length-1;

        int minR = Integer.MAX_VALUE;
        while(low<=high){
            int mid = (low + high)/2;
            if(houseNumber == heaters[mid]){
                return 0;
            }
            minR = Math.min(minR,Math.abs(heaters[mid]-houseNumber));
            if(houseNumber>heaters[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return minR;

    }

    public static void main(String[] args) {
        HeaterFindRadius h = new HeaterFindRadius();
        System.out.println(h.findRadius(new int[]{1, 2, 3}, new int[]{1, 2}));
    }
}

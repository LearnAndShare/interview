package com.practice.array;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/decompress-run-length-encoded-list/
Example 1:

Input: nums = [1,2,3,4]
Output: [2,4,4,4]
Explanation: The first pair [1,2] means we have freq = 1 and val = 2 so we generate the array [2].
The second pair [3,4] means we have freq = 3 and val = 4 so we generate [4,4,4].
At the end the concatenation [2] + [4,4,4] is [2,4,4,4].

Example 2:

Input: nums = [1,1,2,3]
Output: [1,3,3]

 */
public class DecompressRLE {
    public int[] decompressRLElist(int[] nums) {

        List<Integer> l = new ArrayList<>();
        int idx = 0;
        for(int i=0;i<=nums.length;i=i+2){
            for(int j=0;j<nums[i];j++){
                l.add(nums[i+1]);
            }
        }
        int[] rle = new int[l.size()];
        for (Integer i : l) {
            rle[idx++] = i;
        }

        return rle;
    }

    public static void main(String[] args) {
        DecompressRLE d = new DecompressRLE();
        for (int i : d.decompressRLElist(new int[]{1,2,3,4})) {
            System.out.print(i);
        }
    }
}



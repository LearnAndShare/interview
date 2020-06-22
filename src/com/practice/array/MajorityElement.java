package com.practice.array;
/*
https://leetcode.com/problems/majority-element/
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int ct  =0;
        Integer curr = null;
        for (int num : nums) {
            if(ct ==0){
                curr = num;
            }
            ct += curr==num?1:-1;
        }

        return curr;
    }
}

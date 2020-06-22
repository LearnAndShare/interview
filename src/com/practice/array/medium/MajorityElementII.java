package com.practice.array.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
https://leetcode.com/problems/majority-element-ii/
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.

Example 1:

Input: [3,2,3]
Output: [3]

Example 2:

Input: [1,1,1,3,3,2,2,2]
Output: [1,2]


 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        if(nums == null || nums.length ==0)
            Collections.emptyList();
        List<Integer> list = new ArrayList<>();
        Integer curr = null;
        int maj = nums.length/3;
        int count= 0;
        for (int num : nums) {
            if(count == 0){
                curr = num;
            }
            count += curr==num?1:-1;
            if(count >= maj){
                list.add(num);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        MajorityElementII mj  = new MajorityElementII();
        mj.majorityElement(new int[]{3,2,3}).forEach(System.out::print);
        mj.majorityElement(new int[]{1,1,1,3,3,2,2,2}).forEach(e->System.out.print(e+","));
    }
}

package com.practice.slidingwindow.medium;

/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
For example,
Given input array A = [1,1,1,2],Your function should return length = 3, and A is now [1,1,2]
Given nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.

It doesn't matter what you leave beyond the returned length.
 */
public class RemoveDuplicatesSortedArrayII {
    public int removeDuplicates(int[] nums) {
       int j=1;
        int count=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1]){
                ++count;
            } else {
                count=1;
            }

            if(count<=2){
                nums[j++] = nums[i];
            }
        }
        return j;

    }

}

package com.practice.array.medium;
/*
https://leetcode.com/problems/subarray-product-less-than-k/

https://leetcode.com/problems/subarray-product-less-than-k/discuss/108861/JavaC%2B%2B-Clean-Code-with-Explanation

1.e idea is always keep an max-product-window less than K;
2.Every time shift window by adding a new number on the right(j),
if the product is greater than k, then try to reduce numbers on the left(i), until the subarray product fit less than k again,
(subarray could be empty);
Each step introduces x new subarrays, where x is the size of the current window (j + 1 - i);
example:
for window (5, 2), when 6 is introduced, it add 3 new subarray: (5, (2, (6)))

Example 1:

Input: nums = [10, 5, 2, 6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.

 */
public class SubArrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        int p = 1;
        int cnt = 0;
        for (int i = 0, j = 0; j < nums.length; j++) {
            p *= nums[j];
            while (p >= k && i <= j) {
                p /= nums[i];
                i++;
            }
            cnt += j - i + 1;
        }
        return cnt;
    }

    public static void main(String[] args) {

    }
}

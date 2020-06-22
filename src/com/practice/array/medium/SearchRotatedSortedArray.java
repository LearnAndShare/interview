package com.practice.array.medium;
/*
https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0 )
            return -1;
        int low= 0;
        int high = nums.length - 1;

        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid] == target){
                return mid;
            } else {
                    if(nums[mid] < nums[high]){// right half sorted
                        if(target > nums[mid] && target <= nums[high]){// target within right half
                            low = mid + 1;
                        } else {
                            high = mid -1;
                        }
                    } else{
                        // Left half sorted
                        if(target < nums[mid] && target >= nums[low]){// target within left half
                            high = mid -1;
                        } else {
                            low = mid + 1;
                        }
                    }



            }

        }
        return -1;
    }

    private boolean isInLeftSide(int low, int high, int mid, int target){
        return (low <= mid && isBetweenInclusive(target,low,mid)) || (mid <= high && !isBetweenInclusive(target,mid,high));
    }

    private boolean isBetweenInclusive(int target, int low, int high){
        return low <=target && high >= target;
    }

    public static void main(String[] args) {
        SearchRotatedSortedArray s = new SearchRotatedSortedArray();
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(s.search(new int[]{4, 5}, 4));
        System.out.println(s.search(new int[]{1, 3}, 3));
    }
}

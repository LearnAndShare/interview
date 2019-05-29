package com.practice;

public class ContinuousSubArray {
/*
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5


Input: [2, 6, 4, 8, 10, 12, 15]
Output: 5
 */
public static void main(String[] args) {
    /*int [] nums = new int[]{2,4,6,8};
    System.out.println(findUnsortedSubarray(nums));*/


    int [] nums = new int[]{2, 6, 4, 8, 10, 9, 15};
    System.out.println(findUnsortedSubarray(nums));


    nums = new int[]{2, 6, 4, 8, 10, 12, 15};
    System.out.println(findUnsortedSubarray(nums));

    nums = new int[]{2, 1,3};
    System.out.println(findUnsortedSubarray(nums));


    nums = new int[]{1,2,3,3,3};
    System.out.println(findUnsortedSubarray(nums));

    nums =new int[]{1,3,2,3,3};
    System.out.println(findUnsortedSubarray(nums));


}

/*public void asd(){

    {

        int count = 0;
        ListNode tmp = head;
        while(tmp != null) {
            tmp = tmp.next;
            count ++;
        }
        ListNode curr1 = head;
        ListNode prev = null;
        for(int i=0; i<(count+1)/2 ; i++) {
            tmp = curr1.next;
            curr1.next = prev;
            prev = curr1;
            curr1 = tmp;
        }
        ListNode curr2 = count % 2 == 0 ? prev : prev.next;

        while(curr1 != null) {
            if(curr1.val == curr2.val) {
                curr1 = curr1.next;
                curr2 = curr2.next;
            }
            else
                return false;
        }
        return true;
    }
}*/
    public static  int findUnsortedSubarray(int[] nums) {//{2, 6, 4, 8, 10, 9, 15};
        int idx = 0;
        boolean found = false;
        for (int i=0;i< nums.length-1;i++) {
            if(!(nums[i]<=nums[i+1])){
                found = true;
                idx =i;
                break;
            }
        }
        int retIdx = 0;

        if(found) {

            for (int j = idx + 1; j < nums.length - 1; j++) {
                if (! (nums[j] < nums[j + 1])) {
                    retIdx = j+1;

                }
            }

        }
        int idxArray = 0;
        if(found){
            idxArray = Math.abs(retIdx - idx) + 1;
            if(nums.length == 2){
                ++idxArray;
            }
        }


        return idxArray;
    }
}

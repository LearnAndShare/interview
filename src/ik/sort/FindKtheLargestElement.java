package ik.sort;

import java.util.Random;

public class FindKtheLargestElement {

    public int findKthLargest(int[] nums, int k) {

        return findKthLargestHelper(nums,0,nums.length-1,nums.length -k);

    }

    private int findKthLargestHelper(int[] nums, int start,int end,int kIdx) {
        int pIdx = partition(nums,start,end);
        if(pIdx == kIdx){
            return nums[kIdx];
        } else if(pIdx < kIdx ){
            return findKthLargestHelper(nums,pIdx+1,end,kIdx);
        } else {
            return findKthLargestHelper(nums,start,pIdx-1,kIdx);
        }

    }

    private int partition(int[] nums, int start,int end) {
        Random r = new Random();
        int rIdx = r.nextInt(end-start+1)+start;
        swap(nums,start,rIdx);
        int pivotVal = nums[start];
        int smaller = start;
        for(int larger=smaller+1;larger<=end;larger++){
            if(nums[larger]<pivotVal){
                smaller++;
                swap(nums,larger,smaller);
            }
        }
       swap(nums,smaller,start);
        return smaller;
    }

    public void swap(int[] arr, int pos1,int pos2){
        if(pos1 != pos2) {
            int temp = arr[pos1];
            arr[pos1] = arr[pos2];
            arr[pos2] = temp;
        }
    }

    public static void main(String[] args) {
        FindKtheLargestElement fk = new FindKtheLargestElement();
        System.out.println(fk.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
//        System.out.println(fk.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}

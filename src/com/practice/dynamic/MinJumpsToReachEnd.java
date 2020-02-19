package com.practice.dynamic;

public class MinJumpsToReachEnd {

    public int minJump(int arr[],int result[]){

        int []jump = new int[arr.length];
        jump[0] = 0;
        for(int i=1; i < arr.length ; i++){
            jump[i] = Integer.MAX_VALUE-1;
        }
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++){

                if((j+arr[j])>=i){
                    jump[i] = Math.min(jump[j]+1,jump[i]);
                }
            }
        }

        return jump[jump.length-1];
    }

    public int minJumpDP(int[] nums){
        if (nums == null || nums.length < 2) return 0;
        int maxStep = nums[0], lastMax = nums[0], minVal = 1;
        for (int i = 1; i < nums.length; i++) {
            maxStep = Math.max(maxStep, nums[i] + i);
            if (i == lastMax && i != nums.length - 1) {
                lastMax = maxStep;
                minVal += 1;
            }
        }
        return minVal;
    }

    public static void main(String[] args) {
        MinJumpsToReachEnd m = new MinJumpsToReachEnd();
        System.out.println(m.minJumpDP(new int[]{2,3,1,1,4}));
    }

}

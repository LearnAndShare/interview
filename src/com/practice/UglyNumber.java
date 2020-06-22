package com.practice;
/*
https://leetcode.com/problems/ugly-number-ii/
Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 */
public class UglyNumber {
    public int nthUglyNumber(int n) {
        if(n<=0)
            return 0;
        if(n ==1 )
            return 1;
        int[] n1 = new int[n];
        n1[0] = 1;
        int i2=0,i3=0,i5=0;
        int i2_next = 2;
        int i3_next = 3;
        int i5_next = 5;
        for(int i=1;i<n;i++){
            int num = Math.min(i2_next,Math.min(i3_next,i5_next));
            n1[i] = num;
            System.out.println("Next ugly num::"+num);
            if(num == i2_next){
                i2++;
                i2_next = n1[i2]*2;
            }
            if(num == i3_next){
                i3++;
                i3_next = n1[i3]*3;
            }
            if(num == i5_next){
                i5++;
                i5_next =n1[i5]*5;
            }
        }
        return n1[n-1];
    }

    public static void main(String[] args) {
        UglyNumber un = new UglyNumber();
        System.out.println(un.nthUglyNumber(1));
        System.out.println(un.nthUglyNumber(10));
    }
}

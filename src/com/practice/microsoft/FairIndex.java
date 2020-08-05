package com.practice.microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FairIndex {
    public int getFairIndex(int[] a, int[] b){
        int sumA = Arrays.stream(a).sum();
        int sumB = Arrays.stream(b).sum();
        int idx = 0;
        int lSumA =0;
        int lSumB = 0;
        List<Integer> fairIndices = new ArrayList<>();
        int fairIdxCount = 0;
        for(int i=0;i<a.length;i++){
            lSumA += a[i];
            lSumB += b[i];
            sumA -= a[i];
            sumB -= b[i];
            if(lSumA == lSumB && sumA == sumB && lSumA == sumA && i!=a.length-1) {
                ++fairIdxCount;
                fairIndices.add(i + 1);
            }
        }
        System.out.print(fairIndices +"::");
        return fairIdxCount;
    }

    public static void main(String[] args) {
        FairIndex fi = new FairIndex();
        int[] A1 = {4,-1,0,3}, B1 = {-2, 5, 0 ,3};
        System.out.println(fi.getFairIndex(A1, B1));
        int[] A2 = {2,-2,-3,3}, B2 = {0,0,4,-4};
        int[] A3 = {4,-1,0,3}, B3 = {-2,6,0,4};
        int[] A4 = {3,2,6}, B4 = {4,1,6};
        int[] A5 = {1,4,2,-2,5}, B5 = {7,-2,-2,2,5};

        System.out.println(fi.getFairIndex(A2, B2));
        System.out.println(fi.getFairIndex(A3, B3));
        System.out.println(fi.getFairIndex(A4, B4));
        System.out.println(fi.getFairIndex(A5, B5));
    }
}

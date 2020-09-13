package ik.sort;

import java.util.HashSet;
import java.util.Set;

public class SplitArray {
    int[] solve(int[] arr) {
        int l = 0;
        int r = arr.length -1;
        while(l<r){
            while(l<r&&arr[l]%2 == 0)
                l++;
            while(r>0 &&arr[r]%2 !=0)
                r--;
            if(l<=r)
                swap(arr,l,r);
        }
        Set s = new HashSet();

        return arr;
    }
    static void swap(int[] arr, int pos1,int pos2){
        if(pos1 != pos2) {
            int temp = arr[pos1];
            arr[pos1] = arr[pos2];
            arr[pos2] = temp;
        }
    }

    public static void main(String[] args) {
        SplitArray sp = new SplitArray();
        sp.solve(new int[]{3,5});
    }

}

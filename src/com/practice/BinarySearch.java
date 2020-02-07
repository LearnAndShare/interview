package com.practice;

public class BinarySearch {
    public boolean binarySearch(int arr[], int x)
    {

        int l = 0;
        int r = arr.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(arr[mid] == x){
                return true;
            } else if(x>arr[mid]){
                l=mid+1;
            } else {
                r = mid -1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        //[-1,0,3,5,9,12]
        //13
        System.out.println(bs.binarySearch(new int[]{ -1,0,3,5,9,12 },10));
    }


}

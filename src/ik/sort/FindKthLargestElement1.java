package ik.sort;

import java.util.Random;

public class FindKthLargestElement1 {
    public int findKLargestElement(int[] arr,int k){
        int size = arr.length -1;
        int pivotIdx = size - k;
        findKLargestElementHelper(arr,0,size,k);
        return -1;
    }

    private int findKLargestElementHelper(int[] arr, int low, int high,int kthElement) {
        Random r = new Random();

        int pivotIdx = r.nextInt(high-low+1)+low;
        int idx = partition(arr,pivotIdx,low,high);
        if(idx == arr.length - kthElement){
            return arr[idx];
        } else if(idx>(arr.length - kthElement)){
           return findKLargestElementHelper(arr,idx+1,high,kthElement);
        } else {
            return findKLargestElementHelper(arr,low,idx,kthElement);
        }

    }

    public int partition(int[] arr,int pivIdx,int start,int end){

       swap(arr,start,pivIdx);
       int pivotElem = arr[start];
       int smaller = start;
       int bigger = start;
       while(bigger<end){
           if (arr[bigger] > pivotElem) {
              smaller++;
              swap(arr,smaller,bigger);
           }
        }
       return smaller;
    }


    public void swap(int[] arr, int pos1,int pos2){
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }
}

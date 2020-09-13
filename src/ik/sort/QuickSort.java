package ik.sort;

import java.util.Random;

public class QuickSort {
    public void quickSort(int[] arr){
        quickSortHelper(arr,0,arr.length-1);
    }

    private void quickSortHelper(int[] arr, int low, int high) {
        if(low>=high)
            return;
        int pivotIdx = partition(arr,low,high);
        quickSortHelper(arr,low,pivotIdx-1);
        quickSortHelper(arr,pivotIdx+1,high);

    }

    private int partition(int[] arr, int start, int end) {
        int randomIdx = new Random().nextInt(end-start+1)+start;
        swap(arr,start,randomIdx);
        int pivotVal = arr[start];
        int smaller = start;
        for(int bigger = start+1;bigger<=end;bigger++ ){
            if (arr[bigger] < pivotVal) {
                smaller++;
                swap(arr, bigger, smaller);
            }
        }
        swap(arr,smaller,start);
        return smaller;
    }

    public void swap(int[] arr, int pos1,int pos2){
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int [] arr = new int[]{10,40,5,9,45,50};
        arr = new int[]{3,7,8,5,2,1,9,5,4};
        for (int i : arr) {
            System.out.print(i +",");
        }
        System.out.println();
        qs.quickSort(arr);
        for (int i : arr) {
            System.out.print(i +",");
        }

    }
}

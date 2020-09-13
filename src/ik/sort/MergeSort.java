package ik.sort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    static void mergeSort(int[] arr){
        mergeSortHelper(arr,0,arr.length-1);
    }

    public static List<Integer> merge_sort(List<Integer> arr) {
        // Write your code here
        int[] array = arr.stream().mapToInt(i->i).toArray();
        mergeSort(array);
        for (int i = 0; i < array.length; i++) {
            arr.remove(i);
            arr.add(i,array[i]);
        }
        return arr;
    }

    private static void mergeSortHelper(int[] arr, int low, int high) {
        if(low<high) {
            int mid = (low+high)/2;
            mergeSortHelper(arr,low,mid);
            mergeSortHelper(arr,mid+1,high);
            merge1(arr,low,mid,high);
        }
    }

   private static void merge1(int[] arr, int low, int mid, int high) {
        int arr1Size = mid-low+1;
        int arr2Size = high-mid;
        int[] arr1 = new int[arr1Size];
        int[] arr2 = new int[arr2Size];
        for(int i=0;i<arr1Size;i++){
            arr1[i] = arr[low+i];
        }

        for(int j=0;j<arr2Size;j++){
            arr2[j] = arr[mid+1+j];
        }

        int idx1 = 0;
        int idx2 = 0;
        int idx = low;
        while(idx1<arr1Size && idx2<arr2Size){
            if(arr1[idx1]<arr2[idx2]){
                arr[idx] = arr1[idx1];
                idx1++;
            } else {
                arr[idx] = arr2[idx2];
                idx2++;
            }
            idx++;
        }

        while(idx1<arr1Size){
            arr[idx] = arr1[idx1];
            idx++;
            idx1++;
        }

        while(idx2<arr2Size){
            arr[idx] = arr2[idx2];
            idx++;
            idx2++;
        }

    }


    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int[] num = new int[]{12, 11, 13, 5, 6, 7};
        ms.mergeSort(num);
        for (int i : num) {
            System.out.print(i+",");
        }
        List<Integer> li = new ArrayList<>();
        li.add(0);
        li.add(1);
        li.add(3);
        li.add(2);
        System.out.println();
        for (Integer integer : ms.merge_sort(li)) {
            System.out.print(integer+",");
        }
    }
}

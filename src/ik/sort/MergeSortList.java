package ik.sort;

import java.util.ArrayList;
import java.util.List;

public class MergeSortList {
    public static List<Integer> merge_sort(List<Integer> arr) {
        // Write your code here
        mergeSortHelper(arr,0,arr.size()-1);
        return arr;
    }

    private static void mergeSortHelper(List<Integer> arr, int low, int high) {
        if(low<high){
            int mid = (low+high)/2;
            mergeSortHelper(arr,low,mid);
            mergeSortHelper(arr,mid+1,high);
            merge(arr,low,mid,high);

        }
    }

    private static void merge(List<Integer> arr, int low, int mid, int high) {
        List<Integer> list = new ArrayList<>();
        int i = low;
        int j=mid+1;
        while(i<=mid && j<=high){
            if(arr.get(i)<arr.get(j)){
                list.add(arr.get(i));
                ++i;
            } else {
                list.add(arr.get(j));
                ++j;
            }
        }

        while(i<=mid){
            list.add(arr.get(i));
            i++;
        }

        while(j<=high){
            list.add(arr.get(j));
            j++;
        }
        for(int idx=0;idx<list.size();idx++){
            arr.set(idx+low,list.get(idx));
        }

    }

    public static void main(String[] args) {
        List<Integer> li = new ArrayList<>();
        li.add(0);
        li.add(1);
        li.add(3);
        li.add(2);
        System.out.println();
        for (Integer integer : merge_sort(li)) {
            System.out.println(integer+",");
        }
    }
}

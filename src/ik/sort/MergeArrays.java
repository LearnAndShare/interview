package ik.sort;

import java.util.Collections;
import java.util.PriorityQueue;

public class MergeArrays {
    static int[] mergeArrays(int[][] arr) {
        PriorityQueue<Integer> pq =  getPriorityQueue(arr);
        for (int[] ints : arr) {
            for (int anInt : ints) {
              pq.add(anInt);
            }
        }

        int[] outputArray = new int[arr.length*arr[0].length];
        int idx = 0;
        while(!pq.isEmpty()){
            outputArray[idx++] = pq.poll();
        }
        return outputArray;
    }

    private static PriorityQueue<Integer> getPriorityQueue(int[][] arr) {
        boolean isIncreasing = false,isDecreasing=false;
        int col = arr[0].length-1;
        for (int i=0;i<arr.length;i++) {
           if(arr[i][0]<arr[i][col]) {
               isIncreasing = true;
               break;
           }
           if(arr[i][0]<arr[i][col]){
               isDecreasing = true;
               break;
           }

        }
        PriorityQueue<Integer> pq=null;
        if(isIncreasing){
            pq = new PriorityQueue<>();
        }
        if(isDecreasing){
            pq = new PriorityQueue<>(Collections.reverseOrder());
        }
        return pq;
    }

    public static void main(String[] args) {
       /* int[]o = mergeArrays(new int[][]{{1, 3, 5, 7},

                {2, 4, 6, 8},

                {0, 9, 10, 11}});*/
      /*  for (int i : o) {
            System.out.println(i);
        }*/

       int[] o = mergeArrays(new int[][]{{9, 9, 9, 9},
                {9, 9, 9, 9},
                {9, 9, 9, 9},
                {9, 9, 9, 10},
                {9, 9, 9, 9},
                {9, 9, 9, 9}
        });
        for (int i : o) {
            System.out.println(i);
        }
    }

}

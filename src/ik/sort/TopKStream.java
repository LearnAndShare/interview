package ik.sort;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class TopKStream {
    static int[] topK(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue();
        Set<Integer> s = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            if(s.contains(arr[i])){
                continue;
            }
            s.add(arr[i]);
            pq.add(arr[i]);

            if(pq.size()>k){
                pq.poll();
            }
        }

        int[] op = new int[pq.size()];
        int idx = 0;

        while(!pq.isEmpty()){
            op[idx++] = pq.poll();
        }

        return op;
    }

    public static void main(String[] args) {

        int[] r=topK(new int[]{1, 5, 4, 4, 2}, 3);
        for (int i : r) {
            System.out.print(i+",");
        }
    }
}

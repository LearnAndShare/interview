package ik.sort;

import java.util.PriorityQueue;

public class KthLargestElementStream {
    PriorityQueue<Integer> pq ;
    int k;

    public KthLargestElementStream(int k, int[] nums) {
        this.k=k;
        pq = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            add(nums[i]);
        }
    }

    public int add(int val) {
        pq.add(val);
         if(pq.size()>k){
             pq.poll();
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        KthLargestElementStream ks = new KthLargestElementStream(3,new int[]{4,5,8,2});
        System.out.println(ks.add(3));
        System.out.println(ks.add(5));
        System.out.println(ks.add(10));

    }
}

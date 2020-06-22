package com.practice.amazon;

import java.util.PriorityQueue;

/*
https://leetcode.com/problems/k-closest-points-to-origin/
We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)



Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].

Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)

 */
public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((n1,n2)-> n2[2]-n1[2]);
        for(int[] i: points){
            int distVal = distance(i);
            int[] x = {i[0],i[1],distVal};
            pq.add(x);
            if(pq.size()>K){
                pq.poll();
            }
        }
        int[][] pts = new int[K][2];
        int idx = 0;
        while(!pq.isEmpty()){
            int[] d = pq.poll();

            pts[idx++]=(new int[]{d[0],d[1]});
        }
        return pts;
    }

    public static void main(String[] args) {
        KClosestPointsToOrigin kp = new KClosestPointsToOrigin();
        int[][]d = kp.kClosest(new int[][]{{1,3},{-2,2}},1);
        for (int[] ints : d) {
            for (int anInt : ints) {
                System.out.print(anInt+",");
            }
            System.out.println();
        }
    }


    public  int distance(int[] point){
        return point[0]*point[0]+point[1]*point[1];
    }
}

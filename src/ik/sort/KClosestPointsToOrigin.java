package ik.sort;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[]o1, int[]o2) {
                return distance(o1)-distance(o2);
            }
        });
        for(int i=0;i<points.length;i++){
            if(pq.size() >= K){
               pq.poll();
            }
            pq.add(points[i]);
        }

       int[][] n = new int[K][2];
        int i=0;
        while(!pq.isEmpty()){
            int[] t = pq.poll();
            n[i++] = t;
        }

        return n;
    }

    public int distance(int[] point){
        return point[1]*point[1] - point[0]*point[0];
    }

    public static void main(String[] args) {
        KClosestPointsToOrigin kc = new KClosestPointsToOrigin();
        int[][] points = new int[][]{{1, 3}, {-2, 2}};
        points = new int[][]{{3,3},{5,-1},{-2,4}};
        for (int[] ints : kc.kClosest(points, 2)) {
            for (int anInt : ints) {
                System.out.print(anInt+",");
            }
            System.out.println();
        }
    }
}

package com.practice.graph;

import java.util.HashSet;
import java.util.Set;

public class ConnectedCompInUndirectedGraph {
    public int countComponentInGraph(int n,int[][] edges){

        DisjointSet ds = new DisjointSet();
        for(int i=0;i<n;i++)
            ds.makeSet(i);
        for (int[] edge : edges) {
            ds.union(edge[0],edge[1]);
        }
        Set<Long> s = new HashSet<>();
        for(int i=0;i<n-1;i++){
            s.add(ds.findSet(i));
        }
        return s.size();
    }

    public static void main(String[] args) {
        int[][]edges = new int[][]{{0, 1}, {1, 2}, {3, 4}};
        ConnectedCompInUndirectedGraph cg = new ConnectedCompInUndirectedGraph();
        System.out.println(cg.countComponentInGraph(5, edges));
        edges = new int[][]{{0, 1}, {2, 3}, {3, 1}};
        System.out.println(cg.countComponentInGraph(4, edges));
    }
}

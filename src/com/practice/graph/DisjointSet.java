package com.practice.graph;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {
    class Node{
        long data;
        int rank = 0;
        Node parent ;
    }
    Map<Long,Node> nodeMap = new HashMap<>();
    public void makeSet(long data){
        Node n = new Node();
        n.data  =data;
        n.parent = n;
        n.rank = 0;
        nodeMap.put(data,n);
    }

    public boolean union(long d1,long d2){
        Node n1 = nodeMap.get(d1);
        Node n2 = nodeMap.get(d2);
        Node parent1 = find(n1);
        Node parent2 = find(n2);
        if(parent1.data == parent2.data)
            return false;
        if(parent1.rank >= parent2.rank){
            parent1.rank = parent1.rank == parent2.rank?parent1.rank+1:parent1.rank;
            parent2.parent = parent1;
        } else {
          parent1.parent = parent2;
        }
        return true;
    }

    private Node find(Node n1) {
        if(n1.parent == n1)
            return n1;
        n1.parent = find(n1.parent);
        return n1.parent;
    }


    public static void main(String args[]) {
        DisjointSet ds = new DisjointSet();
        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);
        ds.makeSet(7);

        ds.union(1, 2);
        System.out.println("ds.findSet(1)"+ds.findSet(1));
        ds.union(2, 3);
        System.out.println("ds.findSet(2)"+ds.findSet(2));
        System.out.println("ds.findSet(3)"+ds.findSet(3));
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        ds.union(3, 7);


        System.out.println("ds.findSet(2)"+ds.findSet(2));

        System.out.println("ds.findSet(4)"+ds.findSet(4));
        System.out.println("ds.findSet(5)"+ds.findSet(5));
        System.out.println("ds.findSet(6)"+ds.findSet(6));
        System.out.println("ds.findSet(7)"+ds.findSet(7));
    }

    public long findSet(long i) {
        return find(nodeMap.get(i)).data;
    }
}

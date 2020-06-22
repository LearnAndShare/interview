package com.practice.graph;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/redundant-connection/
In this problem, a tree is an undirected graph that is connected and has no cycles.

The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N),
with one additional edge added.
The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v, that represents an undirected edge connecting nodes u and v.

Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format, with u < v.

Example 1:
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given undirected graph will be like this:
  1
 / \
2 - 3
Example 2:
Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
Output: [1,4]
Explanation: The given undirected graph will be like this:
5 - 1 - 2
    |   |
    4 - 3
 */
public class RedundantConnection {

    class DisjointSetU{
        class Node{
            long data;
            int rank = 0;
            DisjointSetU.Node parent ;
        }
        Map<Long,DisjointSetU.Node> nodeMap = new HashMap<>();

        public void makeSet(long data){
            if(!nodeMap.containsKey(data)) {
                DisjointSetU.Node n = new DisjointSetU.Node();
                n.data = data;
                n.parent = n;
                nodeMap.put(data, n);
            }
        }

        public boolean union(long d1,long d2){
            DisjointSetU.Node n1 = nodeMap.get(d1);
            DisjointSetU.Node n2 = nodeMap.get(d2);

            DisjointSetU.Node p1 = findParent(n1);
            DisjointSetU.Node p2 = findParent(n2);
            if(p1.data == p2.data)
                return false;

            if(p1.rank>=p2.rank){
                p1.rank = p1.rank==p2.rank?p1.rank+1:p1.rank;
                p2.parent = p1;
            } else {
                p1.parent = p2;
            }

            return true;
        }

        public DisjointSetU.Node findParent(DisjointSetU.Node n){
            if(n.parent == n)
                return n;
            n.parent = findParent(n.parent);
            return n.parent;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
/*
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
 */
        DisjointSetU ds = new DisjointSetU();
        for (int[] edge : edges) {
            ds.makeSet(edge[0]);
            ds.makeSet(edge[1]);
            if(!ds.union(edge[0],edge[1]))
                return edge;
        }

        return null;
    }

    public static void main(String[] args) {
        RedundantConnection rc = new RedundantConnection();
        int[][] e = {{1,2},{1,3},{2,3}};
        rc.findRedundantConnection(e);
    }

}

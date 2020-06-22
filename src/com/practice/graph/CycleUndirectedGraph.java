package com.practice.graph;

import java.util.*;

public class CycleUndirectedGraph {

    public boolean hasCycleUsingDisjointSets(Graph<Integer> graph){
        Collection<Vertex<Integer>> v =  graph.getAllVertex();
        DisjointSet ds = new DisjointSet();
        for (Vertex<Integer> integerVertex : v) {
            ds.makeSet(integerVertex.getId());
        }
        for (Edge<Integer> allEdge : graph.getAllEdges()) {
            long p1 = ds.findSet(allEdge.getVertex1().getId());
            long p2 = ds.findSet(allEdge.getVertex2().getId());
            if(p1 == p2)
                return true;
            ds.union(allEdge.getVertex1().getId(),allEdge.getVertex2().getId());
        }
        return false;
    }

    public boolean hasCyleDFS(Graph<Integer> g){
        Set<Vertex<Integer>> visited = new HashSet<>();
        Vertex<Integer> integerVertex = g.getAllVertex().iterator().next();



            Stack<String> s = new Stack();
            String str = integerVertex.getId() +";"+ integerVertex.getId();
            s.push(str);

            while(!s.isEmpty()){
                String v = s.pop();

                String[] idstr = v.split(";");
                long id = Long.valueOf(idstr[0]);
                Vertex<Integer> srcV = g.getVertex(id);
                if(visited.contains(srcV))
                    return true;
                visited.add(srcV);
                List<Vertex<Integer>> list =  srcV.getAdjacentVertexes();
                for (Vertex<Integer> adjV : list) {
                    String vstr = adjV.getId() + ";" + srcV.getId();
                    String stakStr = srcV.getId() + ";" + adjV.getId();
                    if (!stakStr.equalsIgnoreCase(v))
                        s.push(vstr);
                }
            }


        return false;
    }

    public static void main(String[] args) {
        CycleUndirectedGraph c = new CycleUndirectedGraph();
        Graph<Integer> graph = new Graph<Integer>(false);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        System.out.println(c.hasCycleUsingDisjointSets(graph));
        System.out.println(c.hasCyleDFS(graph));

        graph = new Graph<Integer>(false);

        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        System.out.println(c.hasCycleUsingDisjointSets(graph));
        System.out.println(c.hasCyleDFS(graph));
    }
}

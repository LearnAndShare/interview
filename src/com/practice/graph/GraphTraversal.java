package com.practice.graph;

import java.util.*;

public class GraphTraversal {
    public void depthFirstSearchIterative(Graph<Integer> graph){
        List<Vertex<Integer>> vertex = new ArrayList<>(graph.getAllVertex());
        Set<Vertex<Integer>> visited = new HashSet<>();
        // Create a stack for GraphTraversal
        Stack<Vertex<Integer>> stack = new Stack<>();

        for (Vertex v1:graph.getAllVertex()) {
            if(!visited.contains(v1)){
                stack.push(v1);
                while(!stack.isEmpty()){
                    Vertex v = stack.pop();
                    visited.add(v);
                    System.out.print(v.getId()+" ");
                    List<Vertex<Integer>> adjV = v.getAdjacentVertexes();
                    if(adjV != null && adjV.size() > 0) {
                        for (Vertex v2 : adjV) {
                            if(!visited.contains(v2))
                                stack.push(v2);
                        }
                    }
                }


            }
        }
    }
    public void depthFirstSearchRecursive(Graph<Integer> graph){
        Set<Long> visited = new HashSet<Long>();
        for(Vertex<Integer> vertex : graph.getAllVertex()){
            if(!visited.contains(vertex.getId())){
                DFSUtil(vertex,visited);
            }
        }
    }

    private void DFSUtil(Vertex<Integer> vertex, Set<Long> visited) {
        visited.add(vertex.getId());
        System.out.print(vertex.getId()+" ");
        List<Vertex<Integer>> adjV = vertex.getAdjacentVertexes();
        if(adjV != null && adjV.size() > 0) {
            for (Vertex v2 : adjV) {
                if (!visited.contains(v2.getId()))
                    DFSUtil(v2,visited);
            }
        }
    }

    public void BFS(Graph<Integer> graph){
        Set<Vertex<Integer>> visited = new HashSet<>();
        // Create a queue for BFS
        Queue<Vertex<Integer>> queue = new LinkedList<>();
        for (Vertex v1:graph.getAllVertex()) {
            if (!visited.contains(v1)) {
                queue.add(v1);
                while(!queue.isEmpty()){
                    Vertex v = queue.poll();
                    visited.add(v);
                    System.out.print(v.getId());
                    List<Vertex<Integer>> adjV = v.getAdjacentVertexes();
                    if(adjV != null && adjV.size() > 0) {
                        for (Vertex v2 : adjV) {
                            if(!visited.contains(v2))
                                queue.add(v2);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<Integer>(false);
        GraphTraversal d = new GraphTraversal();
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        System.out.println("DFS Iterative::");
        d.depthFirstSearchIterative(graph);

        System.out.println("\nDFS Recursive::");
        d.depthFirstSearchRecursive(graph);

        System.out.println("\nBFS::");
        d.BFS(graph);
    }
}

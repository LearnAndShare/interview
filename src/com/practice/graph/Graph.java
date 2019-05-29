package com.practice.graph;

import java.util.*;

public class Graph<T> {
    private List<Edge<T>> allEdges;
    private Map<Long,Vertex<T>> allVertex;
    boolean isDirected = false;

    public Graph(boolean isDirected){
        allEdges = new ArrayList<Edge<T>>();
        allVertex = new HashMap<Long,Vertex<T>>();
        this.isDirected = isDirected;
    }

    public Vertex<T> addSingleVertex(long id){
        Vertex<T> v = null;
        if(allVertex.containsKey(id))
            v = allVertex.get(id);
        else {
            v = new Vertex<>(id);
            allVertex.put(id, v);
        }
        return v;
    }

    public Vertex<T> getVertex(long id){
        return allVertex.get(id);
    }
    public void addEdge(long id1, long id2){
        addEdge(id1,id2,0);
    }

    public void addEdge(long id1,long id2, int weight){
        Vertex<T> v1 = addSingleVertex(id1);
        Vertex<T> v2 = addSingleVertex(id2);
        Edge<T> edge = new Edge<T>(v1,v2,isDirected,weight);
        allEdges.add(edge);
        v1.addAdjacentVertex(edge,v2);
        if(!isDirected)
            v2.addAdjacentVertex(edge,v1);
    }

    public List<Edge<T>> getAllEdges(){
        return allEdges;
    }

    public Collection<Vertex<T>> getAllVertex(){
        return allVertex.values();
    }


    public void setDataForVertex(long id, T data){
        if(allVertex.containsKey(id)){
            Vertex<T> vertex = allVertex.get(id);
            vertex.setData(data);
        }
    }

    @Override
    public String toString(){
        StringBuffer buffer = new StringBuffer();
        for(Edge<T> edge : getAllEdges()){
            buffer.append(edge.getVertex1() + " " + edge.getVertex2() + " " + edge.getWeight());
            buffer.append("\n");
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<Integer>(false);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        System.out.println(graph.toString());
    }

}

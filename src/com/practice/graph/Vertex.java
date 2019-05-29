package com.practice.graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {
    public long getId() {
        return id;
    }

    private long id;

    public void setData(T data) {
        this.data = data;
    }

    private T data;
    private List<Vertex<T>> adjacentVertex = new ArrayList<>();
    //List of Edges
    private List<Edge<T>> edges = new ArrayList<>();

    Vertex(long id){
        this.id = id;
    }

    public List<Vertex<T>> getAdjacentVertexes(){
        return adjacentVertex;
    }

    public List<Edge<T>> getEdges(){
        return edges;
    }

    public void addAdjacentVertex(Edge<T> e,Vertex<T> v){
        adjacentVertex.add(v);
        edges.add(e);
    }

    /*public int getDegree(){
        return edges.size();
    }*/

    @Override
    public String toString() {
        return String.valueOf(id);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vertex other = (Vertex) obj;
        if (id != other.id)
            return false;
        return true;
    }
}

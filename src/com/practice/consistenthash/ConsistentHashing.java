package com.practice.consistenthash;

import java.util.*;

/*
https://www.acodersjourney.com/system-design-interview-consistent-hashing/
https://medium.com/@sandeep4.verma/consistent-hashing-8eea3fb4a598
https://www.interviewcake.com/concept/java/consistent-hashing
 */
public class ConsistentHashing<T> {
    SortedMap<Integer,T> circle = new TreeMap<>();
    private int numberOfReplicas;
    private final HashFunction hashFunction;

    public ConsistentHashing(HashFunction hashFunction, int numberOfReplicas, Collection<T> nodes){
        this.hashFunction = hashFunction;
        this.numberOfReplicas = numberOfReplicas;
        for(T node:nodes)
            addNodeToRing(node);
    }

    private void addNodeToRing(T node) {
        for(int i=0;i<numberOfReplicas;i++){
            circle.put(hashFunction.hash(node.toString()+i),node);
        }
    }

    private void removeNodeFromRing(T node){
        for(int i=0;i<numberOfReplicas;i++){
            circle.remove(hashFunction.hash(node.toString()+i));
        }
    }

    private T getNodeFromRing(Object key){
        if(circle.isEmpty())
            return null;
        int hash = hashFunction.hash(key.toString());
        if(!circle.containsKey(hash)){
            SortedMap<Integer, T> tailMap =circle.tailMap(hash);
            hash = tailMap.isEmpty()?circle.firstKey():tailMap.firstKey();
        }
        return circle.get(hash);

    }
}

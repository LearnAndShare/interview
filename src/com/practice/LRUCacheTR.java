package com.practice;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheTR {
    private LinkedHashMap<Integer,Integer> map;
    private int capacity;
    public LRUCacheTR(int capacity) {
        this.capacity = capacity;
        this.map = new MyMap(capacity);
    }

    public int get(int key) {
        Integer val = map.get(key);
        return val == null ? -1 : val;
    }

    public void put(int key, int value) {
        map.put(key, value);
    }

    class MyMap extends LinkedHashMap<Integer, Integer> {
        int capacity;
        MyMap(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> entry) {
            return size() > capacity;
        }
    }
}

package com.practice;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
    class LRUObject{
        int key;
        int val;
        LRUObject prev;
        LRUObject next;
        LRUObject(int key,int val){
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity){
        this.capacity = capacity;
    }
    private int capacity;
    LRUObject front = null;
    LRUObject rear = null;

    Map<Integer,LRUObject> lruMap = new LinkedHashMap<>();

    public int get(int key) {
        int val = -1;
        if(lruMap.containsKey(key)) {
            val = lruMap.get(key).val;
            moveToFront(lruMap.get(key));

        }
        return val;
    }

    private void moveToFront(LRUObject lruObject) {
        if(lruObject.next == null && lruObject.prev != null){
            rear=lruObject.prev;
            lruObject.prev.next = null;
            front.prev = lruObject;
            lruObject.next = front;
            lruObject.prev = null;
            front = lruObject;

        }
        if(lruObject.prev!=null&& lruObject.next !=null){

            lruObject.next.prev = lruObject.prev;
            lruObject.prev.next = lruObject.next;
            lruObject.next = front;
            lruObject.prev = null;
            front.prev = lruObject;
            front = lruObject;
        }
    }

    public void put(int key, int value) {
        LRUObject l = new LRUObject(key,value);
        if(lruMap.containsKey(key)){
            LRUObject l1 = lruMap.get(key);
            l1.val = value;
            moveToFront(l1);
        } else {
            if (lruMap.size() == capacity) {
                removeFromLast();
            }
            addToFront(l);
        }
    }

    private void addToFront(LRUObject l) {
        if(front == null){
            front = l;
        } else {
            front.prev = l;
            l.next = front;
            front = l;
        }
        lruMap.put(l.key,l);
        if(rear== null) {
            rear = l;
        }
    }

    private void removeFromLast() {
        if(rear != null){
            lruMap.remove(rear.key);
            rear = rear.prev;
            if(rear !=null)
            rear.next = null;
        }


    }


    public static void main(String[] args) {
       // LRUCache cache = new LRUCache( 2 /* capacity */ );
        /*cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);// evicts key 2
        System.out.println(cache.get(2));*/
/*
["LRUCache","put","get","put","get","get"]
[[1],[2,1],[2],[3,2],[2],[3]]

 */
        LRUCache cache = new LRUCache( 1 /* capacity */ );
        cache.put(2, 1);
        System.out.println(cache.get(2));
        cache.put(3, 2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        /*
        ["LRUCache","put","put","put","put","get","get","get","get","put","get","get","get","get","get"]
[[3],[1,1],[2,2],[3,3],[4,4],[4],[3],[2],[1],[5,5],[1],[2],[3],[4],[5]]

         */
        System.out.println("=============================");
         cache = new LRUCache( 3 /* capacity */ );
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        System.out.print(cache.get(4));
        System.out.print(cache.get(3));
        System.out.print(cache.get(2));
        System.out.print(cache.get(1));
        cache.put(5, 5);
        System.out.print(cache.get(1));
        System.out.print(cache.get(2));
        System.out.print(cache.get(3));
        System.out.print(cache.get(4));
        System.out.print(cache.get(5));
    }
}

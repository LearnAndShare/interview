package com.practice.heap;

import java.util.Arrays;

public abstract class Heap {

    /** Swap values down the Heap. **/
    public abstract void heapifyDown();

    /** Swap values up the Heap. **/
    public abstract void heapifyUp();

    int [] items;
    int capacity;
    int size;

    public Heap(){
        this.capacity=10;
        size=0;
        items = new int[capacity];
    }

    public int getLeftChildIdx(int idx){
        return idx*2+1;
    }

    public int getRightChildIdx(int idx){
        return idx*2+2;
    }

    public int getParentIdx(int idx){
        return (idx-1)/2;
    }


    public boolean hasLeftChild(int idx){
        return getLeftChildIdx(idx) < size;
    }

    public boolean hasRightChild(int idx){
        return getRightChildIdx(idx) < size;
    }


    public boolean hasParent(int idx){
        return getParentIdx(idx) >=0;
    }


    public int leftChild(int idx){
        return items[getLeftChildIdx(idx)];
    }

    public int rightChild(int idx){
        return items[getRightChildIdx(idx)];
    }


    public int parent(int idx){
        return items[getParentIdx(idx)];
    }

    public void swap(int idx1,int idx2){
        int tmp = items[idx2];
        items[idx2] = items[idx1];
        items[idx1] =tmp;

    }

    public void ensureCapacity(){
        if(size ==  capacity){
            capacity *= 2;
            items = Arrays.copyOf(items,capacity);
        }
    }

    public int peek(){
        return items[0];
    }

    public int poll(){
        int item = items[0];
        items[0] = items[size-1];
        size--;
        heapifyDown();
        return item;
    }


    public void push(int item){
      ensureCapacity();
      items[size] = item;
      size ++;
      heapifyUp();
    }


}

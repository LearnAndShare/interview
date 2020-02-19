package com.practice.heap;

import java.util.Arrays;

public class MinIntHeap {
    int capacity = 0;
    int size = 0;
    int[] arr = new int[capacity];

    private int getLeftChildIdx(int idx){
        return idx*2+1;
    }

    private int getRightChildIdx(int idx){
        return idx*2 +2;
    }

    private int getParentIdx(int idx){
        return (idx -1)/2;
    }

    private boolean hasLeftChild(int idx){
        return getLeftChildIdx(idx)<size;
    }
    private boolean hasRightChild(int idx){
        return getRightChildIdx(idx)<size;
    }

    private boolean hasParent(int idx){
        return getParentIdx(idx)<=0;
    }

    private int getLeftChild(int idx){
        return arr[getLeftChildIdx(idx)];
    }

    private int getRightChild(int idx){
        return arr[getRightChildIdx(idx)];
    }

    private int getParent(int idx){
        return arr[getParentIdx(idx)];
    }


    private void swap(int idx1,int idx2){
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    private void ensureExtraCapacity(){
        if(capacity == size){
            arr = Arrays.copyOf(arr,2*capacity);
            capacity*=2;
        }
    }


    public int peek(){
        if(size ==0)
            throw new IllegalStateException();
        return arr[0];
    }

    public int poll(){
        int item = peek();
        arr[0] = arr[size-1];
        size--;
        heapifyDown();
        return item;
    }

    public void add(int item){
        ensureExtraCapacity();
        arr[size] = item;
        size++;
        heapifyUp();
    }

    public void heapifyUp(){
        int index = size-1;
        while(hasParent(index) && getParent(getParentIdx(index))>arr[index]){
            swap(index,getParentIdx(index));
            index = getParentIdx(index);
        }
    }



    public void heapifyDown(){
        int index =0;
        while(hasLeftChild(index)){
            int smallerChildIdx = getLeftChildIdx(index);
            if(hasRightChild(index) && getRightChild(index)<arr[smallerChildIdx]){
                smallerChildIdx = getRightChildIdx(index);
            }

            if(arr[index]>arr[smallerChildIdx]){
                swap(index,smallerChildIdx);
            } else {
                break;
            }
            index = smallerChildIdx;
        }
    }
}

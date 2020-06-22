package com.practice.heap;

public class MaxHeap extends Heap{
    @Override
    public void heapifyDown(){
      int index = 0;
      while(hasLeftChild(index)){
          int largerChildIdx = getLeftChildIdx(index);
          if(hasRightChild(index) && rightChild(index) > leftChild(index)){
              largerChildIdx = getRightChildIdx(index);
          }

          if(items[index] > items[largerChildIdx]){
                break;
          } else{
             swap(index,largerChildIdx);
          }
          index = largerChildIdx;
      }
    }

    @Override
    public void heapifyUp() {
        int index  = size-1;
        while(hasParent(index) && parent(index)<items[index]){
            swap(index,getParentIdx(index));
            index = getParentIdx(index);

        }
    }

    public static void main(String[] args) {
        int [] arr= new int[]{12,3,6,23,56,19};
        Heap maxHeap = new MaxHeap();
        for (int i : arr) {
            maxHeap.push(i);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(maxHeap.poll());

        }
    }




}

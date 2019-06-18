package com.practice.linkedlist;

import com.practice.linkedlist.ListNode;

/*
https://leetcode.com/problems/partition-list/
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5


 */
public class PartitionLinkedList {
    public ListNode partition(ListNode head, int x) {
        ListNode p = head;
        ListNode fakeHead = new ListNode(0);
        ListNode fakeHead2 = new ListNode(0);
        fakeHead.next = head;
        ListNode prev = fakeHead;
        ListNode p2 = fakeHead2;
        while(p != null){
            if(p.val < x){
                p = p.next;
                prev = prev.next;
            }else{
                p2.next = p;
                prev.next = p.next;
                p=p.next;
                p2=p2.next;
            }
        }
        p2.next = null;
        prev.next = fakeHead2.next;
        return fakeHead.next;

    }
}

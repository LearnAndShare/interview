package com.practice.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/merge-two-sorted-lists/description/
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

 */
public class MergeTwoSortedLL {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null && l2 ==null)
            return null;
        if(l2 == null)
            return l1;

        if(l1 == null)
            return l2;

        ListNode l = new ListNode(-1);
        ListNode tmp = l;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                l.next = l1;
                l1 = l1.next;
            } else {
                l.next = l2;
                l2 = l2.next;
            }
            l = l.next;
        }
        if(l1 != null){
            l.next = l1;

        }
        if(l2 != null){
            l.next = l2;
        }
        return tmp.next;
    }


    public ListNode mergeTwoListsPQ(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
        });
        ListNode head = new ListNode(0);
        ListNode p = head;

        queue.offer(l1);
        queue.offer(l2);

        while(!queue.isEmpty()){
            ListNode n = queue.poll();
            p.next = n;
            p=p.next;

            if(n.next!=null)
                queue.offer(n.next);
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = LinkedListUtil.getLinkedListFromString("1,2,4");
        ListNode l2 = LinkedListUtil.getLinkedListFromString("1,3,4");
        MergeTwoSortedLL ms = new MergeTwoSortedLL();
        ListNode fl = ms.mergeTwoListsPQ(l1,l2);
        LinkedListUtil.print(fl);
    }
}

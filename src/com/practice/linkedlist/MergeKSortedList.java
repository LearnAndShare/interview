package com.practice.linkedlist;

import java.util.PriorityQueue;

/*
https://leetcode.com/problems/merge-k-sorted-lists/
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6


 */
public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        ListNode l = new ListNode(0);
        ListNode tmp =l;

//        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((l1, l2) -> l1.val - l2.val);
        PriorityQueue<ListNode> pq = new PriorityQueue<>((e1,e2)-> e1.val-e2.val);
        for (int i = 0; i < lists.length; i++) {
            if(lists[i] != null)
                pq.offer(lists[i]);
        }
        while (!pq.isEmpty()) {
            ListNode lIdx = pq.poll();
            l.next = lIdx;
            l = l.next;
            lIdx = lIdx.next;
            if (lIdx != null)
                pq.offer(lIdx);
        }
        return tmp.next;
    }

    public static void main(String[] args) {
        ListNode l1 = LinkedListUtil.getLinkedListFromString("1,4,5");
        ListNode l2 = LinkedListUtil.getLinkedListFromString("2,6");
        ListNode l3 = LinkedListUtil.getLinkedListFromString("1,3,4");
        ListNode[] listArr = new ListNode[]{l1,l2,l3};
        MergeKSortedList ms = new MergeKSortedList();
        ListNode sl = ms.mergeKLists(listArr);
        LinkedListUtil.print(sl);
    }
}

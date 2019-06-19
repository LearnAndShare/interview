package com.practice.linkedlist;

import com.practice.linkedlist.LinkedListUtil;
import com.practice.linkedlist.ListNode;

/*
https://leetcode.com/problems/reorder-list/
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.

Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.


 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return;
        ListNode pl = head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode revHead = slow.next;
        slow.next = null;
        ListNode prev = null;
        while (revHead != null) {
            ListNode tmp = revHead.next;
            revHead.next = prev;
            prev = revHead;
            revHead = tmp;
        }
        revHead = prev;
        //Merge two LL
        while(revHead != null){
            ListNode tmp = pl.next;
            ListNode tmp1 = revHead.next;
            pl.next = revHead;
            revHead.next = tmp;
            pl = tmp;
            revHead = tmp1;
        }


    }

    public static void main(String[] args) {
        ReorderList rl = new ReorderList();
        ListNode l1 = LinkedListUtil.getLinkedListFromString("1,2,3,4");
        rl.reorderList(l1);
        LinkedListUtil.print(l1);

        ListNode l2 = LinkedListUtil.getLinkedListFromString("1,2,3,4,5");
        rl.reorderList(l2);
        LinkedListUtil.print(l2);
    }

}

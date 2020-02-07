package com.practice.linkedlist;

import java.util.TreeMap;

/*
https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5

Example 2:

Input: 1->1->1->2->3
Output: 2->3

 */
public class LLDeleteDuplicatesII {
    public ListNode deleteDuplicatesII(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode t = head;
        ListNode newhead = head;
        ListNode prev = null;
        boolean isNewHead = false;

        while (t!=null && t.next != null) {
            if (t.val == t.next.val) {
                if (t == newhead) {
                    isNewHead = true;
                } else {
                    isNewHead = false;
                }

                while (t.next != null && t.val == t.next.val) {
                    t = t.next;
                }

                if(isNewHead){
                    newhead = t.next;
                    t = newhead;
                } else {
                    if (prev != null)
                        prev.next = t.next;
                    t.next = null;
                    t = prev.next;
                }
            } else {
                prev = t;
                t = t.next;
            }

        }
        return newhead;
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode t = head;
        ListNode newhead = null;
        ListNode prev = null;
        while (t != null) {
            if (t.next != null && t.val == t.next.val) {
                if (prev != null)
                    prev.next = null;
                while (t.next != null && t.val == t.next.val) t = t.next;
                t = t.next;
            } else {
                ListNode n = t.next;
                if (newhead == null) {
                    newhead = t;
                    prev = newhead;
                } else {
                    prev.next = t;
                    prev = t;

                }
                t = n;
            }
        }
        return newhead;
    }



    public static void main(String[] args) {
        LLDeleteDuplicatesII l = new LLDeleteDuplicatesII();
        ListNode ll = l.deleteDuplicatesII(LinkedListUtil.getLinkedListFromString("1,2,3,4"));
        LinkedListUtil.print(ll);

        ll=null;
        ll = l.deleteDuplicatesII(LinkedListUtil.getLinkedListFromString("1,2,3,3,3,4,4,5"));
        LinkedListUtil.print(ll);

        ll=null;
        ll = l.deleteDuplicatesII(LinkedListUtil.getLinkedListFromString("1,2,3,3,3,4,4,5,6,7"));
        LinkedListUtil.print(ll);

        ll=null;
        ll = l.deleteDuplicatesII(LinkedListUtil.getLinkedListFromString("1,1,1,2,2,3,3,3,4,4,5,6,7"));
        LinkedListUtil.print(ll);

        ll=null;
        ll = l.deleteDuplicatesII(LinkedListUtil.getLinkedListFromString("1,1"));
        LinkedListUtil.print(ll);

       /* TreeMap<Integer,Integer> m = new TreeMap<>();
        System.out.println("==================");
        m.put(0,3);
        m.put(-1,2);
        m.put(1,20);
        m.put(2,25);
        m.values().forEach(System.out::println);*/
    }
}

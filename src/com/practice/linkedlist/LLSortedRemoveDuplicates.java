package com.practice.linkedlist;
/*
https://leetcode.com/problems/remove-duplicates-from-sorted-list/
Given a sorted linked list, delete all duplicates such that each element appear only once.
Example 1:

Input: 1->1->2
Output: 1->2

Example 2:

Input: 1->1->2->3->3
Output: 1->2->3

 */
public class LLSortedRemoveDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode t = head;
       /* int v = head.val;
        ListNode prev = t;
        t = t.next;
        while(t != null){
              if(t.val == v) {
                  t = t.next;
                  continue;
              }
              v = t.val;
              prev.next = t;
              prev = t;
              t = t.next;
        }
        prev.next = null;*/
       while(t != null && t.next !=null){
           if(t.val == t.next.val){
               t.next = t.next.next;
           } else{
               t = t.next;
           }
       }
        return head;

    }

    public static void main(String[] args) {
        LLSortedRemoveDuplicates l = new LLSortedRemoveDuplicates();
        ListNode ll = l.deleteDuplicates( LinkedListUtil.getLinkedListFromString("1,3,3,3"));
        LinkedListUtil.print(ll);
    }
}

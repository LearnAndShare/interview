package com.practice.linkedlist;
/*
https://leetcode.com/problems/palindrome-linked-list/
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
 */
public class LLPalindrome {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode h2 = slow.next;
        ListNode p1 = h2;
        ListNode p2 = p1.next;
        slow.next = null;
        while(p1 != null && p2 != null){
           ListNode tmp = p2.next;
            p2.next = p1;
            p1= p2;
            p2 = tmp;
        }

        h2.next = null;

        ListNode p = (p2==null?p1:p2);
        ListNode q = head;
        while(p!=null){
            if(p.val != q.val)
                return false;

            p = p.next;
            q = q.next;

        }

        return true;
    }
}

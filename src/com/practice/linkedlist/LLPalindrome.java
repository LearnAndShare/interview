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

        //Find the middle node in the List
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        //Now, "slow" is the middle node in the list, reverse the second half of the List
        ListNode h2 = slow.next;
        slow.next = null;

        //Compare if the first half of the list and reversed second half of the list are same
        ListNode q = head;
        ListNode p = reverseLL(h2);
        while(p!=null){
            if(p.val != q.val)
                return false;
            p = p.next;
            q = q.next;
        }

        return true;
    }

    //1-2-3-4
    public ListNode reverseLL(ListNode node){
        ListNode prev = null;
        ListNode curr = node;

        while(curr != null){
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }

    public static void main(String[] args) {
        LLPalindrome ll = new LLPalindrome();
        System.out.println(ll.isPalindrome(LinkedListUtil.getLinkedListFromString("1,2,2,1")));
    }
}

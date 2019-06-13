package com.practice;

/*
https://leetcode.com/problems/remove-linked-list-elements/
Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5


 */
public class LLRemoveElement {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        ListNode h = head;
        ListNode prev = null;
        while (h != null) {
            if (h.val == val) {
                if (h == head) {
                    head = head.next;
                } else {
                    prev.next = h.next;

                }

            } else {
                prev = h;
            }

            h = h.next;
        }

        return head;

    }

    public static void main(String[] args) {
        LLRemoveElement l = new LLRemoveElement();

        LinkedListUtil.print(l.removeElements(LinkedListUtil.getLinkedListFromString("1,2,2,1"), 2));
    }
}

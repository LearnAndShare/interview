package com.practice;

/*
https://leetcode.com/problems/odd-even-linked-list/
Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL

Example 2:

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL

 */
public class OddEvenLinkList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;

        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode connect = p2;
        while (p1 != null && p2 != null) {
            ListNode tmp = p1.next.next;
            if(tmp == null)
                break;
            p1.next = p2.next;
            p1 = p1.next;
            p2.next = p1.next;
            p2 = p2.next;
        }
        p1.next = connect;
        return head;
    }

    public static void main(String[] args) {
        OddEvenLinkList l = new OddEvenLinkList();
        ListNode ll = l.oddEvenList( LinkedListUtil.getLinkedListFromString("1,2,3,4,5,6,7,8"));

    }
}

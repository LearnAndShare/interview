package com.practice.linkedlist;

import java.util.List;
/*
https://leetcode.com/problems/linked-list-cycle-ii/
Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.

Example 2:

Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.

Example 3:

Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.


 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next ==null )
            return null;


        ListNode slow= head;
        ListNode fast = slow.next;
        boolean hasCycle = true;
        while(fast != slow){
            if(slow.next == null || fast.next == null || fast.next.next == null) {
                hasCycle = false;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;

        }

        if(hasCycle){
            ListNode p1 = head;
            ListNode p2 = slow;
            while(p1 != p2.next){
                p1 = p1.next;
                p2 = p2.next;
            }
            return p1;
        }
        return null;
    }

    public static void main(String[] args) {
        LinkedListCycleII c  =new LinkedListCycleII();

        ListNode l = new ListNode(3);
        ListNode head = l;
        ListNode l1 = new ListNode(2);
        l.next = l1;
        ListNode l2 = new ListNode(0);
        l1.next = l2;
        ListNode l3 = new ListNode(-4);
        l2.next = l3;
        l3.next = l1;
        LinkedListCycle cy  =new LinkedListCycle();
        System.out.println(cy.hasCycle(head));
     c.detectCycle(head);
    }
}

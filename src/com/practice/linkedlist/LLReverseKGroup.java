package com.practice.linkedlist;

/*
https://leetcode.com/problems/reverse-nodes-in-k-group/
Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
 */
public class LLReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        int i=1;
        ListNode f = new ListNode(0);
        f.next = head;

        ListNode prev = f;
        ListNode curr = head;
        while(curr != null ){
            if(i == k){
                prev = reverse(prev,curr.next);
                curr = prev;
                i =1;
            } else {
                ++i;
            }
            curr = curr.next;

        }
        return f.next;
    }

    private ListNode reverse(ListNode prev, ListNode next) {
        ListNode p1 = prev.next;
        ListNode p2 = p1.next;
        while(p2 != next){
            ListNode t =p2.next;
            p2.next = p1;
            p1=p2;
            p2=t;
        }

        ListNode rNode = prev.next;

        prev.next.next = p2;
        prev.next = p1;
        return rNode;
    }

    public static void main(String[] args) {
        LLReverseKGroup l = new LLReverseKGroup();
        ListNode ll = LinkedListUtil.getLinkedListFromString("1,2,3,4,5");
        LinkedListUtil.print(ll);
        System.out.println("===================");
//        LinkedListUtil.print(l.reverseKGroup(ll,2));
        System.out.println("===================");
        LinkedListUtil.print(l.reverseKGroup(ll,3));


        ListNode lw = LinkedListUtil.getLinkedListFromString("1,2");
        System.out.println("===================");
        LinkedListUtil.print(l.reverseKGroup(lw,2));

    }
}

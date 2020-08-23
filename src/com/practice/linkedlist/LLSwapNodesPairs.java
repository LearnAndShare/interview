package com.practice.linkedlist;
/*
https://leetcode.com/problems/swap-nodes-in-pairs/
https://www.youtube.com/watch?v=-xwX521Ija4
Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.

 */
public class LLSwapNodesPairs {
    /*
TimeComplexity: O(n)
Space Complexity: O(1)
 */
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode tmp = new ListNode(0);
        tmp.next = head;
        ListNode current = tmp;

        while(current.next != null && current.next.next != null){
            ListNode fn = current.next;
            ListNode sn = current.next.next;
            fn.next = sn.next;
            current.next = sn;
            sn.next= fn;
            current = current.next.next;
        }
        return tmp.next;
    }
/*
TimeComplexity: O(n)
Space Complexity: O(n) recursion stack
 */
    public ListNode swapPairsRecursion(ListNode head){
        if(head == null || head.next ==  null){
            return head;
        }
        ListNode fn = head;
        ListNode sn = head.next;
        fn.next = swapPairsRecursion(sn.next);
        sn.next = fn;
        return sn;
    }

    public static void main(String[] args) {
        ListNode l = LinkedListUtil.getLinkedListFromString("1,2,3,4");
        LinkedListUtil.print(l);
        LLSwapNodesPairs lswp = new LLSwapNodesPairs();
        l = lswp.swapPairs(l);
        LinkedListUtil.print(l);
        System.out.println("Swap Nodes in recursion");
        l = null;
        l = LinkedListUtil.getLinkedListFromString("1,2,3,4");
        LinkedListUtil.print(l);
        l = lswp.swapPairs(l);
        LinkedListUtil.print(l);
    }
}

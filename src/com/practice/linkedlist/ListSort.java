package com.practice.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5
 */

public class ListSort {
    public ListNode sortList(ListNode head) {
        if(head == null|| head.next==null)
            return head;
        ListNode l = new ListNode(-1);
        ListNode tmp = l;
        List<Integer> list = new ArrayList<>();
        ListNode t = head;
        while(t != null){
            list.add(t.val);
            t = t.next;
        }

        Collections.sort(list);
        for (Integer integer : list) {
            l.next = new ListNode(integer);
            l = l.next;
        }
        return tmp.next;
    }

    public static void main(String[] args) {
        ListNode ll = LinkedListUtil.getLinkedListFromString("4,2,1,3");
        ListSort ls = new ListSort();
        ListNode sl = ls.sortList(ll);
        LinkedListUtil.print(sl);
    }

}

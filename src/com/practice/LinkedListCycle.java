package com.practice;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        if(head.next == head)
            return true;

        ListNode slow= head;
        ListNode fast = slow;
        while(fast != slow){
            if(slow.next == null || fast.next == null || fast.next.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;

        }
        return true;

    }

    public static void main(String[] args) {
        LinkedListCycle c  =new LinkedListCycle();
        System.out.println(c.hasCycle(LinkedListUtil.getLinkedListFromString("3,2,0,-4")));
    }

}

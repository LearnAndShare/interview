package com.practice;

public class LLRemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || (n==1 && head.next == null))
            return null;
        ListNode tmp = head;
        for(int i=0;i<n;i++)
            tmp = tmp.next;
        if(tmp == null)
            return head.next;
        ListNode tmp1 = head;
        ListNode prev = null;
        while(tmp !=null){
            tmp = tmp.next;
            prev = tmp1;
            tmp1 = tmp1.next;
        }

        prev.next = tmp1.next;
        return head;
    }

    public static void main(String[] args) {
        LLRemoveNthNode l = new LLRemoveNthNode();

        LinkedListUtil.print(l.removeNthFromEnd(LinkedListUtil.getLinkedListFromString("1,2,3,4,5"), 2));
    }
}

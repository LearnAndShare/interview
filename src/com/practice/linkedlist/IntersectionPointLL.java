package com.practice.linkedlist;

public class IntersectionPointLL {

    public int getLength(ListNode l) {
        int len = 0;
        while (l != null) {
            ++len;
            l = l.next;
        }
        return len;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode h1 = headA;
        ListNode h2 = headB;
        int len1 = getLength(headA);
        int len2 = getLength(headB);
        if (len1 > len2) {
            int diff = len1 - len2;
            for (int i = 0; i < diff; i++)
                h1 = h1.next;
        } else if (len2 > len1) {
            int diff = len2 - len1;
            for (int i = 0; i < diff; i++)
                h2 = h2.next;
        }

        while (h1 != null && h2 != null) {
            if (h1 == h2)
                return h1;
            h1= h1.next;
            h2 = h2.next;
        }

        return null;
    }
}

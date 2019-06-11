package com.practice;

public class AddNumberLL {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(0);
        ListNode p1 = p;
        if (l2 == null)
            return l1;
        if (l1 == null)
            return l2;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            if (sum > 9) {
                carry = 1;
                sum -= 10;
            } else {
                carry = 0;
            }
            ListNode n = new ListNode(sum);
            p.next = n;
            p = p.next;

        }

        if (carry > 0) {
            p.next = new ListNode(1);

        }

        return p1.next;
    }

    public static void main(String[] args) {
        ListNode l1 = LinkedListUtil.getLinkedListFromString("3,4,2");
        ListNode l2 = LinkedListUtil.getLinkedListFromString("4,6,5");
        AddNumberLL a = new AddNumberLL();
        a.addTwoNumbers(l1,l2);
    }

}

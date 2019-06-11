package com.practice;

import java.util.List;
import java.util.StringTokenizer;

public class LinkedListUtil {

    public static void print(ListNode head){
        if(head == null){
            System.out.println("NULL!!!");
        }
        while(head != null){
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode current = head;
        ListNode prev = null;
        while(current != null){
            ListNode tmp = current.next;
            current.next= prev;
            prev = current;
            current = tmp;
        }
        head = prev;
        print(head);
        return head;
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null || (m==1 && n == 1)){
            return head;
        }
        int i = 1;
        ListNode current = head;
        ListNode prev = null;
        ListNode firstN = null;
        while(current != null && i<= n){
            if(i >=m && i<=n) {
                if(i == m){
                    firstN = prev;
                    /*if(firstN == null){
                        firstN = head;
                    }*/
                }
                ListNode tmp = current.next;
                current.next = prev;
                prev = current;
                current = tmp;
            } else {
                prev = current;
                current = current.next;
            }
            ++i;
        }
        if(firstN == null){
            head.next = current;
            head = prev;

        } else {
            if (firstN != null && firstN.next != null) {
                firstN.next.next = current;
                firstN.next = prev;
            }
        }


        return head;
    }


    public static ListNode removeElements(ListNode head, int val) {

        ListNode curr = head;
        int i =0;
        ListNode prev = null;
        while(curr != null){
            if(curr.val == val) {
                if (curr == head) {
                    head = curr.next;
                } else {
                    prev.next = curr.next;
                }
            } else {
                prev = curr;

            }
            curr = curr.next;
            ++i;
        }
        return  head;
    }

    public static ListNode getLinkedListFromString(String s){
        ListNode head = null;
        String[] strArray = s.split(",");
        ListNode prev = null;
        for (String str:strArray) {
            ListNode l = new ListNode(Integer.parseInt(str));
            if(head == null){
                head = l;
            }
            if(prev != null){
                prev.next = l;
            }
            prev  = l;
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode ll = getLinkedListFromString("1,2,3,4,5,6,7");
        print(ll);

        ListNode[] splitArr = splitListToParts(ll,3);
        for (ListNode sl:splitArr) {
            System.out.println("=========================");
            print(sl);
            System.out.println("=========================");
        }

        ListNode l1 = getLinkedListFromString("1,2,4");
        ListNode l2 = getLinkedListFromString("1,3,4");
        LinkedListUtil.mergeTwoLists(l1,l2);
    }

    public static void testSplit(){

    }
    public static ListNode deleteDuplicates(ListNode head) {

        if(head == null || head.next == null)
            return head;
        ListNode inHead=head;
        ListNode prev=null;
        while(head != null){
            int val =head.val;

            if(head.next != null && head.next.val== val) {
                while (head != null && head.val == val) {
                    head = head.next;
                }
                if(prev != null){
                    prev.next = head;
                } else{
                    inHead = head;
                }
            } else {
                prev = head;
                head = head.next;
            }


        }
        return inHead;
    }

    public static ListNode middleNode(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return head;
        ListNode h = head;
        int count = 0;
        while(h != null){
            ++ count;
            h = h.next;
        }

        int idx = count/2;
        h =head;
        for (int i=0;i<idx;i++){
            h = h.next;
        }
        System.out.println("Middele elem" + idx);

        return h;
    }


    public static ListNode deleteDuplicatesSort(ListNode head) {
        if(head == null || head.next == null )
            return head;

        ListNode inHead=head;
        while(head != null) {
            int val = head.val;
            if(head.next != null && head.next.val == val){
                if(head.next.next != null)
                    head.next = head.next.next;
                else
                    head.next = null;
            } else {
                head = head.next;
            }
        }
        return inHead;
    }

    public ListNode deleteDuplicatesLC(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }


    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || k==0 ){
            return head;
        }
        int count  = 0;
        ListNode current = head;
        ListNode prev = null;
        while(current != null){
            count++;
            prev = current;
            current = current.next;
        }



        int r = k%count;
        if(count == 1 || r == 0)
            return head;

        current = head;
        int idx = count -r;
        for(int i=1;i<idx;i++) {
            current = current.next;
        }
        ListNode tmpHead = head;
        tmpHead = current.next;
        current.next = null;
        prev.next=head;
        head = tmpHead;
        return head;
    }




    public static ListNode[] splitListToParts(ListNode root, int k) {

        ListNode[] splitArray = new ListNode[k];

        ListNode current = root;
        int count = 0;
        while(current != null){
            ++count;
            current = current.next;
        }

        int cntInEachArray = count/k;
        int leftOvers = count%k;

        current = root;


        int idx = 0;
        while(current != null){
            int arrayLength = cntInEachArray;
            if(leftOvers>0 && idx < leftOvers){
                ++arrayLength;
            }
            ListNode f = current;
            ListNode prev = null;
            for(int i =0;i<arrayLength;i++){
                prev = current;
                current = current.next;
            }

            prev.next = null;
           splitArray[idx] = f;
           ++idx;
        }

        return splitArray;
    }

/*
https://leetcode.com/problems/merge-two-sorted-lists/
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

 */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null)
            return null;
        if(l1 == null )
            return l2;
        if(l2 == null)
            return l1;
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode head = new ListNode(0);
        ListNode p = head;

        while(t1 != null && t2 != null){
           if(t1.val < t2.val){
               p.next = t1;
               t1 = t1.next;
           } else {
               p.next = t2;
               t2 = t2.next;
           }
           p = p.next;
        }

        if(t1!=null)
            p.next = t1;
        if(t2 != null)
            p.next = t2;
        return head.next;
    }


}

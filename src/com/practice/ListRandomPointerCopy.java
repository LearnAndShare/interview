package com.practice;

import java.util.HashMap;
import java.util.Map;

public class ListRandomPointerCopy {
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };

    public Node copyRandomList(Node head) {
        if(head == null )
            return null;
        Node newHead = new Node();
        newHead.val = head.val;
        Map<Node,Node> m = new HashMap<>();
        m.put(head,newHead);
        Node p = head.next;
        Node q = newHead;
        while(p != null){
            Node temp = new Node();
           temp.val = p.val;
           m.put(p,temp);
           q.next = temp;
           q = q.next;
           p = p.next;
        }

        //Random Pointers adjustment
        p = head;
        q = newHead;
        while(p!= null){
            if(p.random != null) {
                q.random = m.get(p.random);
            } else {
                q.random = null;
            }
            p = p.next;
            q=q.next;

        }
        return newHead;

    }

}

package com.practice.linkedlist;

import java.util.HashMap;

/*
https://leetcode.com/problems/copy-list-with-random-pointer/

138. Copy List with Random Pointer

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.



Complexity Analysis
Time Complexity :O(N) because we make one pass over the original linked list.
Space Complexity :O(N) as we have a dictionary containing mapping from old list nodes to new list nodes. Since there are
N nodes, we have O(N) space complexity.


 */
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

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    };

    HashMap<Node, Node> visited = new HashMap<Node, Node>();

    public Node getClonedNode(Node node) {
        // If the node exists then
        if (node != null) {
            // Check if the node is in the visited dictionary
            if (this.visited.containsKey(node)) {
                // If its in the visited dictionary then return the new node reference from the dictionary
                return this.visited.get(node);
            } else {
                // Otherwise create a new node, add to the dictionary and return it
                this.visited.put(node, new Node(node.val, null, null));
                return this.visited.get(node);
            }
        }
        return null;
    }

    /*
    Instead of a separate dictionary to keep the old node --> new node mapping, we can tweak the original linked list
    and keep every cloned node next to its original node. This interleaving of old and new nodes allows us to
    solve this problem without any extra space. Lets look at how the algorithm works.
Algorithm
Step 1: Traverse the original list and clone the nodes as you go and place the cloned copy next to its original node.
This new linked list is essentially a interweaving of original and cloned nodes.
Step 2: Iterate the list having both the new and old nodes intertwined with each other and use the original nodes'
random pointers to assign references to random pointers for cloned nodes.
For eg. If B has a random pointer to A, this means B' has a random pointer to A'.
Step 3: Now that the random pointers are assigned to the correct node, the next pointers need to be correctly assigned to
unweave the current linked list and get back the original list and the cloned list.
    Time Complexity : O(N)
Space Complexity : O(1)
     */

    public Node copyRandomListO1Space(Node head) {

        if (head == null) {
            return null;
        }

        Node oldNode = head;

        // Creating the new head node.
        Node newNode = new Node(oldNode.val);
        this.visited.put(oldNode, newNode);

        // Iterate on the linked list until all nodes are cloned.
        while (oldNode != null) {
            // Get the clones of the nodes referenced by random and next pointers.
            newNode.random = this.getClonedNode(oldNode.random);
            newNode.next = this.getClonedNode(oldNode.next);

            // Move one step ahead in the linked list.
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return this.visited.get(head);
    }


    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        // Creating a new weaved list of original and copied nodes.
        Node ptr = head;
        while (ptr != null) {

            // Cloned node
            Node newNode = new Node(ptr.val);

            // Inserting the cloned node just next to the original node.
            // If A->B->C is the original linked list,
            // Linked list after weaving cloned nodes would be A->A'->B->B'->C->C'
            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = newNode.next;
        }

        ptr = head;

        // Now link the random pointers of the new nodes created.
        // Iterate the newly created list and use the original nodes' random pointers,
        // to assign references to random pointers for cloned nodes.
        while (ptr != null) {
            ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
            ptr = ptr.next.next;
        }

        // Unweave the linked list to get back the original linked list and the cloned list.
        // i.e. A->A'->B->B'->C->C' would be broken to A->B->C and A'->B'->C'
        Node ptr_old_list = head; // A->B->C
        Node ptr_new_list = head.next; // A'->B'->C'
        Node head_old = head.next;
        while (ptr_old_list != null) {
            ptr_old_list.next = ptr_old_list.next.next;
            ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : null;
            ptr_old_list = ptr_old_list.next;
            ptr_new_list = ptr_new_list.next;
        }
        return head_old;
    }

}

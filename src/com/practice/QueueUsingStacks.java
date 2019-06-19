package com.practice;

import java.util.Stack;

public class QueueUsingStacks {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        populateSecondStack();
        return s2.pop();
    }

    private void populateSecondStack() {
        if(s2.isEmpty()) {
            while (!s1.isEmpty())
                s2.push(s1.pop());
        }
    }

    /** Get the front element. */
    public int peek() {
        populateSecondStack();
        return s2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStacks q = new QueueUsingStacks();
        q.push(1);
        q.push(2);
        System.out.println(q.peek());
        System.out.println(q.pop());
        System.out.println(q.empty());
    }
}

package com.practice;

import java.util.LinkedList;

public class StackUsinqQueue {
    LinkedList<Integer> queue = new LinkedList<>();
    /** Push element x onto stack. */
    void push(int x) {
        queue.push(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    int pop() {
        return  queue.pop();
    }

    /** Get the top element. */
    int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        StackUsinqQueue stack  = new StackUsinqQueue();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
}
